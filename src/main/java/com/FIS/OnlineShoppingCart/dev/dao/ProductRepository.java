package com.FIS.OnlineShoppingCart.dev.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FIS.OnlineShoppingCart.dev.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1% AND p.category.type LIKE %?2%")
    public List<Product> findAll(String keyword, String category, Pageable pageable);

}

