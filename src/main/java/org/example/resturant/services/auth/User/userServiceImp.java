package org.example.resturant.services.auth.User;


import org.example.resturant.dtos.CategoryDto;
import org.example.resturant.dtos.ReservationDto;
import org.example.resturant.entities.Category;
import org.example.resturant.entities.Reservation;
import org.example.resturant.enums.ReservationStatus;
import org.example.resturant.entities.User;
import org.example.resturant.enums.ReservationStatus;
import org.example.resturant.repository.CategoryRepository;
import org.example.resturant.repository.ReservationRepository;
import org.example.resturant.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class userServiceImp implements userService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private userRepository userrepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<CategoryDto> findAllItem() {
        return categoryRepository.findAll().stream().map(Category::getAllCategoryDto).collect(Collectors.toList());

    }

    @Override
    public List<CategoryDto> findItemByTitle(String title) {

        return categoryRepository.findAByNameContaining(title).stream().map(Category::getAllCategoryDto).collect(Collectors.toList());
    }
    //post Reservation
    @Override
    public ReservationDto postReservation(ReservationDto reservationDto) {
        Optional<User> optionalUser= userrepository.findById(reservationDto.getCustomerId());
        if(optionalUser.isPresent()){
            Reservation reservation = new Reservation();

            reservation.setTableType(reservationDto.getTableType());
            reservation.setDateTime(reservationDto.getDateTime());
            reservation.setDescription(reservationDto.getDescription());
            reservation.setUser(optionalUser.get());
            reservation.setReservationStatus(ReservationStatus.Pending);
           Reservation postReservation= reservationRepository.save(reservation);

            ReservationDto postReservationDto = new ReservationDto();
            postReservationDto.setId(postReservation.getId());

            return postReservationDto;


        }

        return null;
    }

    @Override
    public List<ReservationDto> findAllReservationByUserId(Long id) {
        return reservationRepository.findAllReservationByUserId(id).stream().map(Reservation::getAllReservations).collect(Collectors.toList());
    }

    @Override
    public String ForgotPassword(String email,String password) {
        User user= userrepository.findByEmail(email);
        System.out.println(user.getEmail());
        if(user!=null){
            user.setPassword(password);
            userrepository.save(user);
            return user.getPassword();
        }
        return null;





    }


}
