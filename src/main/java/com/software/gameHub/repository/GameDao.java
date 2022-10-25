package com.software.gameHub.repository;

import com.software.gameHub.entity.Basket;
import com.software.gameHub.entity.Category;
import com.software.gameHub.entity.Game;
import com.software.gameHub.entity.dto.GameDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface GameDao extends JpaRepository<Game,Integer> {

    List<Game> findGameByCategories_CategoryIdIn(List<Integer> categoriesId);

    List<Game> findByNameIgnoreCaseStartingWith(String prefix);

    List<Game> findByNameIgnoreCaseContaining(String infix);

    List<Game> findByOrderByName();

    List<Game> findByOrderByNameDesc();

    List<Game> findByOrderByPrice();

    List<Game> findByOrderByPriceDesc();
}
