package com.vipznak.adressTBL.DAO.serviceImpl;

import com.vipznak.adressTBL.DAO.entity.Tables;
import com.vipznak.adressTBL.DAO.jpa.TablesJPA;
import com.vipznak.adressTBL.DAO.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablesServiceImpl implements TablesService {
    @Autowired
    TablesJPA tablesJPA;

    @Override
    public void save(Tables tb) {
        tablesJPA.save(tb);
    }

    @Override
    public Tables findById(int id) {
        return tablesJPA.getOne(id);
    }

    @Override
    public List<Tables> findAll() {
        return tablesJPA.findAll();
    }

    @Override
    public void deleteByID(int id) {
        tablesJPA.deleteById(id);
    }
}
