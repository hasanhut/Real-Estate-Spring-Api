package com.hsnhut.realestateapi.dto;

import com.hsnhut.realestateapi.model.EstateType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EstateDto {
    private String id;
    private BigDecimal price;
    private LocalDateTime creationDate;
    private EstateType estateType;
    private EstateSellerDto seller;

    public EstateDto() {
    }

    public EstateDto(String id, BigDecimal price, LocalDateTime creationDate, EstateType estateType, EstateSellerDto seller) {
        this.id = id;
        this.price = price;
        this.creationDate = creationDate;
        this.estateType = estateType;
        this.seller = seller;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public EstateType getEstateType() {
        return estateType;
    }

    public void setEstateType(EstateType estateType) {
        this.estateType = estateType;
    }

    public EstateSellerDto getSeller() {
        return seller;
    }

    public void setSeller(EstateSellerDto seller) {
        this.seller = seller;
    }
}
