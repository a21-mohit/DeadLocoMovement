/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlocomovement;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainDocument;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Mohit Arora <a21.mohit@gmail.com>
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    private javax.swing.JLabel startDate;
    private javax.swing.JLabel endDate;
    private UtilDateModel startDateModel;
    private UtilDateModel endDateModel;
    private JDatePickerImpl startDatePicker;
    private JDatePickerImpl endDatePicker;
    private JTextField LocoNoField;
    private JTextField base;
    private ButtonGroup rg;
    private JRadioButton dead;
    private JRadioButton fail;
    private JTextField reason;
    private JList<String> tOverPlace;
    private JTextField ngpdiv;
    private UtilDateModel model;
    private JDatePickerImpl tOverDate;
    private JTextField tOverTime;
    private JList<String> hOverPlace;
    private JDatePickerImpl hOverDate;
    private JTextField hOverTime;
    private JTextField currentLocation;
    private final DefaultTableModel currentHoldingsTableModel;
    private final DefaultTableModel handoverTableModel;
    private final ListSelectionModel currentHoldingsListSelectionModel;
    private Statement statement;
    private HoldingsRecord recordData;
    private HandoverRecord hRecordData;
    private FilterRecord fRecordData;
    
    public MainView() {
        initComponents();
        overrideFilterPanel();
        buttonGroup.add(tOverRadioButton);
        buttonGroup.add(hOverRadioButton);
        currentHoldingsTableModel = (DefaultTableModel) currentHoldingsTable.getModel();
        currentHoldingsListSelectionModel = currentHoldingsTable.getSelectionModel();
        handoverTableModel = (DefaultTableModel) handoverTable.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        holdingActionPanel = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        modify = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        handover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        currentHoldingsTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tOverRadioButton = new javax.swing.JRadioButton();
        hOverRadioButton = new javax.swing.JRadioButton();
        myList = new javax.swing.JComboBox();
        filter = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        handoverTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add.setText("New");

        modify.setText("Modify");

        delete.setText("Delete");

        handover.setText("Handover");

        javax.swing.GroupLayout holdingActionPanelLayout = new javax.swing.GroupLayout(holdingActionPanel);
        holdingActionPanel.setLayout(holdingActionPanelLayout);
        holdingActionPanelLayout.setHorizontalGroup(
            holdingActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(modify, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
            .addComponent(handover, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        holdingActionPanelLayout.setVerticalGroup(
            holdingActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(holdingActionPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(handover, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        currentHoldingsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sl", "LocoNo", "Base", "DEAD/FAIL", "Reason", "T-Over Place", "T-Over Date", "T-Over Time", "Current Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        currentHoldingsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(currentHoldingsTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(holdingActionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(holdingActionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Current Holdings", jPanel1);

        tOverRadioButton.setText("TOver");

        hOverRadioButton.setText("HOver");

        filter.setText("Filter");

        reset.setText("Reset");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tOverRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hOverRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myList, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(629, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tOverRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hOverRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(myList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter)
                    .addComponent(reset))
                .addContainerGap())
        );

        handoverTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sl", "LocoNo", "Base", "DEAD/FAIL", "Reason", "T-Over Place", "T-Over Date", "T-Over Time", "H-Over Place", "H-Over Date", "H-Over Time", "Transit Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        handoverTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(handoverTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Handover Chart", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void overrideFilterPanel(){
        startDate = new javax.swing.JLabel("Start Date:");
        endDate = new javax.swing.JLabel("End Date:");
        startDateModel = new UtilDateModel();
        endDateModel = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl startDatePanel = new JDatePanelImpl(startDateModel, p);
        JDatePanelImpl endDatePanel = new JDatePanelImpl(endDateModel, p);
        startDatePicker = new JDatePickerImpl(startDatePanel, new DateLabelFormatter());
        endDatePicker = new JDatePickerImpl(endDatePanel, new DateLabelFormatter());
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tOverRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hOverRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myList, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(454, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tOverRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hOverRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(myList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDate)
                    .addComponent(startDatePicker)
                    .addComponent(endDate)
                    .addComponent(endDatePicker)
                    .addComponent(filter)
                    .addComponent(reset))
                .addContainerGap())
        );
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    public Integer getSelectedTab(){
        return jTabbedPane1.getSelectedIndex();
    }
    
    public void setCurrentHoldingsTable(ResultSet result){
        disableModifyDelete();
        try {
            currentHoldingsTableModel.setRowCount(0);
            Integer i = 1;
            while (result.next()) {
                currentHoldingsTableModel.addRow(new Object[]{i, result.getInt("LocoNo"), result.getString("Base"), result.getString("DEAD_OR_FAIL"), result.getString("Reason"), result.getString("TOver_Place"), formatSQLDateToViewDate(result.getString("TOver_DateTime")), result.getString("TOver_DateTime").substring(11, 16), result.getString("CURRENT_LOCATION")});
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setHandoverTable(ResultSet result){
        try {
            handoverTableModel.setRowCount(0);
            Integer i = 1;
            while (result.next()) {
                handoverTableModel.addRow(new Object[]{i, result.getInt("LocoNo"), result.getString("Base"), result.getString("DEAD_OR_FAIL"), result.getString("Reason"), result.getString("TOver_Place"), formatSQLDateToViewDate(result.getString("TOver_DateTime")), result.getString("TOver_DateTime").substring(11, 16), result.getString("HOver_Place"), formatSQLDateToViewDate(result.getString("HOver_DateTime")), result.getString("HOver_DateTime").substring(11, 16), result.getString("Transit_time")});
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setHandoverFilterDates(Date date1,Date date2){
        startDateModel.setValue(date1);
        endDateModel.setValue(date2);
    }
    
    public Integer getCurrentHoldingsLocoSelection(){
        return (Integer) currentHoldingsTableModel.getValueAt(currentHoldingsTable.getSelectedRow(), 1);
    }
    
    public void deleteCurrentHoldingsTableRow(Integer i){
        currentHoldingsTableModel.removeRow(i);
    }
    
    public void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public Integer showNewRecordDialog(String[] tOverPlaceArray,ListSelectionListener a){
        initializeOptionpane(a);
        model.setValue(new Date());
        tOverPlace.setListData(tOverPlaceArray);
        Object[] message = {
            "LocoNo:", LocoNoField,
            "Base:", base,
            "DEAD/FAIL:", dead, fail,
            "Reason:", reason,
            "T-Over Place:", tOverPlace,
            "NGP-DIV location:", ngpdiv,
            "T-Over Date:", tOverDate,
            "T-Over Time:", tOverTime,
            "Current Location", currentLocation
        };
        int option = JOptionPane.showConfirmDialog(null, message, "New record", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION){
            recordData = new HoldingsRecord();
            recordData.setLocoNo(LocoNoField.getText());
            recordData.setBase(base.getText().toUpperCase());
            Enumeration<AbstractButton> elements = rg.getElements();
            while(elements.hasMoreElements()){
                AbstractButton button = elements.nextElement();
                if(button.isSelected()){
                    recordData.setStatus(button.getText().toUpperCase());
                    break;
                }
            }
            recordData.setReason(reason.getText().toUpperCase());
            if (tOverPlace.getSelectedValue() == null){
                recordData.settOverPlace("");
            }
            else if (tOverPlace.getSelectedValue().equals("NGP DIV")) {
                recordData.settOverPlace(tOverPlace.getSelectedValue().toUpperCase()+"-"+ngpdiv.getText().toUpperCase());
            } else {
                recordData.settOverPlace(tOverPlace.getSelectedValue().toUpperCase());
            }
            recordData.settOverDate(model.getValue());
            recordData.settOverTime(tOverTime.getText());
            recordData.setCurrentLocation(currentLocation.getText().toUpperCase());
        }
        return option;
    }
    
    public HoldingsRecord getrecordData(){
        return recordData;
    }
    
    public HandoverRecord gethRecordData(){
        return hRecordData;
    }
    
    public Integer showModifyRecordDialog(HoldingsRecord hr,String[] tOverPlaceArray,ListSelectionListener a){
        initializeOptionpane(a);
        LocoNoField.setText(hr.getLocoNo());
        base.setText(hr.getBase());
        Enumeration<AbstractButton> elements = rg.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton nextElement = elements.nextElement();
            if (nextElement.getText().equals(hr.getStatus())) {
                nextElement.setSelected(true);
            }
        }
        reason.setText(hr.getReason());
        tOverPlace.setListData(tOverPlaceArray);
         for (int i = 0; i < tOverPlaceArray.length; i++) {
            if (tOverPlaceArray[i].equals(hr.gettOverPlace())) {
                tOverPlace.setSelectedIndex(i);
            } else if(hr.gettOverPlace().startsWith("NGP DIV")) {
                tOverPlace.setSelectedValue("NGP DIV", false);
                ngpdiv.setText(hr.gettOverPlace().substring(8).toUpperCase());
            }
        }
        model.setValue(hr.gettOverDate());
        tOverTime.setText(hr.gettOverTime());
        currentLocation.setText(hr.getCurrentLocation());
        Object[] message = {
            "LocoNo:", LocoNoField,
            "Base:", base,
            "DEAD/FAIL:", dead, fail,
            "Reason:", reason,
            "T-Over Place:", tOverPlace,
            "NGP-DIV location:", ngpdiv,
            "T-Over Date:", tOverDate,
            "T-Over Time:", tOverTime,
            "Current Location", currentLocation
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Update record", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION){
            recordData = new HoldingsRecord();
            recordData.setLocoNo(LocoNoField.getText());
            recordData.setBase(base.getText().toUpperCase());
            elements = rg.getElements();
            while(elements.hasMoreElements()){
                AbstractButton button = elements.nextElement();
                if(button.isSelected()){
                    recordData.setStatus(button.getText().toUpperCase());
                    break;
                }
            }
            recordData.setReason(reason.getText().toUpperCase());
            if (tOverPlace.getSelectedValue() == null){
                recordData.settOverPlace("");
            }
            else if (tOverPlace.getSelectedValue().equals("NGP DIV")) {
                recordData.settOverPlace(tOverPlace.getSelectedValue().toUpperCase()+"-"+ngpdiv.getText().toUpperCase());
            } else {
                recordData.settOverPlace(tOverPlace.getSelectedValue().toUpperCase());
            }
            recordData.settOverDate(model.getValue());
            recordData.settOverTime(tOverTime.getText());
            recordData.setCurrentLocation(currentLocation.getText().toUpperCase());
        }
        return option;
    }
    
    public Integer showDeleteRecordDialog(){
        int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete record", JOptionPane.OK_CANCEL_OPTION);
        return option;
    }
    
    public Integer getLocoToHandover(){
        LocoNoField = new JTextField();
        LocoNoField.addAncestorListener(new RequestFocusListener());
        PlainDocument LocoNoFielddoc = (PlainDocument) LocoNoField.getDocument();
        LocoNoFielddoc.setDocumentFilter(new MyIntFilter());
        int option = JOptionPane.showConfirmDialog(null, new Object[]{"LocoNo:", LocoNoField}, "Handover which loco?", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION){
            return Integer.parseInt(LocoNoField.getText());
        }
        return null;
    }
    
    public FilterRecord getFilterRecord(){
        fRecordData = new FilterRecord();
        if (getFilterPanelSelection() == null){
            fRecordData.setSelection("");
        } else {
            fRecordData.setSelection(getFilterPanelSelection());
        }
        if (myList.getSelectedItem() == null){
            fRecordData.setPlace("");
        } else {
            fRecordData.setPlace((String) myList.getSelectedItem());
        }
        fRecordData.setStartDate(startDateModel.getValue());
        fRecordData.setEndDate(endDateModel.getValue());
        return fRecordData;
    }
    
    public Integer showHandoverRecordDialog(HoldingsRecord hr,String[] hOverPlaceArray){
        LocoNoField = new JTextField();
        LocoNoField.setText(hr.getLocoNo());
        LocoNoField.setEditable(Boolean.FALSE);
        hOverPlace = new JList<>(hOverPlaceArray);
        hOverPlace.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model, p);
        model.setValue(new Date());
        hOverDate = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        hOverTime = new JTextField();
        PlainDocument hOverTimedoc = (PlainDocument) hOverTime.getDocument();
        hOverTimedoc.setDocumentFilter(new MyTimeFilter());
        Object[] message = {
            "LocoNo:", LocoNoField,
            "H-Over Place:", hOverPlace,
            "H-Over Date:", hOverDate,
            "H-Over Time:", hOverTime
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Handover", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION){
            hRecordData = new HandoverRecord();
            hRecordData.setLocoNo(LocoNoField.getText());
            if (hOverPlace.getSelectedValue() == null){
                hRecordData.sethOverPlace("");
            }
            else {
                hRecordData.sethOverPlace(hOverPlace.getSelectedValue().toUpperCase());
            }
            hRecordData.sethOverDate(model.getValue());
            hRecordData.sethOverTime(hOverTime.getText());
        }
        return option;
    }
    
    public String getFilterPanelSelection(){
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while(buttons.hasMoreElements()){
            AbstractButton nextElement = buttons.nextElement();
            if(nextElement.isSelected()){
                return nextElement.getText();
            }
        }
        return null;
    }
    
    public String getTOverSelection(){
        return tOverPlace.getSelectedValue();
    }
    
    public void enableNGPDIV(){
        ngpdiv.setEnabled(true);
    }
    
    public void disableNGPDIV(){
        ngpdiv.setEnabled(false);
    }
    
    public void setMyListModel(String[] array){
        myList.setModel(new DefaultComboBoxModel(array));
    }
    
    public void setTabbedPanelChangeListener(ChangeListener a){
        jTabbedPane1.addChangeListener(a);
    }
    
    public void setCHTListSelectionListener(ListSelectionListener a){
        currentHoldingsListSelectionModel.addListSelectionListener(a);
    }
    
    public void enableModifyDelete(){
        modify.setEnabled(true);
        delete.setEnabled(true);
    }
    
    public void disableModifyDelete(){
        modify.setEnabled(false);
        delete.setEnabled(false);
    }
    
    public void enableFilter(){
        filter.setEnabled(true);
    }
    
    public void disableFilter(){
        filter.setEnabled(false);
    }
    
    public void clearFilterPanel(){
        disableFilter();
        setHandoverFilterDates(new Date(), new Date());
        buttonGroup.clearSelection();
        myList.setModel(new DefaultComboBoxModel(new String[] {}));
    }
    
    public void setNewActionListener(ActionListener a){
        add.addActionListener(a);
    }
    
    public void setModifyActionListener(ActionListener a){
        modify.addActionListener(a);
    }
    
    public void setDeleteActionListener(ActionListener a){
        delete.addActionListener(a);
    }
    
    public void setHandoverActionListener(ActionListener a){
        handover.addActionListener(a);
    }
    
    public void setTOverRadioActionListener(ActionListener a){
        tOverRadioButton.addActionListener(a);
    }
    
    public void setHOverRadioActionListener(ActionListener a){
        hOverRadioButton.addActionListener(a);
    }
    
    public void setResetActionListener(ActionListener a){
        reset.addActionListener(a);
    }
    
    private String formatSQLDateToViewDate(String date) {
        return date.substring(8, 10) + date.substring(4, 8) + date.substring(0, 4);
    }

    private String dmy2ymd(String date) {
        return date.substring(6, 10) + date.substring(2, 6) + date.substring(0, 2);
    }
    
    private void initializeOptionpane(ListSelectionListener a) {
        LocoNoField = new JTextField();
        LocoNoField.addAncestorListener(new RequestFocusListener());
        PlainDocument LocoNoFielddoc = (PlainDocument) LocoNoField.getDocument();
        LocoNoFielddoc.setDocumentFilter(new MyIntFilter());
        base = new JTextField();
        rg = new ButtonGroup();
        dead = new JRadioButton("DEAD");
        fail = new JRadioButton("FAIL");
        rg.add(dead);
        rg.add(fail);
        reason = new JTextField();
        tOverPlace = new JList<>();
        tOverPlace.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ngpdiv = new JTextField();
        ngpdiv.setEnabled(false);
        tOverPlace.addListSelectionListener(a);
        model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        tOverDate = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        tOverTime = new JTextField();
        PlainDocument tOverTimedoc = (PlainDocument) tOverTime.getDocument();
        tOverTimedoc.setDocumentFilter(new MyTimeFilter());
        currentLocation = new JTextField();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JTable currentHoldingsTable;
    private javax.swing.JButton delete;
    private javax.swing.JButton filter;
    private javax.swing.JRadioButton hOverRadioButton;
    private javax.swing.JButton handover;
    private javax.swing.JTable handoverTable;
    private javax.swing.JPanel holdingActionPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton modify;
    private javax.swing.JComboBox myList;
    private javax.swing.JButton reset;
    private javax.swing.JRadioButton tOverRadioButton;
    // End of variables declaration//GEN-END:variables

    public void setFilterActionListener(ActionListener a) {
        filter.addActionListener(a);
    }
}
