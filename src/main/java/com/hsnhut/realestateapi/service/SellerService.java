package com.hsnhut.realestateapi.service;

import com.hsnhut.realestateapi.dto.CreateSellerRequest;
import com.hsnhut.realestateapi.dto.SellerDto;
import com.hsnhut.realestateapi.dto.UpdateSellerRequest;
import com.hsnhut.realestateapi.dto.converter.SellerDtoConverter;
import com.hsnhut.realestateapi.exception.SellerNotFoundException;
import com.hsnhut.realestateapi.model.Seller;
import com.hsnhut.realestateapi.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;
    private final SellerDtoConverter converter;

    public SellerService(SellerRepository sellerRepository, SellerDtoConverter converter) {
        this.sellerRepository = sellerRepository;
        this.converter = converter;
    }

    protected Seller findSellerById(String id){
        return sellerRepository.findById(id)
                .orElseThrow(
                        () -> new SellerNotFoundException("Seller Not Found By Id : "+ id));
    }

    public SellerDto getSellerById(String sellerId){
        return converter.sellerDtoConverter(findSellerById(sellerId));
    }
    public List<SellerDto> getAllSeller(){
        return sellerRepository.findAll().stream().map(converter::sellerDtoConverter).collect(Collectors.toList());
    }

    public SellerDto createSeller(CreateSellerRequest createSellerRequest){
        Seller seller = new Seller(createSellerRequest.getName(), createSellerRequest.getSurname());
        return converter.sellerDtoConverter(sellerRepository.save(seller));

    }

    public SellerDto updateSeller(String id,UpdateSellerRequest updateSellerRequest){
        Seller seller = findSellerById(id);
        seller.setName(updateSellerRequest.getName());
        seller.setSurname(updateSellerRequest.getSurname());
        return converter.sellerDtoConverter(sellerRepository.save(seller));
    }

    public void deleteSeller(String id){
        Seller seller = findSellerById(id);
        sellerRepository.delete(seller);
    }
}
