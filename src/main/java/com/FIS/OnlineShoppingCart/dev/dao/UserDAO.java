package com.FIS.OnlineShoppingCart.dev.dao;

import com.FIS.OnlineShoppingCart.dev.entities.User;

public interface UserDAO {

    public void addUser(User p);

    public User getUserByMail(String mail);

    public void editUser(User user);

    public void deleteUser(User user);

    public User getUserById(int id);
}