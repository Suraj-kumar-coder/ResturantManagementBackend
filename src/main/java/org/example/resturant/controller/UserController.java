package org.example.resturant.controller;


import org.example.resturant.dtos.CategoryDto;
import org.example.resturant.dtos.ReservationDto;
import org.example.resturant.entities.Reservation;
import org.example.resturant.entities.User;
import org.example.resturant.repository.userRepository;
import org.example.resturant.services.auth.User.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private userService userService;

    @Autowired
    private userRepository userRepository;

    //Forget Password
    @GetMapping("/{email}/{password}")
    public String forgotPassword(@PathVariable String email, @PathVariable String password)
    {
        String changePassword = userService.ForgotPassword(email,password);
        if(changePassword != null)
        {
            return changePassword;
        }else{
            return null;
        }
    }

    @GetMapping("/viewItem")
    public ResponseEntity<List<CategoryDto>> getAllItem()
    {
      List<CategoryDto> l= userService.findAllItem();
      if(l==null)
      {
          return ResponseEntity.notFound().build();
      }
      else{
          return ResponseEntity.ok(l);
      }

    }

    //title

    @GetMapping("/categories/{title}")
    public ResponseEntity<List<CategoryDto>> getItemByTitle(@PathVariable String title)
    {
        List<CategoryDto> titleItem= userService.findItemByTitle(title);

        if(titleItem==null)
        {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(titleItem);
        }
    }

    // find user id

    @GetMapping("/{email}")
    public Long getUserIdByEmail(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        return user.getId();

    }
    //reservation post

    @PostMapping("/reservation")
    public ResponseEntity<?> postReservation(@RequestBody ReservationDto reservationDto) throws IOException {
        ReservationDto postReservation = userService.postReservation(reservationDto);
        if (postReservation == null) {
            return new ResponseEntity<>("something went wrong", HttpStatus.BAD_REQUEST);
        } else {
            return ResponseEntity.ok(postReservation);
        }


    }

    //getReservationByUserId

    @GetMapping("/reservation/{id}")
    public ResponseEntity<List<ReservationDto>> getAllReservationByUserId(@PathVariable long id)
    {
        List<ReservationDto> l= userService.findAllReservationByUserId(id);
        if(l==null)
        {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(l);
        }

    }





}
