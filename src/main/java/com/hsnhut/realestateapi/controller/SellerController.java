package com.hsnhut.realestateapi.controller;

import com.hsnhut.realestateapi.dto.CreateSellerRequest;
import com.hsnhut.realestateapi.dto.SellerDto;
import com.hsnhut.realestateapi.dto.UpdateSellerRequest;
import com.hsnhut.realestateapi.service.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/seller")
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/findById")
    public ResponseEntity<SellerDto> findById(@RequestParam String id){
        return ResponseEntity.ok(sellerService.getSellerById(id));
    }

    @GetMapping("/getAllSeller")
    public ResponseEntity<List<SellerDto>> getAll(){
        return ResponseEntity.ok(sellerService.getAllSeller());
    }

    @PostMapping
    public ResponseEntity<SellerDto> createSeller(@RequestBody CreateSellerRequest createSellerRequest){
        return ResponseEntity.ok(sellerService.createSeller(createSellerRequest));
    }

    @PutMapping("/update")
    public ResponseEntity<SellerDto> updateSeller(@RequestParam("id") String id,@RequestBody UpdateSellerRequest updateSellerRequest){
        return ResponseEntity.ok(sellerService.updateSeller(id,updateSellerRequest));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteSeller(@RequestParam("id") String id){
        sellerService.deleteSeller(id);
        return ResponseEntity.ok("Delete Successfully");
    }
}
