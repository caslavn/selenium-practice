package com.example.seleniumpractice.service;

import com.example.seleniumpractice.dto.TenderDTO;
import com.example.seleniumpractice.dto.TenderDetailsDTO;
import com.example.seleniumpractice.repository.TenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenderService {

    @Autowired
    TenderRepository tenderRepository;

    public List<TenderDTO> getAllTenderDetails() {

        List<TenderDTO> tenderDTOList = new ArrayList<>();

        tenderRepository.findAll().forEach(tender -> {
            TenderDTO tenderDTO = new TenderDTO(tender);

            tender.getTenderDetails().forEach(tenderDetails -> {
                tenderDTO.getTenderDetails().add(new TenderDetailsDTO(tenderDetails));
            });

            tenderDTOList.add(tenderDTO);
        });
        return tenderDTOList;
    }

}
