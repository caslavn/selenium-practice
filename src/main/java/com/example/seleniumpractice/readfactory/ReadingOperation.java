package com.example.seleniumpractice.readfactory;

import com.example.seleniumpractice.dto.TenderDetailsDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReadingOperation {

    String getType();
    public List<TenderDetailsDTO> read();
}
