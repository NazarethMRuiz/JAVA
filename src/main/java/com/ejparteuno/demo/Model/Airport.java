package com.ejparteuno.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_airport;

    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idairport")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public long getId_airport() {
        return id_airport;
    }

    public void setId_airport(long id_airport) {
        this.id_airport = id_airport;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
