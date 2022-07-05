package com.FIS.OnlineShoppingCart.dev.services;

import com.FIS.OnlineShoppingCart.dev.entities.Product;
import com.FIS.OnlineShoppingCart.dev.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @PersistenceContext protected EntityManager entityManager;
    @Autowired
    private ProductRepo productRepo;

    //Find Product by Id
    Optional <Product> findProductById(Integer id)
    {
        return productRepo.findById(id);
    }
    //List all Product
    public List<Product> listAllProduct()
    {
        return productRepo.findAll();
    }
    //Save Product
    public void saveProduct(Product product)
    {
       productRepo.save(product);
    }
    //Delete Product
    public void deleteProduct(Product product)
    {
        productRepo.delete(product);
    }






}
