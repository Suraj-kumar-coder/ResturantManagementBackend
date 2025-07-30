package org.example.resturant.services.auth.Admin;

import org.example.resturant.dtos.CategoryDto;
import org.example.resturant.dtos.ReservationDto;
import org.example.resturant.entities.Category;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AdminService {

    CategoryDto postCategory(CategoryDto categoryDto) throws IOException;


    Category findAlls(Long id);

    List<CategoryDto> findAll();

    List<CategoryDto> findAllByTile(String title);

    List<CategoryDto> findAllByid(Long id);

    CategoryDto updateCategory(long id,CategoryDto categoryDto)throws IOException;

    String deletCatgeory(long id);

    List<ReservationDto> getAllReservations();

    ReservationDto changeReservationStatus(long id, String status);
}
