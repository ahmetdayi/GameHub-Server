package com.software.gameHub.repository;

import com.software.gameHub.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketDao extends JpaRepository<Basket,Integer> {
}
