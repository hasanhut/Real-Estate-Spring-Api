package com.hsnhut.realestateapi.repository;

import com.hsnhut.realestateapi.model.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateRepository extends JpaRepository<Estate,String> {
}
