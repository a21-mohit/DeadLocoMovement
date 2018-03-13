/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlocomovement;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Neha Arora
 */
class MyTimeFilter extends DocumentFilter {
   @Override
   public void insertString(DocumentFilter.FilterBypass fb, int offset, String string,
         AttributeSet attr) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.insert(offset, string);

      if (test(sb.toString())) {
         super.insertString(fb, offset, string, attr);
      } else {
         // warn the user and don't allow the insert
      }
   }

   private boolean test(String text) {
        if(text.length()==0)
           return true;
        else if(text.length() == 1)
            try {
                if(Integer.parseInt(text) <= 2)
                    return true;
            } catch (NumberFormatException e) {
                return false;
            }
        else if(text.length() == 2)
            try {
                if(Integer.parseInt(text) < 24)
                    return true;
            } catch (NumberFormatException e) {
                return false;
            }
        else if(text.length() == 3){
            try {
                if(Integer.parseInt(text.substring(0, 2)) < 24)
                    if(text.charAt(2) == ':')
                        return true;
            } catch (NumberFormatException e) {
                return false;
            }
            
        }
        else if(text.length() == 4){
            try {
                if(Integer.parseInt(text.substring(0, 2)) < 24)
                    if(text.charAt(2) == ':')
                        if(Integer.valueOf(String.valueOf(text.charAt(3))) < 6)
                            return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        else if(text.length() == 5){
            try {
                if(Integer.parseInt(text.substring(0, 2)) < 24)
                    if(text.charAt(2) == ':')
                        if(Integer.parseInt(text.substring(3, 5)) < 60)
                            return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
      return false;
   }

   @Override
   public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
         AttributeSet attrs) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.replace(offset, offset + length, text);
      //System.out.println(offset);
      if (test(sb.toString())) {
          if(offset == 1){
              text = new String(text+':');
          }
         super.replace(fb, offset, length, text, attrs);
      } else {
         // warn the user and don't allow the insert
      }

   }

   @Override
   public void remove(DocumentFilter.FilterBypass fb, int offset, int length)
         throws BadLocationException {
      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.delete(offset, offset + length);

      if (test(sb.toString())) {
         super.remove(fb, offset, length);
      } else {
         // warn the user and don't allow the insert
      }

   }
}
