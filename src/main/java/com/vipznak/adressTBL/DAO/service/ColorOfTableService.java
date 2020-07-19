package com.vipznak.adressTBL.DAO.service;

import com.vipznak.adressTBL.DAO.entity.ColorOfTables;

import java.util.List;

public interface ColorOfTableService {
    void save(ColorOfTables ob);
    ColorOfTables findById(int id);
    List<ColorOfTables> findAll();
    void deleteByID(int id);
}
