package com.FIS.OnlineShoppingCart.dev.services;

import com.FIS.OnlineShoppingCart.dev.entities.Account;
import com.FIS.OnlineShoppingCart.dev.repositories.UserRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @PersistenceContext
    protected EntityManager entityManager;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SessionFactory sessionFactory;

    //Find Account By Id
//    Optional<Account> findAccountById(Integer id)
//    {
//        return userRepo.findById(id);
//    }
    public Account findAccountById(Integer id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(Account.class, id);
    }

    //List all Account
//    public List<Account> listAllAccount(Integer id)
//    {
//        return userRepo.findAll();
//
//    }
//    //Save Account
//    public void saveAccount(Account account)
//    {
//        userRepo.save(account);
//    }
//    //Delete Account
//    public void deleteAccount(Account account)
//    {
//        userRepo.delete(account);
//    }
//    //Update Password Encoding
//    public void updatePasswordEncoder(Account account,String newpassword)
//    {
//        String encode=new String(Base64Utils.encode(newpassword.getBytes()));
//        account.setPassword(encode);
//        userRepo.save(account);
//    }


}
