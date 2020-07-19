package com.vipznak.adressTBL.controllers;

import com.vipznak.adressTBL.DAO.entity.ColorOfTables;
import com.vipznak.adressTBL.DAO.entity.Tables;
import com.vipznak.adressTBL.DAO.service.ColorOfTableService;
import com.vipznak.adressTBL.DAO.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class AdminController {
    @GetMapping("/adminPage")
    public String getAdminPage(Model model){
//        model.addAttribute("fragmentPathTables","allTables");
        return "redirect:/allTables";
    }


    // Tables controllers
    @Autowired
    TablesService tablesService;
    @Autowired
    ColorOfTableService colorService;

    @GetMapping("/allTables")
    public String allTables(Model model){
        model.addAttribute("tables",tablesService.findAll());
        model.addAttribute("fragmentPathTables","allTables");
        return "adminPage";
    }

    @PostMapping("/addTable")
    public String addTable(Model model, Tables table){
        tablesService.save(table);
        model.addAttribute("tables",tablesService.findAll());
        model.addAttribute("fragmentPathTables","allTables");
        return "redirect:/allTables";
    }
    @GetMapping("/deleteTable-{id}")
    public String deleteUser(@PathVariable("id") int id, Model model){
        tablesService.deleteByID(id);
        return "redirect:/allTables";
    }

    @GetMapping("/changeColor-{id}")
    public String changeColor(@PathVariable("id")int id, Model model){
        Tables table = tablesService.findById(id);

        model.addAttribute("colors",table.getColorList());
        model.addAttribute("table",tablesService.findById(id));
        model.addAttribute("fragmentPathTables","colorChange");
        return "adminPage";
    }

    @PostMapping("/addColor-{id}")
    public String addColor(@PathVariable("id")int id, @RequestParam MultipartFile photo, Model model, ColorOfTables color) throws IOException {
        Tables table = tablesService.findById(id);

        String path = System.getProperty("user.home")+ File.separator;
        photo.transferTo(new File(path+table.getTableID()+photo.getOriginalFilename()));


        color.setImgPath("/img/"+table.getTableID()+photo.getOriginalFilename());
        colorService.save(color);
        table.getColorList().add(color);
        tablesService.save(table);
        return "redirect:/changeColor-"+String.valueOf(id);
    }
    @GetMapping("/deleteColor-{id}-{idTable}")
    public String deleteColor(@PathVariable("id")int id,@PathVariable("idTable")int idTable){
        colorService.deleteByID(id);
        return "redirect:/changeColor-"+idTable;
    }
}
