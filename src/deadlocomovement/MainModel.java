/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlocomovement;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohit Arora <a21.mohit@gmail.com>
 */

public class MainModel {
    
    private Connection conn;
    private ResultSet result;
    private String[] hOverPlaceArray = new String[]{"WCR", "BD", "CNDB", "SECR", "SCR", "TS", "ELS"};
    private String[] tOverPlaceArray = new String[]{"WCR", "BD", "CNDB", "SECR", "SCR", "NGP DIV"};
    public MainModel(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workstation?zeroDateTimeBehavior=convertToNull", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] gethOverPlaceArray() {
        return hOverPlaceArray;
    }

    public void sethOverPlaceArray(String[] hOverPlaceArray) {
        this.hOverPlaceArray = hOverPlaceArray;
    }

    public String[] gettOverPlaceArray() {
        return tOverPlaceArray;
    }

    public void settOverPlaceArray(String[] tOverPlaceArray) {
        this.tOverPlaceArray = tOverPlaceArray;
    }
    
    public ResultSet getCurrentHoldingsTable(){
        try {
            Statement statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM initial");
            
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ResultSet getHandoverTable(){
        try {
            Statement statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM handover ORDER BY LocoNo;");
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ResultSet getHandoverTable(FilterRecord r){
        //long halfDayDeviation = 43200000;
        //long oneMinuteDeviation = 60000;
        try {
            String sql = null;
            if("TOver".equals(r.getSelection())){
                sql = "SELECT * FROM handover WHERE TOver_Place LIKE ? AND TOver_DateTime BETWEEN ? AND ?;";
            } else if("HOver".equals(r.getSelection())){
                sql = "SELECT * FROM handover WHERE HOver_Place LIKE ? AND HOver_DateTime BETWEEN ? AND ?;";
            }
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, r.getPlace()+"%");
            /*long adjustedStartDate = r.getStartDate().getTime()-halfDayDeviation;
            long adjustedEndDate = r.getEndDate().getTime()+halfDayDeviation-oneMinuteDeviation;
            pStatement.setTimestamp(2, new java.sql.Timestamp(adjustedStartDate));
            pStatement.setTimestamp(3, new java.sql.Timestamp(adjustedEndDate));*/
            pStatement.setTimestamp(2, Timestamp.valueOf(r.getStartDateTime()));
            pStatement.setTimestamp(3, Timestamp.valueOf(r.getEndDateTime()));
            result = pStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void insertCurrentHoldingRecord(HoldingsRecord recordData){
        try {
            String sql = "INSERT INTO initial VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, recordData.getLocoNo());
            pStatement.setString(2, recordData.getBase());
            pStatement.setString(3, recordData.getStatus());
            pStatement.setString(4, recordData.getReason());
            pStatement.setString(5, recordData.gettOverPlace());
            pStatement.setTimestamp(6, Timestamp.valueOf(recordData.gettOverDateTime()));
            pStatement.setString(7, recordData.getCurrentLocation());
            pStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateCurrentHoldingRecord(Integer oldLocoNo,HoldingsRecord recordData){
        try {
            String sql = "UPDATE initial SET LocoNo=?,Base=?,DEAD_OR_FAIL=?,Reason=?,TOver_Place=?,TOver_DateTime=?,CURRENT_LOCATION=? WHERE LocoNo=?";
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, recordData.getLocoNo());
            pStatement.setString(2, recordData.getBase());
            pStatement.setString(3, recordData.getStatus());
            pStatement.setString(4, recordData.getReason());
            pStatement.setString(5, recordData.gettOverPlace());
            pStatement.setTimestamp(6, Timestamp.valueOf(recordData.gettOverDateTime()));
            pStatement.setString(7, recordData.getCurrentLocation());
            pStatement.setString(8, oldLocoNo.toString());
            pStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void handoverCurrentHoldingRecord(HandoverRecord hRecordData,String ttime){
        try {
            String insert = "INSERT INTO handover (LocoNo,Base,DEAD_OR_FAIL,Reason,TOver_Place,TOver_DateTime,HOver_Place,HOver_DateTime,Transit_time) SELECT LocoNo,Base,DEAD_OR_FAIL,Reason,TOver_Place,TOver_DateTime,?,?,? FROM initial WHERE LocoNo = ?";
            PreparedStatement pStatement = conn.prepareStatement(insert);
            Statement statement = conn.createStatement();
            pStatement.setString(1, hRecordData.gethOverPlace().toUpperCase());
            pStatement.setTimestamp(2, Timestamp.valueOf(hRecordData.gethOverDateTime()));
            pStatement.setString(3, ttime);
            pStatement.setInt(4, Integer.valueOf(hRecordData.getLocoNo()));
            pStatement.execute();
            statement.execute("DELETE FROM initial WHERE LocoNo =" + hRecordData.getLocoNo() + ";");
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Boolean checkCurrentHoldingRecordExist(HoldingsRecord recordData){
        try {
            Statement statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM initial WHERE LocoNo = "+recordData.getLocoNo()+" LIMIT 1;");
            if(result.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public HoldingsRecord getCurrentHoldingRecord(Integer LocoNo) {
        HoldingsRecord recordData = null;
        try {
            Statement statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM initial WHERE LocoNo = "+LocoNo+" LIMIT 1;");
            if(result.next()){
                recordData = new HoldingsRecord();
                recordData.setLocoNo(result.getString("LocoNo"));
                recordData.setBase(result.getString("Base"));
                recordData.setStatus(result.getString("DEAD_OR_FAIL"));
                recordData.setReason(result.getString("Reason"));
                recordData.settOverPlace(result.getString("TOver_Place"));
                recordData.settOverDate(result.getString("TOver_DateTime"));
                recordData.settOverTime(result.getString("TOver_DateTime").substring(11, 16));
                recordData.setCurrentLocation(result.getString("CURRENT_LOCATION"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recordData;
    }
    
    public void deleteCurrentHoldingRecord(Integer LocoNo){
        try {
            Statement statement = conn.createStatement();
            statement.execute("DELETE FROM initial WHERE LocoNo = "+LocoNo+";");
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
