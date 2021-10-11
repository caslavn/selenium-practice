package com.example.seleniumpractice.dto;

import com.example.seleniumpractice.model.Tender;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TenderDTO implements Serializable {

    Integer tender_id;
    List<TenderDetailsDTO> tenderDetails = new ArrayList<>();

    public TenderDTO(Tender tender) {
        this.tender_id = tender.getId();
    }

    public Integer getTender_id() {
        return tender_id;
    }

    public void setTender_id(Integer tender_id) {
        this.tender_id = tender_id;
    }

    public List<TenderDetailsDTO> getTenderDetails() {
        return tenderDetails;
    }

    public void setTenderDetails(List<TenderDetailsDTO> tenderDetails) {
        this.tenderDetails = tenderDetails;
    }
}
