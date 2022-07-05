package com.FIS.OnlineShoppingCart.dev.repositories;

import com.FIS.OnlineShoppingCart.dev.entities.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepo extends JpaRepository<OrderProducts,Integer> {
}
