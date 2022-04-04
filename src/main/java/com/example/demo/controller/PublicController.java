package com.example.demo.controller;

import com.example.demo.Model.User;
import com.example.demo.Service.APICall;
import com.example.demo.Service.UserCURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class PublicController {


    APICall api;

    @GetMapping("/")
    public String homePage(Model model) {
        return "home";
    }

    @GetMapping("/message")
    public String message(Model model) {
        model.addAttribute("message", "This is a custom message");
        System.out.println("test");
        String s = "s";
        return "message";
    }

    @PostMapping("/summaryText")
    public String getStringApi(@RequestParam("text") String text, Model model) throws IOException, InterruptedException {
        String check = api.check(text);
        model.addAttribute("message1", text);
        model.addAttribute("message2", check);
        return "home";
    }

    @Autowired
    private UserCURDService userCURDService;

    @PostMapping("/private/save")
    public String save(User user) {
        System.out.println("inside save method");
        this.userCURDService.save(user);
        return "Login";
    }

    @GetMapping("/signin")
    public String login_page() {
        return "Login";
    }

    @GetMapping("/register")
    public String register_page() {
        return "register";
    }
}