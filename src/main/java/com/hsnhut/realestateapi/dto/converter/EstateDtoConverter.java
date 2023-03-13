package com.hsnhut.realestateapi.dto.converter;

import com.hsnhut.realestateapi.dto.EstateDto;
import com.hsnhut.realestateapi.model.Estate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EstateDtoConverter {
    private final ModelMapper modelMapper;

    public EstateDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /*public EstateDto estateDtoConverter(Estate from) {
        return new EstateDto(from.getId(),
                from.getPrice(),
                from.getCreationDate(),
                from.getEstateType(),
                sellerDtoConverter.sellerDtoConverter(from.getSeller()));
    }*/
    public EstateDto estateDtoConverter(Estate from) {
        EstateDto estateDto = modelMapper.map(from, EstateDto.class);
        return estateDto;
    }
}
