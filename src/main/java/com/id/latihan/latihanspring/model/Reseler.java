package com.id.latihan.latihanspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.id.latihan.latihanspring.common.CommonEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reseler")
@Getter
@Setter
public class Reseler extends CommonEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String alamat;

  @Column
  private int noHp;

  @Column
  private int discond;

  @Column
  private int jumlahBaju;

  @Column
  private int totalHarga;

    @ManyToOne
    @JoinColumn(name = "id_Databaju", referencedColumnName = "id")
    private DataBaju dataBaju;
  
}
