package com.lotfizad.stockassignment.repository;

import com.lotfizad.stockassignment.domain.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

   public StockEntity findByName(String name);
}
