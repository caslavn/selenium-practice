package com.example.seleniumpractice.factory;

import com.example.seleniumpractice.pagefactory.SimapLoginFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader implements ReaderOperation {

    WebDriver driver;

    SimapLoginFactory simapLoginFactory;

    @DataProvider(name = "dp")
    public String[] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("/home/dev555/IdeaProjects/selenium-practice/jsonfiles/simap.json");

        Object obj = jsonParser.parse(reader);

        JSONObject jsonObj = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonObj.get("form");

        String arr[] = new String[jsonArray.size()];

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject data = (JSONObject) jsonArray.get(i);
            String fileReference = (String) data.get("NOTICE.REF");
            arr[i] = fileReference;
        }
        return arr;
    }

    @Override
    public void read() {

        System.out.println("Logged in from json.");

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.schulung.simap.ch/shabforms/COMMON/login/login.jsf?view=3&GO=Projectmanager");
        simapLoginFactory = new SimapLoginFactory(driver);

        //login to application
        simapLoginFactory.loginToSimapFactory("olmero-test", "jbZVF659aNYrkMp");
        simapLoginFactory.clickLogin();

    }
}
