package com.example.seleniumpractice.service;

import com.example.seleniumpractice.dto.TenderDetailsDTO;
import com.example.seleniumpractice.model.TenderQueue;

import java.util.List;

public interface TenderQueueInterface {

    List<TenderQueue> getQueue();

    List<TenderQueue> updateStatus(Integer tender_id, String status);

}
