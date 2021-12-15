package com.brownSecurity.oauth2.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor(onConstructor = @__(@Autowired))
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<MyUser> users;

    @ManyToMany
    private List<Privilege> privileges;
}
