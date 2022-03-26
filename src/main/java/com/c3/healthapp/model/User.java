package com.c3.healthapp.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private Date dateOfBirth;
    private int height;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    /**
     * Constructs and returns a String representing the state of the object
     */
    @Override
    public String toString() {

        return "Customer Id: " + id + " First Name: " + name + " Date Of Birth : " + dateOfBirth +
                " Email Address: " + username + " Password: " + password;

    }

}
