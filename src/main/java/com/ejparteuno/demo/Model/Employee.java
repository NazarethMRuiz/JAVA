package com.ejparteuno.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_employee;

    @Column(name = "surname")
    private String surname;

    @Column(name = "firstname")
    private String firstname;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Languages_Employee",
            joinColumns = @JoinColumn(name = "id_employee"),
            inverseJoinColumns = @JoinColumn(name = "id_languaje"))
    private List<Language> languagea;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_country")
    private Country country;

    public long getId_employee() {
        return id_employee;
    }

    public void setId_employee(long id_employee) {
        this.id_employee = id_employee;
    }

    public List<Language> getLanguagea() {
        return languagea;
    }

    public void setLanguagea(List<Language> languagea) {
        this.languagea = languagea;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
