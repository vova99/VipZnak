package com.vipznak.adressTBL.DAO.service;

import com.vipznak.adressTBL.DAO.entity.Tables;

import java.util.List;

public interface TablesService {
    void save(Tables tb);
    Tables findById(int id);
    List<Tables> findAll();
    void deleteByID(int id);
}
