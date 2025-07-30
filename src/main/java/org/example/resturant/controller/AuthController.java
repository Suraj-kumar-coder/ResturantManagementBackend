package org.example.resturant.controller;


import org.example.resturant.dtos.SignupRequest;
import org.example.resturant.entities.User;
import org.example.resturant.entities.UserLoginRequest;
import org.example.resturant.repository.UserRepositorys;
import org.example.resturant.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class AuthController {


    @Autowired
    private AuthService authService;// Automatically inject (object)instance of autoserviceimpl class in autoservice variable


    @Autowired
    private UserRepositorys userRepositorys;

//     @GetMapping("/user")
//     public String getuser()
//     {
//         System.out.println("user");
//         return "user";
//     }

    // SIGNUP
    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest)
    {
//       UserDto createuser= authService.createUser(signupRequest);
        User createuser =authService.createUser(signupRequest);
       if(createuser==null)
       {
           return new ResponseEntity<>("user not created,come again later!", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createuser, HttpStatus.CREATED);
    }



    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserLoginRequest request) {
        User user = userRepositorys.findByEmail(request.getEmail());


        Map<String, String> response = new HashMap<>();

        if (user != null && user.getPassword().equals(request.getPassword())) {
            response.put("message", "login successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Invalid email or password");
            return ResponseEntity.status(401).body(response);
        }
    }





}
