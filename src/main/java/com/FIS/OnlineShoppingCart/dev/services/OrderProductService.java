package com.FIS.OnlineShoppingCart.dev.services;

import com.FIS.OnlineShoppingCart.dev.entities.Category;
import com.FIS.OnlineShoppingCart.dev.entities.OrderProducts;
import com.FIS.OnlineShoppingCart.dev.entities.Order;
import com.FIS.OnlineShoppingCart.dev.repositories.OrderProductRepo;
import com.FIS.OnlineShoppingCart.dev.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class OrderProductService {
    @PersistenceContext
    protected EntityManager entityManager;
    @Autowired
    private OrderProductRepo orderProductRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Query("SELECT a FROM Product a where a.product_name= ?1")

    //List all Order Product By Order Id
    public List<OrderProducts> listAllProduct(Integer id)
    {
        return orderRepo.findAllById(id);
    }
    //Save Order Product
    public void saveOrderProduct(OrderProducts orderProducts)
    {
        orderProductRepo.save(orderProducts);
    }
    //Delete Order Product
    public void deleteOrderProduct(OrderProducts orderProducts)
    {
        orderProductRepo.delete(orderProducts);
    }

}
