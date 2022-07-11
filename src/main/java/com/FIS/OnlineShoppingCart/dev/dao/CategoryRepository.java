package com.FIS.OnlineShoppingCart.dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FIS.OnlineShoppingCart.dev.entities.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {

}
