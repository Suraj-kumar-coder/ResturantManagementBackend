package org.example.resturant.services.auth;


import jakarta.annotation.PostConstruct;
import org.example.resturant.dtos.SignupRequest;
import org.example.resturant.dtos.UserDto;
import org.example.resturant.entities.User;
import org.example.resturant.enums.Userrole;
import org.example.resturant.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImplmentation implements AuthService {

    @Autowired
    private userRepository userRepository;


    // Admin
//   @PostConstruct
//    public void createAdminAccount()
//    {
//        User admin = userRepository.findByUserrole(Userrole.Admin);
//        if(admin == null)
//        {
//            User user = new User();
//            user.setName("admin");
//            user.setEmail("admin@gmail.com");
//            user.setPassword("admin");
//            user.setUserrole(Userrole.Admin);
//            userRepository.save(user);
//        }
//    }


    @Override
    public User createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setUserrole(Userrole.customer);
        User createuser= userRepository.save(user);
//        UserDto userDto = new UserDto();
//        userDto.setId(createuser.getId());
//        userDto.setName(createuser.getName());
//        userDto.setEmail(createuser.getEmail());
//        userDto.setPassword(createuser.getPassword());
//        userDto.setUserrole(createuser.getUserrole());

        return createuser;
    }


}
