package org.example.resturant.services.auth.Admin;

import org.example.resturant.dtos.CategoryDto;
import org.example.resturant.dtos.ReservationDto;
import org.example.resturant.entities.Category;

import org.example.resturant.entities.Reservation;
import org.example.resturant.enums.ReservationStatus;
import org.example.resturant.repository.CategoryRepository;
import org.example.resturant.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class AdminServiceImp implements AdminService {

   @Autowired
   private CategoryRepository categoryRepository;

   @Autowired
   private ReservationRepository reservationRepository;


    @Override
    public CategoryDto postCategory(CategoryDto categoryDto) throws IOException {

        Category categorys = new Category();
        categorys.setName(categoryDto.getName());
        categorys.setPrice(categoryDto.getPrice());
        categorys.setDescription(categoryDto.getDescription());
        categorys.setImg(categoryDto.getImg().getBytes());
        Category createCategory=  categoryRepository.save(categorys);
        CategoryDto createCategoryDto = new CategoryDto();
        createCategoryDto.setId(createCategory.getId());



        return createCategoryDto;
    }

    @Override
    public Category findAlls(Long id) {
       Category c=categoryRepository.findById(Long.valueOf(id)).orElse(null);
       return c;
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(Category::getAllCategoryDto).collect(Collectors.toList());

    }

    @Override
    public List<CategoryDto> findAllByTile(String title) {
        return categoryRepository.findAllByNameContaining(title).stream().map(Category::getAllCategoryDto).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDto> findAllByid(Long id) {
        return categoryRepository.findAllById(id).stream().map(Category::getAllCategoryDtoById).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(long id, CategoryDto categoryDto) throws IOException {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) {
            Category extingCategory = optionalCategory.get();



            extingCategory.setName(categoryDto.getName());
            extingCategory.setPrice(categoryDto.getPrice());
            extingCategory.setDescription(categoryDto.getDescription());

            if (categoryDto.getImg() != null && !categoryDto.getImg().isEmpty()) {
                extingCategory.setImg(categoryDto.getImg().getBytes());
            }

            Category updatedCategory = categoryRepository.save(extingCategory);

            CategoryDto updateCategoryDto = new CategoryDto();
            updateCategoryDto.setId(updatedCategory.getId());
            updateCategoryDto.setName(updatedCategory.getName());
            updateCategoryDto.setPrice(updatedCategory.getPrice());
            updateCategoryDto.setDescription(updatedCategory.getDescription());
            updateCategoryDto.setReturnedImg(updatedCategory.getImg());

            return updateCategoryDto;
        } else {
            return null;
        }
    }
//delete
    @Override
    public String deletCatgeory(long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {

            categoryRepository.deleteById(id);
            return "delete successfully";
        }
        else{
            return "delete failed";
        }

    }

    @Override
    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll().stream().map(Reservation::getAllReservations).collect(Collectors.toList()) ;
    }

    @Override
    public ReservationDto changeReservationStatus(long id, String status) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation existingReservation = optionalReservation.get();
            if(Objects.equals(status,"Approve")){
                existingReservation.setReservationStatus(ReservationStatus.Approved);

            }
            else{
                existingReservation.setReservationStatus(ReservationStatus.Rejected);
            }
            Reservation changereservationstatus = reservationRepository.save(existingReservation);

            ReservationDto reservationDto = new ReservationDto();
            reservationDto.setId(changereservationstatus.getId());
            return reservationDto;
        }
        return null;
    }


}
