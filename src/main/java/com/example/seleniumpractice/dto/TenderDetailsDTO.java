package com.example.seleniumpractice.dto;

import com.example.seleniumpractice.model.TenderDetails;

import java.io.Serializable;

public class TenderDetailsDTO implements Serializable {

    String field;
    String value;

    public TenderDetailsDTO(TenderDetails tenderDetails) {
        this.field = tenderDetails.getField();
        this.value = tenderDetails.getValue();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
