package org.example.resturant.repository;

import org.example.resturant.entities.Category;
import org.example.resturant.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllReservationByUserId(long id);
}
