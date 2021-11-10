package com.example.seleniumpractice.controller;

import com.example.seleniumpractice.dto.TenderDetailsDTO;
import com.example.seleniumpractice.model.TenderQueue;
import com.example.seleniumpractice.readfactory.ReadingFactory;
import com.example.seleniumpractice.repository.TenderDetailsRepository;
import com.example.seleniumpractice.service.TenderDetailsService;
import com.example.seleniumpractice.service.TenderQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tender")
public class TenderDetailsController {

    @Autowired
    ReadingFactory readingFactory;
    @Autowired
    TenderDetailsRepository tenderDetailsRepository;
    @Autowired
    TenderDetailsService tenderDetailsService;
    @Autowired
    TenderQueueService tenderQueueService;

    @GetMapping("/allDetails")
    public List<TenderDetailsDTO> getAllTenderDetails() {
        return readingFactory.getRead();
    }

    @GetMapping("/detailsById")
    public List<TenderDetailsDTO> getTenderById(Integer tender_id) {
        return tenderDetailsService.getTenderDetailsById(tender_id);
    }

    @GetMapping("/tenderQueue")
    public List<TenderQueue> getTender() {
        return tenderQueueService.getQueue();
    }


}
