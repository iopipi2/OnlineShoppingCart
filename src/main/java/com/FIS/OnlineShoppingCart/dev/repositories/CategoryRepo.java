package com.FIS.OnlineShoppingCart.dev.repositories;

import com.FIS.OnlineShoppingCart.dev.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {

    @Query("SELECT a FROM Category a where a.status= 1")
     List<Category>  findCategory();
}
