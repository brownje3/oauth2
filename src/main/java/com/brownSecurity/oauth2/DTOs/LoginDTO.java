package com.brownSecurity.oauth2.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter @Setter
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginDTO {
    String username, password;
}
