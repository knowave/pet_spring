package com.pet.spring.repository;

import com.pet.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existByEmail(String email);
}
