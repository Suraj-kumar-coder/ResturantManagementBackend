package org.example.resturant.repository;

import org.example.resturant.dtos.CategoryDto;
import org.example.resturant.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    List<Category>findAllByNameContaining(String title);

    List<Category> findAllById(Long id);




    List<Category> findAByNameContaining(String title);
}
