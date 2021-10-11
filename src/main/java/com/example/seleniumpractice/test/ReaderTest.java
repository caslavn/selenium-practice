package com.example.seleniumpractice.test;

import com.example.seleniumpractice.factory.BaseReaderFactory;
import com.example.seleniumpractice.factory.ReaderFactory;
import com.example.seleniumpractice.factory.ReaderOperation;
import org.testng.annotations.Test;

public class ReaderTest {

    @Test
    public void testLogin(){
        BaseReaderFactory loginFactory = new ReaderFactory();
        ReaderOperation databaseRead = loginFactory.createRead("database");
        ReaderOperation jsonRead = loginFactory.createRead("json");
    }
}
