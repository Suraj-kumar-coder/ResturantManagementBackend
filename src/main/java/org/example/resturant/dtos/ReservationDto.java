package org.example.resturant.dtos;

import org.example.resturant.enums.ReservationStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class ReservationDto {

    private long id;
    private String tableType;
    private String description;

    private Date dateTime;

   private ReservationStatus reservationStatus;

    private long customerId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime( Date dateTime) {
        this.dateTime = dateTime;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
