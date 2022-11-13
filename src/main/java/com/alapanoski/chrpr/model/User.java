package com.alapanoski.chrpr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;

@Document("users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private BigInteger id;

    private String username;
    private String first_name;
    private String last_name;
    private Date dateOfRegistration;

    public User(String username, String firstName, String lastName, Date dateOfRegistration) {
        this.username = username;
        this.first_name = firstName;
        this.last_name = lastName;
        this.dateOfRegistration = dateOfRegistration;
    }
}
