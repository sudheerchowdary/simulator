package com.verizon.bnc.bncsimulator.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SBDataBean {

    @JsonProperty("id")
    private int id;
    @JsonProperty( "url")
    private String url;
    @JsonProperty("request-type")
    private String requestType;
    @JsonProperty("request-status")
    private String requestStatus;
    @JsonProperty("data")
    private String data;
}
