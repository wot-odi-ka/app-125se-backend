package com.id.latihan.latihanspring.payload.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataBajuResponse {

    private Long total;
    private String ukuran;

    public DataBajuResponse(String ukuran,long total) {
	    this.ukuran = ukuran;
        this.total = total;
	  }

    
}
