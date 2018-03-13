/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlocomovement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Mohit Arora <a21.mohit@gmail.com>
 */
public class HandoverRecord {
    private String LocoNo;
    private String hOverPlace;
    private Date hOverDate;
    private String hOverTime;
    private LocalDateTime hOverDateTime;
    
    public String getLocoNo() {
        return LocoNo;
    }

    public void setLocoNo(String LocoNo) {
        this.LocoNo = LocoNo;
    }

    public String gethOverPlace() {
        return hOverPlace;
    }

    public void sethOverPlace(String hOverPlace) {
        this.hOverPlace = hOverPlace;
    }

    public Date gethOverDate() {
        return hOverDate;
    }

    public void sethOverDate(Date hOverDate) {
        this.hOverDate = hOverDate;
    }

    public String gethOverTime() {
        return hOverTime;
    }

    public void sethOverTime(String hOverTime) {
        this.hOverTime = hOverTime;
    }
    
    public LocalDateTime gethOverDateTime() {
        LocalDate date = hOverDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime time = LocalTime.parse(hOverTime);
        hOverDateTime = LocalDateTime.of(date, time);
        return hOverDateTime;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("LocoNo: ");
        sb.append(LocoNo);
        sb.append(", Handover Place: ");
        sb.append(hOverPlace);
        sb.append(", Handover DateTime: ");
        sb.append(hOverDateTime.toString());
        return sb.toString();
    }
    
    public Boolean checkEmpty(){
        return LocoNo.isEmpty() || hOverPlace.isEmpty() || hOverTime.isEmpty();           
    }
}
