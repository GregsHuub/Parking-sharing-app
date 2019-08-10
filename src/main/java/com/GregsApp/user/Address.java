package com.GregsApp.user;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String street;
    private Integer streetNumber;
    private Integer houseNumber;

    @OneToOne
    private User user;

}
