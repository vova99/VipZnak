package com.vipznak.adressTBL.controllers;

import com.vipznak.adressTBL.DAO.entity.Tables;
import com.vipznak.adressTBL.DAO.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/orderTableById-{id}")
    public String orderTableById(@PathVariable("id")int id,@RequestParam("selectColor") String selectColor,
                                                         @RequestParam("selectPrice") String selectPrice,
                                                         @RequestParam(value = "checkSwitch",required = false) String checkSwitch, Model model){
        Tables table = tablesService.findById(id);
        model.addAttribute("table",tablesService.findById(id));
        if (checkSwitch!=null){
            selectPrice = String.valueOf(Integer.valueOf(selectPrice)+180);
        }
        model.addAttribute("selectColor",selectColor);
        model.addAttribute("selectPrice",selectPrice);
        model.addAttribute("checkSwitch",checkSwitch);
        System.out.println(checkSwitch);
        return "order";
    }


    // Admin Controller

}

