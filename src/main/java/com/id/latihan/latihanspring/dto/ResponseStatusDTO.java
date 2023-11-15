package com.id.latihan.latihanspring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStatusDTO {

  private String fileinputId;
  private String sourceId;
  private String status;
  private String message;
  private String statusId;

  private String startDate;
  private String sendDate;
  private String dataList;

  
}
