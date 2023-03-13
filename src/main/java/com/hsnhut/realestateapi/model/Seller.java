package com.hsnhut.realestateapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Seller {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String surname;
    /* Set kullanmamın sebebi set içerisinde aynı objeden sadece bir tane olabilir */
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Estate> estates;

    public Seller() {
    }

    public Seller(String name, String surname) {
        this.id = "";
        this.name = name;
        this.surname = surname;
        this.estates = new HashSet<>();
    }

    public Seller(String id, String name, String surname, Set<Estate> estates) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.estates = estates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Estate> getEstates() {
        return estates;
    }

    public void setEstates(Set<Estate> estates) {
        this.estates = estates;
    }
}
