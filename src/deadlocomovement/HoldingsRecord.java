/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlocomovement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohit Arora <a21.mohit@gmail.com>
 */
public class HoldingsRecord {
    private String LocoNo;
    private String base;
    private String status;
    private String reason;
    private String tOverPlace;
    private Date tOverDate;
    private String tOverTime;
    private LocalDateTime tOverDateTime;
    private String currentLocation;

    public String getLocoNo() {
        return LocoNo;
    }

    public void setLocoNo(String LocoNo) {
        this.LocoNo = LocoNo;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String gettOverPlace() {
        return tOverPlace;
    }

    public void settOverPlace(String tOverPlace) {
        this.tOverPlace = tOverPlace;
    }

    public Date gettOverDate() {
        return tOverDate;
    }

    public void settOverDate(String tOverDate) {
        try {
            this.tOverDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tOverDate);
        } catch (ParseException ex) {
            Logger.getLogger(HoldingsRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void settOverDate(Date tOverDate) {
        this.tOverDate = tOverDate;
    }

    public String gettOverTime() {
        return tOverTime;
    }

    public LocalDateTime gettOverDateTime() {
        LocalDate date = tOverDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime time = LocalTime.parse(tOverTime);
        tOverDateTime = LocalDateTime.of(date, time);
        return tOverDateTime;
    }

    public void settOverTime(String tOverTime) {
        this.tOverTime = tOverTime;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("LocoNo: ");
        sb.append(LocoNo);
        sb.append(", Base: ");
        sb.append(base);
        sb.append(", Status: ");
        sb.append(status);
        sb.append(", Reason: ");
        sb.append(reason);
        sb.append(", Takenover Place: ");
        sb.append(tOverPlace);
        sb.append(", Takenover DateTime: ");
        sb.append(tOverDateTime.toString());
        sb.append(", Current Location: ");
        sb.append(currentLocation);
        return sb.toString();
    }
    
    public Boolean checkEmpty(){
        return LocoNo.isEmpty() || base.isEmpty() || status.isEmpty() || reason.isEmpty() || tOverPlace.isEmpty() ||  tOverTime.isEmpty() || currentLocation.isEmpty();           
    }
}
