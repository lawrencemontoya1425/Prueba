package com.tienda.co.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.co.persistence.entity.FactEntity;

@Repository
public interface FactRepository extends JpaRepository<FactEntity, Long> {

}
