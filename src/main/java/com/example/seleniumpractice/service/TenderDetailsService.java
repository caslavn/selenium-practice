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
        //Tender tender = tenderRepository.findOneById(id);
        //TenderDetails tender = tenderDetailsRepository.findOneById(id);

        tenderDetailsRepository.findAll().forEach(tenderDetails -> {
            TenderDetailsDTO tenderDetailsDTO = new TenderDetailsDTO(tenderDetails);

            tenderDetails.getTender().getId();
            //tenderDetailsDTO.setClient_id(tenderDetails.getTender().getClient().getId());
            //tenderDetailsDTO.setUsername(tenderDetails.getTender().getClient().getUsername());


            tenderDTOList.add(tenderDetailsDTO);
        });
        return tenderDTOList;
    }


}
