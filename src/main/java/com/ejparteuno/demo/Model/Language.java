package com.ejparteuno.demo.Model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "languaje")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_languaje;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "languagea", cascade = CascadeType.PERSIST)
    private List<Employee> idioma;

    public long getId_languaje() {
        return id_languaje;
    }

    public void setId_languaje(long id_languaje) {
        this.id_languaje = id_languaje;
    }

    public List<Employee> getLikes() {
        return idioma;
    }

    public void setLikes(List<Employee> likes) {
        this.idioma = likes;
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
