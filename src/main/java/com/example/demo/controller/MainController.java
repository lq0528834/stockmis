package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MainController
 */
@Controller
public class MainController {

    @Autowired
    JdbcTemplate jdbc;

    @RequestMapping("/checkuser")
    public String CheckUser(String uid, String upass, Model model) {
        String result = "fail";
        if (uid.equals("aa")&&upass.equals("123")) {
            result = "success";
        }
        result = jdbc.queryForObject("select @@version", String.class);
        model.addAttribute("result", result);
        model.addAttribute("uid", uid);
        return "info";
    }
    
}