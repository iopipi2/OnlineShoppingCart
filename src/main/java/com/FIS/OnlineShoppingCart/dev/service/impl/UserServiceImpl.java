package com.FIS.OnlineShoppingCart.dev.service.impl;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FIS.OnlineShoppingCart.dev.dao.UserDAO;
import com.FIS.OnlineShoppingCart.dev.dao.UserRepository;
import com.FIS.OnlineShoppingCart.dev.entities.AuthenticationProvider;
import com.FIS.OnlineShoppingCart.dev.entities.User;
import com.FIS.OnlineShoppingCart.dev.model.UserDTO;

import com.FIS.OnlineShoppingCart.dev.service.UserService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserRepository userRepo;



    @Override
    public User addUser(UserDTO userDTO) {

        User user = new User();

        user.setId(userDTO.getId());

        user.setName(userDTO.getName());
        //Lấy password người dùng nhập, mã hóa về dạng BCrypt r lưu database
        BCryptPasswordEncoder endcoder = new BCryptPasswordEncoder();
        String rawPassword = userDTO.getPassword();
        String endcodedPassword = endcoder.encode(rawPassword);

        System.out.println(endcodedPassword);
        user.setPassword(endcodedPassword);
        user.setUsername(userDTO.getUsername());
        user.setCountry_id(0);
        user.setAvatar(userDTO.getAvatar());

        user.setCreated_time(new Date());

        user.setRole("ROLE_USER");
        user.setEnabled(true);

        userDAO.addUser(user);

        return user;

    }

    @Override
    public User editUser(UserDTO userDTO) {

        User user = userDAO.getUserById(userDTO.getId());

        System.out.println(user);

        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setState(userDTO.getState());
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getState());
        user.setCountry_id(userDTO.getCountry_id());
        user.setPhone(userDTO.getPhone());
        user.setAvatar(userDTO.getAvatar());

        System.out.println("In ra cho vui : " + userDTO.getAvatar());

        user.setPostal_code(userDTO.getPostal_code());

        userDAO.editUser(user);

        return user;
    }

    @Override
    public UserDTO getUserByMail(String mail) {

        User user = userDAO.getUserByMail(mail);

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole());;
        userDTO.setName(user.getName());
        userDTO.setPhone(user.getPhone());
        userDTO.setCity(user.getCity());
        userDTO.setAddress(user.getAddress());
        userDTO.setState(user.getState());
        userDTO.setCountry_id(user.getCountry_id());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setOneTimePassword(user.getOneTimePassword());
        userDTO.setOtpRequestedTime(user.getOtpRequestedTime());

        return userDTO;
    }

    @Override
    public void registerNewUserAfterOAuthLoginSuccess(String email, String name, AuthenticationProvider authProvider) {

        User user = new User();

        user.setUsername(email);
        user.setName(name);
        user.setAuthProvider(authProvider);
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        user.setCountry_id(0);
        userDAO.addUser(user);

    }


    @Override
    public void deleteUser(int id) {
        User user = userDAO.getUserById(id);

        if(user != null) {
            userDAO.deleteUser(user);
        }

    }

    @Override
    public void generateOneTimePassword(UserDTO userDTO) throws MessagingException, UnsupportedEncodingException {

    }


    @Override
    public UserDTO getUserById(int id) {
        User user = userDAO.getUserById(id);
        System.out.println(user);

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());
        //userDTO.setRole(user.getRole());
        userDTO.setName(user.getName());
        userDTO.setPhone(user.getPhone());
        userDTO.setCity(user.getCity());
        userDTO.setPostal_code(user.getPostal_code());
        userDTO.setAddress(user.getAddress());
        userDTO.setState(user.getState());
        userDTO.setCountry_id(user.getCountry_id());
        userDTO.setAvatar(user.getAvatar());

        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users = userRepo.findAll();

        List<UserDTO> userDTOs = new ArrayList<>();

        for(User user : users) {
            UserDTO userDTO = new UserDTO();

            userDTO.setId(user.getId());
            userDTO.setPassword(user.getPassword());
            userDTO.setUsername(user.getUsername());
            userDTO.setRole(user.getRole());
            userDTO.setName(user.getName());
            userDTO.setPhone(user.getPhone());
            userDTO.setCity(user.getCity());
            userDTO.setAddress(user.getAddress());
            userDTO.setState(user.getState());
            userDTO.setCountry_id(user.getCountry_id());
            userDTO.setAvatar(user.getAvatar());

            userDTOs.add(userDTO);
        }

        return userDTOs;
    }
}