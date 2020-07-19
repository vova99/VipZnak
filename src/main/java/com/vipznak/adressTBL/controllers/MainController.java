package com.vipznak.adressTBL.controllers;

import com.vipznak.adressTBL.DAO.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    TablesService tablesService;

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("tables",tablesService.findAll());
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

