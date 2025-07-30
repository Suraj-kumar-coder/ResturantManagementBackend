package org.example.resturant.services.auth;

import org.example.resturant.dtos.SignupRequest;
import org.example.resturant.dtos.UserDto;
import org.example.resturant.entities.User;

import java.util.Optional;

public interface AuthService {

    User createUser(SignupRequest signupRequest);


}
