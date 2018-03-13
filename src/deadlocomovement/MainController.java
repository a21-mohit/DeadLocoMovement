/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlocomovement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Mohit Arora <a21.mohit@gmail.com>
 */
public class MainController {
    private final MainView theView;
    private final MainModel theModel;
    MainController(MainView theView, MainModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        this.theView.setNewActionListener(new NewAL());
        this.theView.setModifyActionListener(new ModifyAL());
        this.theView.setDeleteActionListener(new DeleteAL());
        this.theView.setHandoverActionListener(new HandoverAL());
        this.theView.setTabbedPanelChangeListener(new TabCL());
        this.theView.setCHTListSelectionListener(new CHTLSL());
        this.theView.setTOverRadioActionListener(new TOverRAL());
        this.theView.setHOverRadioActionListener(new HOverRAL());
        this.theView.setResetActionListener(new ResetAL());
        this.theView.setFilterActionListener(new FilterAL());
    }
    
    class TabCL implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            int tab = theView.getSelectedTab(); //To change body of generated methods, choose Tools | Templates.
            if(tab == 0){
                theView.setCurrentHoldingsTable(theModel.getCurrentHoldingsTable());
            }
            else if(tab == 1){
                theView.setHandoverTable(theModel.getHandoverTable());
                if(theView.getFilterPanelSelection() == null)
                    theView.clearFilterPanel();
            }
        }
    }
    
    class NewAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer option = theView.showNewRecordDialog(theModel.gettOverPlaceArray(),new TOPLSL());
            if(option == JOptionPane.OK_OPTION){
                HoldingsRecord recordData = theView.getrecordData();
                if (recordData.checkEmpty()){
                    theView.showErrorMessage("All fields are mandatory!");
                } else {
                    if (theModel.checkCurrentHoldingRecordExist(recordData)){
                        theView.showErrorMessage("Entry already exists!");
                    } else {
                        if (recordData.getLocoNo().length() < 5) {
                            theView.showErrorMessage("Invalid LocoNo!");
                        } else {
                            LocalDateTime tOverDateTime = recordData.gettOverDateTime();
                            LocalDateTime current = LocalDateTime.now();
                            if(tOverDateTime.compareTo(current) > 0){
                                theView.showErrorMessage("Invalid Date Time pair!");
                            } else {
                                theModel.insertCurrentHoldingRecord(recordData);
                                theView.setCurrentHoldingsTable(theModel.getCurrentHoldingsTable());
                            }
                        }
                    }
                }
            }
        }
    }
    
    class ModifyAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer oldLocoNo = theView.getCurrentHoldingsLocoSelection();
            if ( oldLocoNo == null ){
                theView.showErrorMessage("Record doesn't exist!");
            }
            else {
                int option = theView.showModifyRecordDialog(theModel.getCurrentHoldingRecord(theView.getCurrentHoldingsLocoSelection()), theModel.gettOverPlaceArray(),new TOPLSL());
                if (option == JOptionPane.OK_OPTION) {
                    HoldingsRecord recordData = theView.getrecordData();
                    if (recordData.checkEmpty()) {
                        theView.showErrorMessage("All fields are mandatory!");
                    } else {
                        if (recordData.getLocoNo().length() < 5) {
                            theView.showErrorMessage("Invalid LocoNo!");
                        } else {
                            if (recordData.getLocoNo().length() < 5) {
                                theView.showErrorMessage("Invalid LocoNo!");
                            } else {
                                LocalDateTime tOverDateTime = recordData.gettOverDateTime();
                                LocalDateTime current = LocalDateTime.now();
                                if (tOverDateTime.compareTo(current) > 0) {
                                    theView.showErrorMessage("Invalid Date Time pair!");
                                } else {
                                    theModel.updateCurrentHoldingRecord(oldLocoNo, recordData);
                                    theView.setCurrentHoldingsTable(theModel.getCurrentHoldingsTable());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    class DeleteAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int option = theView.showDeleteRecordDialog();
            if (option == JOptionPane.OK_OPTION){
                theModel.deleteCurrentHoldingRecord(theView.getCurrentHoldingsLocoSelection());
                theView.setCurrentHoldingsTable(theModel.getCurrentHoldingsTable());
            }
        }
    }
    
    class HandoverAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer LocoToHandover = theView.getLocoToHandover();
            if (LocoToHandover != null){
                HoldingsRecord recordData = theModel.getCurrentHoldingRecord(LocoToHandover);
                if (recordData == null){
                    theView.showErrorMessage("Record doesn't exist!");
                } else {
                    int option = theView.showHandoverRecordDialog(recordData, theModel.gethOverPlaceArray());
                    if (option == JOptionPane.OK_OPTION) {
                        HandoverRecord hRecordData = theView.gethRecordData();
                        if (hRecordData.checkEmpty()) {
                            theView.showErrorMessage("All fields are mandatory!");
                        } else if (recordData.gettOverDateTime().compareTo(hRecordData.gethOverDateTime()) > 0) {
                            theView.showErrorMessage("Invalid Date Time pair!");
                        } else {
                            long duration = ChronoUnit.MINUTES.between(recordData.gettOverDateTime(), hRecordData.gethOverDateTime());
                            long hours = duration / 60;
                            long mins = duration % 60;
                            String ttime = String.format("%02d:%02d", hours, mins);
                            System.out.println(ttime);
                            theModel.handoverCurrentHoldingRecord(hRecordData, ttime);
                            theView.setCurrentHoldingsTable(theModel.getCurrentHoldingsTable());
                        }
                    }
                }
            }
        }
    }
    
    class TOPLSL implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (theView.getTOverSelection().equals("NGP DIV")) {
                theView.enableNGPDIV();
            } else {
                theView.disableNGPDIV();
            }
        }
        
    }
    
    class CHTLSL implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            if(!lsm.isSelectionEmpty()){
                theView.enableModifyDelete();
            } else {
                theView.disableModifyDelete();
            }
        }
        
    }
    
    class TOverRAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.setMyListModel(theModel.gettOverPlaceArray());
            theView.enableFilter();
        }
        
    }
    
    class HOverRAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.setMyListModel(theModel.gethOverPlaceArray());
            theView.enableFilter();
        }
        
    }
    
    class ResetAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.clearFilterPanel();
            theView.setHandoverTable(theModel.getHandoverTable());
        }
    }
    
    class FilterAL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FilterRecord fRecordData = theView.getFilterRecord();
            if(fRecordData.checkEmpty()){
                theView.showErrorMessage("Invalid filter request!");
            } else {
                theView.setHandoverTable(theModel.getHandoverTable(fRecordData));
            }
        }
    }
    
}
