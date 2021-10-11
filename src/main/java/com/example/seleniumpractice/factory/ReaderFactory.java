package com.example.seleniumpractice.factory;

public class ReaderFactory implements BaseReaderFactory {

    @Override
    public ReaderOperation createRead(String type) {

        ReaderOperation readerOperation;
        switch (type.toLowerCase()){
            case "database":
                readerOperation = new DatabaseReader();
                break;
            case "json":
                readerOperation = new JsonReader();
                break;
            default: throw new IllegalArgumentException("couldn't login.");
        }

        return readerOperation;
    }
}
