package com.vipznak.adressTBL.DAO.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ColorOfTables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int colorID;
    private String imgPath;
    private String colorName;
}
