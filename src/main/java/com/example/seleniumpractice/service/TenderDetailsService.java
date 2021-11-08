package com.example.seleniumpractice.service;

import com.example.seleniumpractice.dto.TenderDetailsDTO;
import com.example.seleniumpractice.repository.TenderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenderDetailsService {

    @Autowired
    TenderDetailsRepository tenderDetailsRepository;

    public List<TenderDetailsDTO> getAllTenderDetails() {

        List<TenderDetailsDTO> tenderDTOList = new ArrayList<>();

        tenderDetailsRepository.findAll().forEach(tenderDetails -> {
            TenderDetailsDTO tenderDetailsDTO = new TenderDetailsDTO(tenderDetails);
            tenderDTOList.add(tenderDetailsDTO);
        });
        return tenderDTOList;
    }

    public List<TenderDetailsDTO> getTenderDetailsById(Integer tender_id) {
        return tenderDetailsRepository.findOneById(tender_id);
    }


}
