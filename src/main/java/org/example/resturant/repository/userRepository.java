package org.example.resturant.repository;


import org.example.resturant.entities.User;
import org.example.resturant.enums.Userrole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepository extends JpaRepository<User,Long> {

    User findByUserrole(Userrole userrole);
    User findByEmail(String email);
}
