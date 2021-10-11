package com.example.seleniumpractice.service;

import com.example.seleniumpractice.dto.ClientDTO;
import com.example.seleniumpractice.pagefactory.SimapLoginFactory;
import com.example.seleniumpractice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    //@Autowired
    SimapLoginFactory simapLoginFactory;


    public List<ClientDTO> getClient() {

        List<ClientDTO> clientDTOList = new ArrayList<>();

        clientRepository.findAll().forEach(client -> {

            ClientDTO clientDTO = new ClientDTO(client);

            client.getUsername();
            client.getPassword();

            clientDTOList.add(clientDTO);

        });
        return clientDTOList;
    }
}
