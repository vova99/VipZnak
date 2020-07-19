package com.vipznak.adressTBL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private JavaMailSender javaMailSender;


    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/sendOrder")
    public String sendOrder(){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("chinchillareal@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);
        return "redirect:/";
    }

    // Admin Controller

}

