package com.id.latihan.latihanspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.id.latihan.latihanspring.common.CommonEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class DataCustomer extends CommonEntity{

    @Id
   
    @GeneratedValue
    private Long Id;

    @Column
    private String nama;

    @Column
    private String alamat;

    @Column
    private String noHp;

    @Column
    private String gender;

    @Column
    private int jumlahBaju;

    @Column
    private int totalHarga;

    @ManyToOne
    @JoinColumn(name = "id_Databaju", referencedColumnName = "id")
    private DataBaju dataBaju;

    
}
