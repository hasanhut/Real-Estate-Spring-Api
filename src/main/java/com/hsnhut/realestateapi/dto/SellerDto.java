package com.hsnhut.realestateapi.dto;

import com.hsnhut.realestateapi.model.Estate;

import java.util.Set;

public class SellerDto {
    private String id;
    private String name;
    private String surname;
    private Set<SellerEstateDto> estates;

    public SellerDto() {
    }

    public SellerDto(String id, String name, String surname, Set<SellerEstateDto> estates) {
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

    public Set<SellerEstateDto> getEstates() {
        return estates;
    }

    public void setEstates(Set<SellerEstateDto> estates) {
        this.estates = estates;
    }
}
