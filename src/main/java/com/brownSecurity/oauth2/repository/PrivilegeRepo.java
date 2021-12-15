package com.brownSecurity.oauth2.repository;

import com.brownSecurity.oauth2.models.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepo extends JpaRepository<Privilege, Integer> {
    Privilege findByName(String name);
}
