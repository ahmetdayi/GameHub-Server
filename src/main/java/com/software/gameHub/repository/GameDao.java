package com.software.gameHub.repository;

import com.software.gameHub.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDao extends JpaRepository<Game,Integer> {
}
