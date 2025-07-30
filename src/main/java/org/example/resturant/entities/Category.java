package org.example.resturant.entities;

import jakarta.persistence.*;
import org.example.resturant.dtos.CategoryDto;

import java.util.Optional;

@Entity

@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private String description;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public CategoryDto getAllCategoryDto() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(id);
        categoryDto.setName(name);
        categoryDto.setPrice(price);
        categoryDto.setDescription(description);
        categoryDto.setReturnedImg(img);

        return categoryDto;
    }
    public CategoryDto getAllCategoryDtoById() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(id);
        categoryDto.setName(name);
        categoryDto.setPrice(price);
        categoryDto.setDescription(description);
        categoryDto.setReturnedImg(img);

        return categoryDto;
    }



}
