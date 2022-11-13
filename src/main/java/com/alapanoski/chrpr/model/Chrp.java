package com.alapanoski.chrpr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;

@Document("chrps")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chrp {

    @Id
    private BigInteger id;

    private String username;
    private String display_name;
    private String message;
    private Date date;

    public Chrp(String username, String message, Date date) {
        this.username = username;
        this.message = message;
        this.date = date;
    }
}