package com.example.seleniumpractice.readfactory;

import com.example.seleniumpractice.dto.TenderDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingFactory {

    @Autowired
    public DatabaseRead databaseRead;

    @Autowired
    public JsonRead jsonRead;

    public List<TenderDetailsDTO> getRead(){

        if (databaseRead.getType().equals("database")){
            return databaseRead.read();
        }else
            return jsonRead.read();
    }

    /*private static final Map<String, Class<? extends ReadingOperation>> instances = new HashMap<>();

    public static void register(String readingMedium, Class<? extends ReadingOperation> instance) {

        if (readingMedium !=null && instance != null){
            instances.put(readingMedium, instance);
        }
    }

    public List<TenderDetailsDTO> getInstance(String loggerMedium) {
        if (instances.isEmpty()){
            return null;
        }else
            return instances.get(loggerMedium);
    }*/

    /*public static ReadingOperation getInstance(String loggerMedium) {
        ReadingOperation op = null;
        switch (loggerMedium) {
            case "database":
                op = new DatabaseRead();
                break;
            case "json":
                op = new JsonRead();
                break;
        }

        return op;
    }*/
}
