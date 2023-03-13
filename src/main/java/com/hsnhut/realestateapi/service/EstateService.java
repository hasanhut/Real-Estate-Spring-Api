package com.hsnhut.realestateapi.service;

import com.hsnhut.realestateapi.dto.CreateEstateRequest;
import com.hsnhut.realestateapi.dto.EstateDto;
import com.hsnhut.realestateapi.dto.SellerDto;
import com.hsnhut.realestateapi.dto.UpdateEstateRequest;
import com.hsnhut.realestateapi.dto.converter.EstateDtoConverter;
import com.hsnhut.realestateapi.exception.SellerNotFoundException;
import com.hsnhut.realestateapi.model.Estate;
import com.hsnhut.realestateapi.model.Seller;
import com.hsnhut.realestateapi.repository.EstateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstateService {
    private final EstateRepository estateRepository;
    private final SellerService sellerService;
    private final EstateDtoConverter converter;


    public EstateService(EstateRepository estateRepository, SellerService sellerService, EstateDtoConverter converter) {
        this.estateRepository = estateRepository;
        this.sellerService = sellerService;
        this.converter = converter;
    }

    protected Estate findEstateById(String id){
        return estateRepository.findById(id)
                .orElseThrow(
                        () -> new SellerNotFoundException("Seller Not Found By Id : "+ id));
    }
    public EstateDto getEstateById(String estateId){
        return converter.estateDtoConverter(findEstateById(estateId));
    }

    public EstateDto createEstate(CreateEstateRequest createEstateRequest){
        Seller seller = sellerService.findSellerById(createEstateRequest.getSellerId());
        Estate estate = new Estate(createEstateRequest.getPrice(),
                LocalDateTime.now(),
                createEstateRequest.getEstateType(),
                seller);

        return converter.estateDtoConverter(estateRepository.save(estate));
    }

    public List<EstateDto> getEstates(){
        return estateRepository.findAll().stream().map(converter::estateDtoConverter).collect(Collectors.toList());
    }

    public EstateDto updateEstate(String id, UpdateEstateRequest updateEstateRequest){
        Estate estate = findEstateById(id);
        estate.setPrice(updateEstateRequest.getPrice());
        estate.setEstateType(updateEstateRequest.getEstateType());
        return converter.estateDtoConverter(estateRepository.save(estate));
    }

    public void deleteEstate(String id){
        Estate estate = findEstateById(id);
        estateRepository.delete(estate);
    }
}
