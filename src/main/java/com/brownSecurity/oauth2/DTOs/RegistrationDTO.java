package com.brownSecurity.oauth2.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter @Getter
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationDTO {
    private String firstName, lastName, username, password;
}