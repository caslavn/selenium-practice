package com.example.seleniumpractice.readfactory;

import com.example.seleniumpractice.dto.TenderDetailsDTO;
import com.example.seleniumpractice.repository.TenderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class DatabaseRead implements ReadingOperation {

    @Autowired
    TenderDetailsRepository tenderDetailsRepository;

    @Override
    public String getType() {
        return "database";
    }

    //static {
      //  ReadingFactory.register("database", DatabaseRead.class);
    //}

    @Override
    public List<TenderDetailsDTO> read() {

        List<TenderDetailsDTO> tenderDTOList = new ArrayList<>();

        tenderDetailsRepository.findAll().forEach(tenderDetails -> {
            TenderDetailsDTO tenderDetailsDTO = new TenderDetailsDTO(tenderDetails);


            tenderDTOList.add(tenderDetailsDTO);
        });
        return tenderDTOList;
    }
}
