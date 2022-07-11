package com.FIS.OnlineShoppingCart.dev.controller.admin;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.FIS.OnlineShoppingCart.dev.entities.User;
import com.FIS.OnlineShoppingCart.dev.model.UserDTO;
import com.FIS.OnlineShoppingCart.dev.service.UserService;


@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping("/dang-nhap")
    public String hello(Model model) {


        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/dang-nhap")
    public String addUser(@ModelAttribute("userDTO") UserDTO userDTO) {

        userService.addUser(userDTO);

        return "/login";
    }

    @GetMapping("/access-deny")
    public String accessDeny(HttpServletRequest req) {
        return "access-deny";
    }
}
