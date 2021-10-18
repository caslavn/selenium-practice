package com.example.seleniumpractice.readfactory;

import com.example.seleniumpractice.dto.TenderDetailsDTO;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class JsonRead implements ReadingOperation {


    JSONArray simapJson = new JSONArray();

    @Override
    public String getType() {
        return "json";
    }

    //static {
      //  ReadingFactory.register("json", JsonRead.class);
    //}

    @Override
    public List<TenderDetailsDTO> read() {

        JSONParser jsonParser = new JSONParser();

        try(FileReader reader = new FileReader("/home/dev555/IdeaProjects/selenium-practice/jsonfiles/simap.json")) {

            Object obj = jsonParser.parse(reader);
            simapJson.add(obj);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return simapJson;
    }
}
