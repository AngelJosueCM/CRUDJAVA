package com.example.blogStepOne.controller;

import com.example.blogStepOne.models.dao.IUserDAO;
import com.example.blogStepOne.models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import java.util.Map;
import java.util.Objects;

@Controller
@SessionAttributes("user")
public class UserController {
    @Autowired
    @Qualifier("UserDAOJPA")
    private IUserDAO userDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("title", "Users List");
        model.addAttribute("users", userDAO.findAll());
        return "list";
    }

    @RequestMapping(value = "/form")
    public String create(Map<String, Object> model){
            User user = new User();
            model.put("user", user);
            model.put("buttonTitle", "Create User");
            model.put("title", "user Form");
            return "form";

        }
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String save(@Valid User user, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("title", "User Form");
            model.addAttribute("buttonTitle", "Create User");
            return "form";
        }
        userDAO.save(user);
        status.setComplete();
        return "redirect:list";
    }
}
