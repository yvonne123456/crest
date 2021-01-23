package com.hcc.crest.request;

import lombok.Data;

@Data
public class CardTypeRequest {


    private String appName;

    private Integer status;

    private String cardType;

    private String remark;

    private String image;




}
