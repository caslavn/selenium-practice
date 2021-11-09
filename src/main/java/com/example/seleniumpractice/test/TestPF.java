package com.example.seleniumpractice.test;

import com.example.seleniumpractice.login.LoginPF;
import com.example.seleniumpractice.model.TenderDetails;
import com.example.seleniumpractice.pages.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.annotation.PostConstruct;


public class TestPF {

    WebDriver driver;
    LoginPF objLogin;
    PageOne objPageOne;
    PageTwo objPageTwo;
    PageThree objPageThree;
    PageFour objPageFour;
    PageFive objPageFive;
    PageSix objPageSix;
    PageSeven objPageSeven;
    PageEight objPageEight;

    @PostConstruct
    public void init() {
        setup();
        testForm();
    }

    @BeforeTest
    public void setup() {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromerdriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.get("https://www.schulung.simap.ch/shabforms/COMMON/login/login.jsf?view=3&GO=Projectmanager");
    }

    @Test
    public void testForm() {

        Response response = RestAssured.get("http://localhost:8080/api/tender/detailsById");
        //System.out.println("Status code is: " +response.getStatusCode());
        //System.out.println(response.asPrettyString());
        TenderDetails[] tenders = response.jsonPath().getObject("", TenderDetails[].class);

        JsonPath jsonPath = response.jsonPath();

        objLogin = new LoginPF(driver);
        objLogin.loginToSimap("olmero-test", "jbZVF659aNYrkMp");

        // System.out.println(jsonPath.getString("find{it.field == 'NOTICE.REF'}.value"));

        objPageOne = new PageOne(driver);
        objPageOne.fillInPageOne(jsonPath.getString("find{it.field == 'NOTICE.REF'}.value"), jsonPath.getString("find{it.field == 'OB.CONT.TYPE'}.value"),
                jsonPath.getString("find{it.field == 'OB.PROC'}.value"), jsonPath.getString("find{it.field == 'OB.WTO'}.value"),
                jsonPath.getString("find{it.field == 'SIMAP.PUB.DATE'}.value"));

        objPageTwo = new PageTwo(driver);
        objPageTwo.fillInPageTwo(jsonPath.getString("find{it.field == 'AUTH.CONTACT-AUTH.DEMAND'}.value"),
                jsonPath.getString("find{it.field == 'AUTH.CONTACT-AUTH.CANTONCODE'}.value"),
                jsonPath.getString("find{it.field == 'AUTH.CONTACT-AUTH.NAME'}.value"),
                jsonPath.getString("find{it.field == 'AUTH.CONTACT-ADDRESS-STREET'}.value"),
                jsonPath.getString("find{it.field == 'AUTH.CONTACT-ADDRESS-ZIPCODE'}.value"),
                jsonPath.getString("find{it.field == 'AUTH.CONTACT-ADDRESS-CITY'}.value"),
                jsonPath.getString("find{it.field == 'AUTH.CONTACT-ADDRESS-COUNTRY'}.value"),
                jsonPath.getString("find{it.field == 'AUTH.CONTACT-ADDRESS-EMAIL'}.value"),
                jsonPath.getString("find{it.field == 'AUTH.SEND-TYPE'}.value"),
                jsonPath.getString("find{it.field == 'OB01.COND.SEND.DEADLINE-RADIO'}.value"),
                jsonPath.getString("find{it.field == 'OB01.COND.OFFER.OPEN.DATE'}.value"));
        if (jsonPath.getString("find{it.field == 'OB01.COND.SEND.DEADLINE-RADIO'}.value").equalsIgnoreCase("DATE")) {
            objPageTwo.fillInDeadlineDate(jsonPath.getString("find{it.field == 'OB01.COND.SEND.DEADLINE.DATE'}.value"));
        }
        if (jsonPath.getString("find{it.field == 'OB01.COND.SEND.DEADLINE-RADIO'}.value").equalsIgnoreCase("DAYS")) {
            objPageTwo.fillInDeadlineDays(jsonPath.getString("find{it.field == 'TIMEFRAME-MONTHS'}.value"));
        }
        if (jsonPath.getString("find{it.field == 'AUTH.SEND-TYPE'}.value").equalsIgnoreCase("DOC")) {
            objPageTwo.fillInAddressInfo(jsonPath.getString("find{it.field == 'AUTH.SEND-TYPE'}.value"),
                    jsonPath.getString("find{it.field == 'AUTH.SEND-ADDRESS-STREET'}.value"),
                    jsonPath.getString("find{it.field == 'AUTH.SEND-ADDRESS-ZIPCODE'}.value"),
                    jsonPath.getString("find{it.field == 'AUTH.SEND-ADDRESS-CITY'}.value"),
                    jsonPath.getString("find{it.field == 'AUTH.SEND-ADDRESS-COUNTRY'}.value"),
                    jsonPath.getString("find{it.field == 'AUTH.SEND-ADDRESS-EMAIL'}.value"));
        }
        objPageTwo.goToPage3();

        objPageThree = new PageThree(driver);
        if (jsonPath.getString("find{it.field == 'OB.CONT.TYPE'}.value").equalsIgnoreCase("WORKS")) {
            objPageThree.fillConstruction(jsonPath.getString("find{it.field == 'AUTH.SEND-AUTH.NAME'}.value"));
        }
        if (jsonPath.getString("find{it.field == 'OB.CONT.TYPE'}.value").equalsIgnoreCase("SUPPLIES")) {
            objPageThree.fillSupply(jsonPath.getString("find{it.field == 'LOT.SUBMIT-TO'}.value"));
        }
        objPageThree.fillInPageThree(jsonPath.getString("find{it.field == 'CONT.NAME'}.value"),
                jsonPath.getString("find{it.field == 'DIVISION.INTO.LOT'}.value"));

        objPageFour = new PageFour(driver);
        if (jsonPath.getString("find{it.field == 'DIVISION.INTO.LOT'}.value").equals("NO") || jsonPath.getString("find{it.field == 'DIVISION.INTO.LOT'}.value").equals("NOT_SPECIFIED")) {
            objPageFour.fillCaseOne(jsonPath.getString("find{it.field == 'TIMEFRAME-RADIO'}.value"),
                    jsonPath.getString("find{it.field == 'OPTION-RADIO'}.value"),
                    jsonPath.getString("find{it.field == 'AWARD.CRITERIA-VALUE'}.value"));
            if (jsonPath.getString("find{it.field == 'TIMEFRAME-RADIO'}.value").equalsIgnoreCase("DATE")) {
                objPageFour.fillInTimeFrameDate(jsonPath.getString("find{it.field == 'TIMEFRAME-DATE.START'}.value"),
                        jsonPath.getString("find{it.field == 'TIMEFRAME-DATE.END'}.value"));
            }
            if (jsonPath.getString("find{it.field == 'TIMEFRAME-RADIO'}.value").equalsIgnoreCase("PERIOD")) {
                objPageFour.fillInTimeFrameMonths(jsonPath.getString("find{it.field == 'CONT.MONTHS'}.value"));
            }
        }
        if (jsonPath.getString("find{it.field == 'DIVISION.INTO.LOT'}.value").equals("YES") || jsonPath.getString("find{it.field == 'DIVISION.INTO.LOT'}.value").equals("NOT_SPECIFIED")) {
            objPageFour.fillCaseTwo(jsonPath.getString("find{it.field == 'LOT.SUBMIT-MAXCOUNT'}.value"));
            if (jsonPath.getString("find{it.field == 'LOT.SUBMIT-MAXCOUNT'}.value").equalsIgnoreCase("MAX")) {
                objPageFour.fillMaxCount(jsonPath.getString("find{it.field == 'LOT.CPV.LIST_1'}.value"));
            }
        }
        objPageFour.fillInPageFour(jsonPath.getString("find{it.field == 'CONT.CPV.LIST'}.value"), jsonPath.getString("find{it.field == 'CONT.DESCR'}.value"),
                jsonPath.getString("find{it.field == 'CONT.LOC'}.value"));

        objPageFive = new PageFive(driver);
        objPageFive.fillPageFive(jsonPath.getString("find{it.field == 'CONT.VARIANTS'}.value"), jsonPath.getString("find{it.field == 'CONT.PARTIALS'}.value"));
        if (jsonPath.getString("find{it.field == 'DIVISION.INTO.LOT'}.value").equalsIgnoreCase("NO")) {
            objPageFive.fillCase(jsonPath.getString("find{it.field == 'CONT.DEADLINE-RADIO'}.value"));
            if (jsonPath.getString("find{it.field == 'CONT.DEADLINE-RADIO'}.value").equalsIgnoreCase("DATE")) {
                objPageFive.fillInContDate(jsonPath.getString("find{it.field == 'CONT.DATE.START'}.value"), jsonPath.getString("find{it.field == 'CONT.DATE.END'}.value"));
            }
            if (jsonPath.getString("find{it.field == 'CONT.DEADLINE-RADIO'}.value").equalsIgnoreCase("PERIOD")) {
                objPageFive.fillInContMonths(jsonPath.getString("find{it.field == 'OB01.COND.DOC.ADDRESS-VALUE'}.value"));
            }
            objPageFive.openPage6First();
        } else {
            objPageFive.openPage6Second();
        }

        objPageSix = new PageSix(driver);
        objPageSix.fillInPageSix(jsonPath.getString("find{it.field == 'OB01.COND.TECHNICAL-VALUE'}.value"),
                jsonPath.getString("find{it.field == 'OB01.COND.PROOF-VALUE'}.value"));

        objPageSeven = new PageSeven(driver);
        objPageSeven.fillInPageSeven();

        objPageEight = new PageEight(driver);
        objPageEight.fillInPageEight(jsonPath.getString("find{it.field == 'OB01.INFO.LEGAL'}.value"));


    }
}

