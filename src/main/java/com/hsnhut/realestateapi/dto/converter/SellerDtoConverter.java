package com.hsnhut.realestateapi.dto.converter;

import com.hsnhut.realestateapi.dto.SellerDto;
import com.hsnhut.realestateapi.model.Estate;
import com.hsnhut.realestateapi.model.Seller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SellerDtoConverter {
    private final ModelMapper modelMapper;

    public SellerDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SellerDto sellerDtoConverter(Seller from) {
        SellerDto sellerDto = modelMapper.map(from, SellerDto.class);
        return sellerDto;
    }
}
