package org.example.resturant.controller;


import org.example.resturant.dtos.CategoryDto;

import org.example.resturant.dtos.ReservationDto;
import org.example.resturant.repository.CategoryRepository;
import org.example.resturant.services.auth.Admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> postCategory(@ModelAttribute CategoryDto categoryDto) throws IOException {
       CategoryDto createCategory= adminService.postCategory(categoryDto);
       if(createCategory==null)
       {
           return ResponseEntity.notFound().build();
       }else{
           return ResponseEntity.ok(createCategory);
       }

    }
  // getByid
//    @GetMapping("/{id}")
//    public Category getCategoryById(@PathVariable Long id){
//        return adminService.findAlls(id);
//    }

    //get All
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
       List<CategoryDto> l =adminService.findAll();
       if(l==null)
       {
           return ResponseEntity.notFound().build();
       }
       else{
           return ResponseEntity.ok(l);
       }
    }

    @GetMapping("/categories/{title}")
    public ResponseEntity<List<CategoryDto>> getCategoryByTitle(@PathVariable String title){
        List<CategoryDto> l =adminService.findAllByTile(title);
        if(l==null)
        {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(l);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<List<CategoryDto>> getCategoryByTitle(@PathVariable Long id){
        List<CategoryDto> l =adminService.findAllByid(id);
        if(l==null)
        {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(l);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable long id,  @ModelAttribute  CategoryDto categoryDto) throws IOException {
        CategoryDto createCategory= adminService.updateCategory(id,categoryDto);
        if(createCategory==null)
        {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(createCategory);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,String>> deleteCategory(@PathVariable long id) throws IOException {
      String delete=  adminService.deletCatgeory(id);
      Map<String,String> map =new HashMap<>();
      if(delete.equals("delete failed"))
      {
          return ResponseEntity.notFound().build();
      }else {
          map.put("message","delete successfully");
          return ResponseEntity.ok(map);
      }
    }

    //All Reservation get
    @GetMapping("/Reservation")
    public ResponseEntity<List<ReservationDto>> getAllReservation(){
       List<ReservationDto> reservationDto= adminService.getAllReservations();
       if(reservationDto==null)
       {
           return ResponseEntity.notFound().build();
       }
       else{
           return ResponseEntity.ok(reservationDto);
       }
    }
// change Reservation status
    @GetMapping("/reservation/{id}/{status}")
    public ResponseEntity<ReservationDto> changeReservationStatus(@PathVariable long id,  @PathVariable String status) throws IOException {

        ReservationDto changeStatus= adminService.changeReservationStatus(id,status);
        if (changeStatus == null)
         {
            return ResponseEntity.notFound().build();

        }
        else{
            return ResponseEntity.ok(changeStatus);
        }
    }




}
