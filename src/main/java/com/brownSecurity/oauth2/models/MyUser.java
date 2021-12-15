package com.brownSecurity.oauth2.models;

import com.brownSecurity.oauth2.DTOs.RegistrationDTO;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class MyUser {
    public MyUser(RegistrationDTO registrationDTO, PasswordEncoder encoder){
        firstName = registrationDTO.getFirstName();
        lastName = registrationDTO.getLastName();
        username = registrationDTO.getUsername();
        password = encoder.encode(registrationDTO.getPassword());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(unique = true, nullable = false)
    private String username;

    @NonNull
    @Column(nullable = false)
    private String firstName;

    @NonNull
    @Column(nullable = false)
    private String lastName;

    @NonNull
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active = true;

    @NonNull
    @ManyToMany
    private List<Role> roles;
}
