package com.id.latihan.latihanspring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "status_log")
@Getter
@Setter
public class StatusLog implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fileinputId", nullable = false)
  private String fileinputId;
  
  @Column(name = "sourceId", nullable = false)
  private String sourceId;

  @Column(name = "statusId",nullable = false)
  private String statusId;
  
  @Column(name = "status", nullable = false)
  private String status;
  
  @Column(name = "message", nullable = false)
  private String message;
  
  @Column(name = "startDate", nullable = false)
  private String startDate;
  
  @Column(name = "sendDate", nullable = false)
  private String sendDate;
  
  @Column(name = "dataList", nullable = true, columnDefinition = "TEXT")
  private String dataList;
  
}
