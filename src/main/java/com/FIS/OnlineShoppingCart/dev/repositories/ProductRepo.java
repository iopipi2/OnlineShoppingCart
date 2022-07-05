package com.FIS.OnlineShoppingCart.dev.repositories;

import com.FIS.OnlineShoppingCart.dev.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
}
