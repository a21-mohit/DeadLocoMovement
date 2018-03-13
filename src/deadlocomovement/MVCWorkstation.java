/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlocomovement;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Mohit Arora <a21.mohit@gmail.com>
 */
public class MVCWorkstation {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MVCWorkstation.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainView theView = new MainView();
        MainModel theModel = new MainModel();
        theView.setTitle("Dead Loco Movement");
        theView.setCurrentHoldingsTable(theModel.getCurrentHoldingsTable());
        theView.setHandoverFilterDates(new Date(), new Date());
        MainController theController = new MainController(theView,theModel);
        theView.setVisible(true);
    }
}
