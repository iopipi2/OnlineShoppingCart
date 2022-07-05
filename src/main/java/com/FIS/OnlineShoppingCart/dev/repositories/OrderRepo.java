package com.FIS.OnlineShoppingCart.dev.repositories;

import com.FIS.OnlineShoppingCart.dev.entities.Order;
import com.FIS.OnlineShoppingCart.dev.entities.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
    List<OrderProducts> findAllById(Integer id);
}
