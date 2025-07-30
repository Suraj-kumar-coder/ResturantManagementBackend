package org.example.resturant.services.auth.User;

import org.example.resturant.dtos.CategoryDto;
import org.example.resturant.dtos.ReservationDto;
import org.example.resturant.entities.Reservation;

import java.util.List;

public interface userService {
    List<CategoryDto> findAllItem();

    List<CategoryDto> findItemByTitle(String title);

    ReservationDto postReservation(ReservationDto reservationDto);

    List<ReservationDto> findAllReservationByUserId(Long id);


    String ForgotPassword(String email,String password);
}
