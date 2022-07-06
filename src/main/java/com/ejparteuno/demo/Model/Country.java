package com.ejparteuno.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_country;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_airport")
    private List<Airport> airport;

    @OneToOne(mappedBy = "country", cascade = CascadeType.ALL)
    private Employee employee;

    public List<Airport> getAirport() {
        return airport;
    }

    public void setAirport(List<Airport> airport) {
        this.airport = airport;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getId_country() {
        return id_country;
    }

    public void setId_country(long id_country) {
        this.id_country = id_country;
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
