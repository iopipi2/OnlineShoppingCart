package com.FIS.OnlineShoppingCart.dev.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FIS.OnlineShoppingCart.dev.dao.ReviewDAO;
import com.FIS.OnlineShoppingCart.dev.entities.Product;
import com.FIS.OnlineShoppingCart.dev.entities.Review;
import com.FIS.OnlineShoppingCart.dev.entities.User;
import com.FIS.OnlineShoppingCart.dev.model.ProductDTO;
import com.FIS.OnlineShoppingCart.dev.model.ReviewDTO;
import com.FIS.OnlineShoppingCart.dev.model.UserDTO;
import com.FIS.OnlineShoppingCart.dev.service.ReviewService;
import com.FIS.OnlineShoppingCart.dev.utils.DateTimeUtils;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDAO reviewDao;

    @Override
    public void add(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setReviewDate(new Date());
        review.setReview(reviewDTO.getReview());
        review.setStarNumber(reviewDTO.getStarNumber());
        review.setProduct(new Product(reviewDTO.getProductDTO().getId()));
        User user= new User();
        user.setId(reviewDTO.getUserDTO().getId());
        review.setUser(user);
        reviewDao.add(review);

    }

    @Override
    public void delete(int id) {
        Review review = reviewDao.getById(id);
        if (review != null) {
            reviewDao.delete(review);
        }

    }

    @Override
    public void edit(ReviewDTO reviewDTO) {
        Review review = reviewDao.getById(reviewDTO.getId());
        if (review != null) {
            review.setStarNumber(reviewDTO.getStarNumber());
            review.setProduct(new Product(reviewDTO.getProductDTO().getId()));
            User user= new User();
            user.setName(reviewDTO.getUserDTO().getName());
            review.setUser(user);
        }
        reviewDao.edit(review);
    }

    @Override
    public ReviewDTO getById(int id) {
        Review review = reviewDao.getById(id);
        if (review != null) {
            convert(review);
        }
        return null;
    }

    private ReviewDTO convert(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setReview(review.getReview());
        reviewDTO.setReviewDate(DateTimeUtils.formatDate(review.getReviewDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
        reviewDTO.setStarNumber(review.getStarNumber());
        ProductDTO productDTO= new ProductDTO();
        productDTO.setId(review.getProduct().getId());
        productDTO.setName(review.getProduct().getName());
        reviewDTO.setProductDTO(productDTO);
        UserDTO userDTO= new UserDTO();
        userDTO.setId(review.getUser().getId());
        userDTO.setName(review.getUser().getName());
        userDTO.setAvatar(review.getUser().getAvatar());
        reviewDTO.setUserDTO(userDTO);
        return reviewDTO;
    }

    @Override
    public List<ReviewDTO> find(int productId) {
        List<Review> reviews = reviewDao.find(productId);
        List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
        reviews.forEach(rev -> {
            reviewDTOs.add(convert(rev));
        });
        return reviewDTOs;
    }

    @Override
    public Long count(int productId) {

        return reviewDao.countById(productId);
    }

    @Override
    public List<ReviewDTO> getAllReview() {

        List<Review> listReview = reviewDao.getAllReview();

        List<ReviewDTO> listReviewDTO = new ArrayList<>();

        for(Review r : listReview) {

            listReviewDTO.add(convert(r));

        }

        return listReviewDTO;
    }


}
