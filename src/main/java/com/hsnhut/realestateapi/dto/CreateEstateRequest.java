package com.hsnhut.realestateapi.dto;

import com.hsnhut.realestateapi.model.EstateType;

import java.math.BigDecimal;

public class CreateEstateRequest {
    private String sellerId;
    private BigDecimal price;
    private EstateType estateType;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public EstateType getEstateType() {
        return estateType;
    }

    public void setEstateType(EstateType estateType) {
        this.estateType = estateType;
    }
}
