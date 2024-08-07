package org.example.hometask;

import com.fasterxml.jackson.annotation.JsonProperty;



public class TotalResponse {
    @JsonProperty
    private DataResponse data;
    @JsonProperty
    private SupportResponse support;


    public DataResponse getData() {
        return data;
    }

    public void setData(DataResponse data) {
        this.data = data;
    }

    public SupportResponse getSupport() {
        return support;
    }

    public void setSupport(SupportResponse support) {
        this.support = support;
    }
}



