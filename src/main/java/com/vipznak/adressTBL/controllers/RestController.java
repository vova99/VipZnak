package com.vipznak.adressTBL.controllers;

import com.vipznak.adressTBL.DAO.entity.Tables;
import com.vipznak.adressTBL.DAO.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    TablesService tablesService;

    @PostMapping("/sendCall")
    public void sendCallRequest(String userName, String phone){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("chinchillareal@gmail.com");

        msg.setSubject("VIPZnak: Завка на зворотній зв'язок");
        msg.setText("Ім'я: "+userName+"\nТелефон: "+phone);

        javaMailSender.send(msg);
    }

    @PostMapping("/sendOrder")
    public void sendOrderRequest(String tableID, String userName, String phoneNumber, String textOnTable,
                                 String adressDelivery, String colorName, String size, String price, String switchInput){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("chinchillareal@gmail.com");

        msg.setSubject("VIPZnak: Завка на виголовлення таблиці");
        msg.setText("Ім'я: "+userName
                    +"\nТелефон: "+phoneNumber
                    +"\nНазва вулиці: "+textOnTable
                    +"\nАдреса доставки: "+adressDelivery
                    +"\nНазва таблиці: "+adressDelivery
                    +"\nНазва кольору: "+colorName
                    +"\nРозмір: "+size
                    +"\nСвітло відбиваюча основа: "+switchInput
                    +"\nЦіна: "+price
        );

        javaMailSender.send(msg);
    }
}
