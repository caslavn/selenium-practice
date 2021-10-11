package com.example.seleniumpractice.controller;

import com.example.seleniumpractice.dto.TenderDTO;
import com.example.seleniumpractice.dto.TenderDetailsDTO;
import com.example.seleniumpractice.service.TenderDetailsService;
import com.example.seleniumpractice.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tender")
public class TenderDetailsController {

    @Autowired
    TenderDetailsService tenderDetailsService;
    @Autowired
    TenderService tenderService;

    @GetMapping
    public List<TenderDetailsDTO> getAllTenderDetails(@RequestParam(value = "id", required = false) Integer id) {
        return tenderDetailsService.getAllTenderDetails();
    }

    @GetMapping("/ten")
    public List<TenderDTO> getAllTenderDetails() {
        return tenderService.getAllTenderDetails();
    }


}
