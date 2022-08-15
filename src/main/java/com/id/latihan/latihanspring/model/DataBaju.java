package com.id.latihan.latihanspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "baju")
public class DataBaju {

    @Id
    private long id;

    @Column
    private String namaBaju;

    @Column
    private String ukuranBaju;

    @Column
    private int hargaBaju;

    @Column
    private String warnaBaju;

    @Column
    private String jenisBaju;




    
}
