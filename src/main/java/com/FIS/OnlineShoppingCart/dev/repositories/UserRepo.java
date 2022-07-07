package com.FIS.OnlineShoppingCart.dev.repositories;

import com.FIS.OnlineShoppingCart.dev.entities.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository

public class UserRepo {
    @Autowired
    private SessionFactory sessionFactory = null;

    public Account findAccount(String username)
    {
        Session session=this.sessionFactory.getCurrentSession();
        return session.find(Account.class,username);
    }

}
