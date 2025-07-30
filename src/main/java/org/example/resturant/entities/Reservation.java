package org.example.resturant.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.example.resturant.dtos.ReservationDto;
import org.example.resturant.enums.ReservationStatus;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tableType;
    private String description;
    
    private  Date dateTime;
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    //getReservationbyUserId
    public ReservationDto getAllReservations() {
        ReservationDto dto = new ReservationDto();
        dto.setId(id);
        dto.setTableType(tableType);
        dto.setDescription(description);

        dto.setDateTime(dateTime);
        dto.setReservationStatus(reservationStatus);
        dto.setCustomerId(user.getId());
        return dto;

    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
