package com.software.gameHub.repository;

import com.software.gameHub.entity.Buy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyDao extends JpaRepository<Buy,Integer> {
}
