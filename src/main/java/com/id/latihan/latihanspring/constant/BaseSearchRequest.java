package com.id.latihan.latihanspring.constant;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class BaseSearchRequest {
    @Min(1)
    @JsonAlias("page-no")
    @JsonProperty("page-no")
    private Integer pageNo = 1;
    @Min(1)
    @JsonAlias("page-size")
    @JsonProperty("page-size")
    private Integer pageSize = 10;

}
