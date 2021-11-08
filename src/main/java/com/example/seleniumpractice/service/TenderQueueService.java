package com.example.seleniumpractice.service;

import com.example.seleniumpractice.dto.TenderDetailsDTO;
import com.example.seleniumpractice.model.TenderQueue;
import com.example.seleniumpractice.repository.TenderDetailsRepository;
import com.example.seleniumpractice.repository.TenderQueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TenderQueueService implements TenderQueueInterface {

    @Autowired
    TenderDetailsRepository tenderDetailsRepository;

    @Autowired
    TenderQueueRepository tenderQueueRepository;

    @Override
    public List<TenderQueue> getQueue() {
        return tenderQueueRepository.getQueue();
    }

    @Override
    public List<TenderQueue> updateStatus(@RequestParam(value = "tender_id", required = false) Integer tender_id, @RequestParam(value = "status", required = false) String status) {
        tenderQueueRepository.updateStatus(tender_id, status);
        return tenderQueueRepository.getQueue();
    }
}
