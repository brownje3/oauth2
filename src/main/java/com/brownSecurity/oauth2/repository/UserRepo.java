package com.brownSecurity.oauth2.repository;

import com.brownSecurity.oauth2.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<MyUser, Integer> {
    MyUser findByUsername(String username);
}
