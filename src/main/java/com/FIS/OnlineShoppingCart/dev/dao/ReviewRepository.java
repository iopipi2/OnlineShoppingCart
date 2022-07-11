package com.FIS.OnlineShoppingCart.dev.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FIS.OnlineShoppingCart.dev.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
