package com.hsnhut.realestateapi.controller;

import com.hsnhut.realestateapi.dto.CreateEstateRequest;
import com.hsnhut.realestateapi.dto.EstateDto;
import com.hsnhut.realestateapi.service.EstateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/estate")
public class EstateController {
    private final EstateService estateService;

    public EstateController(EstateService estateService) {
        this.estateService = estateService;
    }

    @PostMapping
    public ResponseEntity<EstateDto> createEstate(@RequestBody CreateEstateRequest createEstateRequest){
        return ResponseEntity.ok(estateService.createEstate(createEstateRequest));
    }

    @GetMapping
    public ResponseEntity<List<EstateDto>> getAll(){
        return ResponseEntity.ok(estateService.getEstates());
    }
}
