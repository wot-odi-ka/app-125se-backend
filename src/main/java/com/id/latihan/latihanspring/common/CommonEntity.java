package com.id.latihan.latihanspring.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class CommonEntity {
   @Column(name = "CREATED_BY")
   private String createdBy;

   @Column(name = "CREATED_DT")
   private Date createdDt;

   @Column(name = "CHANGED_BY")
   private String changedBy;

   @Column(name = "CHANGED_DT")
   private Date changedDt;

   @Column(name = "DELETED_FLAG")
   private Boolean deletedFlag;

}
