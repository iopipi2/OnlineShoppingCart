package com.FIS.OnlineShoppingCart.dev.dao;

import java.util.List;
import com.FIS.OnlineShoppingCart.dev.entities.Review;

public interface ReviewDAO {

    List<Review> getAllReview();

    void add(Review review);

    void delete(Review review);

    void edit(Review review);

    Review getById(int id);

    List<Review> find(Integer productId);

    Long countById(int id);
}