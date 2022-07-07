package com.FIS.OnlineShoppingCart.dev.repositories;

import com.FIS.OnlineShoppingCart.dev.entities.Order;
import com.FIS.OnlineShoppingCart.dev.entities.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

//    @Query("SELECT a FROM Order WHERE 1=1 and a.status <> 3 order by a.updated_date desc")
//     List<Order> findOrderAdmin();
//
//    @Query("SELECT a FROM Order WHERE a.create_by?=1")
//     List<Order> findOrderCustomer(Integer id);
//
//    @Query("SELECT a FROM Order WHERE a.status?=1")
//     List<Order> findOrderByStatus(Integer status);
//
//
//    List<OrderProducts> findAllById(Integer id);


}
