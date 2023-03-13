package com.hsnhut.realestateapi;


import com.hsnhut.realestateapi.model.Estate;
import com.hsnhut.realestateapi.model.Seller;
import com.hsnhut.realestateapi.repository.EstateRepository;
import com.hsnhut.realestateapi.repository.SellerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class RealestateapiApplication implements CommandLineRunner{

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	private final SellerRepository sellerRepository;
	private final EstateRepository estateRepository;

	@Autowired
	public RealestateapiApplication(SellerRepository sellerRepository, EstateRepository estateRepository) {
		this.sellerRepository = sellerRepository;
		this.estateRepository = estateRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RealestateapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Seller seller = sellerRepository.save(new Seller("","Hasan","Hut",new HashSet<>()));
		Seller seller2 = sellerRepository.save(new Seller("","Huso","Hasilci",new HashSet<>()));
		System.out.println(seller.getId());
		System.out.println(seller2.getId());
	}
}
