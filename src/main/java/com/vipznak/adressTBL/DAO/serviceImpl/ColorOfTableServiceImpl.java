package com.vipznak.adressTBL.DAO.serviceImpl;

import com.vipznak.adressTBL.DAO.entity.ColorOfTables;
import com.vipznak.adressTBL.DAO.jpa.ColorOfTablesJPA;
import com.vipznak.adressTBL.DAO.service.ColorOfTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ColorOfTableServiceImpl implements ColorOfTableService {
    @Autowired
    ColorOfTablesJPA colorOfTablesJPA;

    @Override
    public void save(ColorOfTables ob) {
        colorOfTablesJPA.save(ob);
    }

    @Override
    public ColorOfTables findById(int id) {
        return colorOfTablesJPA.getOne(id);
    }

    @Override
    public List<ColorOfTables> findAll() {
        return colorOfTablesJPA.findAll();
    }

    @Override
    public void deleteByID(int id) {
        colorOfTablesJPA.deleteById(id);
    }
}
