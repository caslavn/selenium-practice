package com.example.seleniumpractice.controller;

import com.example.seleniumpractice.dto.ClientDTO;
import com.example.seleniumpractice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public List<ClientDTO> getClientById() {
        return clientService.getClient();
    }
}
