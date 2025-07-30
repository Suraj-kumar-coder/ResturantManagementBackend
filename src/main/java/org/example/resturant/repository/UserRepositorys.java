package org.example.resturant.repository;

import jakarta.persistence.Id;
import org.example.resturant.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorys extends JpaRepository<User, Id> {
    User findByEmail(String email);

}
