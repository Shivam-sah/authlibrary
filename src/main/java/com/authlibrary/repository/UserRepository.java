package com.authlibrary.repository;

import com.authlibrary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserNameAndActive(String userName, boolean b);
}
