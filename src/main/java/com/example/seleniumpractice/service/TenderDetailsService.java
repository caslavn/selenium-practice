package com.example.seleniumpractice.service;

import com.example.seleniumpractice.dto.TenderDetailsDTO;
import com.example.seleniumpractice.repository.TenderDetailsRepository;
import com.example.seleniumpractice.repository.TenderQueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenderDetailsService {

    @Autowired
    TenderDetailsRepository tenderDetailsRepository;
    @Autowired
    TenderQueueRepository tenderQueueRepository;

    public List<TenderDetailsDTO> getAllTenderDetails() {

        List<TenderDetailsDTO> tenderDTOList = new ArrayList<>();

        tenderDetailsRepository.findAll().forEach(tenderDetails -> {
            TenderDetailsDTO tenderDetailsDTO = new TenderDetailsDTO(tenderDetails);
            tenderDTOList.add(tenderDetailsDTO);
        });
        return tenderDTOList;
    }

    public List<TenderDetailsDTO> getTenderDetailsById(Integer tender_id) {
        return tenderDetailsRepository.findOneById(tenderQueueRepository.getQueue().stream().findFirst().get().getTender_id());
    }


}
