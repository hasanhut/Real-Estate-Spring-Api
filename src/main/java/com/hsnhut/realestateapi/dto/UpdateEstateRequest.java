package com.hsnhut.realestateapi.dto;

import com.hsnhut.realestateapi.model.EstateType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UpdateEstateRequest {
    private BigDecimal price;
    private EstateType estateType;

    public UpdateEstateRequest(BigDecimal price, EstateType estateType) {
        this.price = price;
        this.estateType = estateType;
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
