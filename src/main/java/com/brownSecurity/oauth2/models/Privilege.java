package com.brownSecurity.oauth2.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter @Setter
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor(onConstructor = @__(@Autowired))
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private ArrayList<Role> roles;
}
