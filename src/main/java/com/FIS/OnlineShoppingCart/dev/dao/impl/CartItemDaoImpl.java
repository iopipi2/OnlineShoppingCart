package com.FIS.OnlineShoppingCart.dev.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.FIS.OnlineShoppingCart.dev.dao.CartItemDAO;
import com.FIS.OnlineShoppingCart.dev.dao.CartItemRepository;
import com.FIS.OnlineShoppingCart.dev.dao.ProductRepository;


@Transactional
@Repository
public class CartItemDaoImpl implements CartItemDAO {

    @Autowired
    CartItemRepository cartItemRepo;

    @Autowired
    ProductRepository productRepo;

    /*
     * @Override public List<CartItem> listCartItems(User user) {
     *
     * return cartItemRepo.findByUser(user); }
     */

    /*
     * @Override public Integer addProduct(Integer productId, Integer quantity, User
     * user) {
     *
     * Integer addedQuantity = quantity;
     *
     * Product product = productRepo.findById(productId).get();
     *
     * CartItem cartItem = cartItemRepo.findByUserAndProduct(user, product);
     *
     * if(cartItem != null) { addedQuantity = cartItem.getQuantity() + quantity;
     * cartItem.setQuantity(addedQuantity); }else { cartItem = new CartItem();
     * cartItem.setQuantity(quantity); cartItem.setBill(user);
     * cartItem.setProduct(product); }
     *
     * cartItemRepo.save(cartItem);
     *
     * return addedQuantity;
     */
}