package com.FIS.OnlineShoppingCart.dev.controller;

import com.FIS.OnlineShoppingCart.dev.entities.Account;
import com.FIS.OnlineShoppingCart.dev.entities.Category;
import com.FIS.OnlineShoppingCart.dev.services.CategoryService;
import com.FIS.OnlineShoppingCart.dev.services.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller

public class BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = {"/", "/test"}, method = RequestMethod.GET)
    public String getAllCategory(ModelMap modelMap) {
        try {
            List<Category> all = categoryService.listAllCategory();
            for (Category u : all) {
                System.out.println(u.getName());

            }
            modelMap.addAttribute("Users", all);
        } catch (Exception e) {
        }
        return "test";
    }

}
