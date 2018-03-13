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
public class FilterRecord {
    private String selection;
    private String place;
    private Date startDate;
    private LocalDateTime startDateTime;
    private Date endDate;
    private LocalDateTime endDateTime;

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getStartDateTime() {
        LocalDate date = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime time = LocalTime.parse("00:00");
        startDateTime = LocalDateTime.of(date, time);
        return startDateTime;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getStartDate(){
        return startDate;
    }

    public LocalDateTime getEndDateTime() {
        LocalDate date = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime time = LocalTime.parse("23:59");
        endDateTime = LocalDateTime.of(date, time);
        return endDateTime;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public Date getEndDate(){
        return endDate;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Selection: ");
        sb.append(selection);
        sb.append(", Place: ");
        sb.append(place);
        sb.append(", StartDateTime: ");
        sb.append(startDateTime.toString());
        return sb.toString();
    }
    
    public Boolean checkEmpty(){
        return selection.isEmpty() || place.isEmpty();           
    }
}
