package com.vipznak.adressTBL.DAO.entity;



import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tableID;
    private String nameTable;
    private String sizeSmall;
    private String sizeBig;
    private String priceForSmall;
    private String priceForBig;

    @OneToMany
    private List<ColorOfTables> colorList;
}
