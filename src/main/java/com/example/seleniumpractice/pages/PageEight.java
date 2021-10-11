package com.example.seleniumpractice.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.example.seleniumpractice.test.TestPF;

public class PageEight {

    static final Logger logger = LogManager.getLogger(TestPF.class);
    WebDriver driver;

    @FindBy(id = "OB01.INFO.LEGAL")
    WebElement proceduresForAppeal;

    @FindBy(xpath = "//*[@id=\"formShab\"]/div[1]/div[4]/input[2]")
    WebElement done;
    @FindBy(className = "created")
    WebElement doneCheck;

    public PageEight(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void setProceduresForAppeal(String strProceduresForAppeal) {
        proceduresForAppeal.sendKeys(strProceduresForAppeal);
        if(strProceduresForAppeal.equals("")) {
            logger.error("Procedures for appeal can not be null!");
            throw new RuntimeException("Procedures for appeal can not be null!");
        }
    }

    public void clickDone() {done.click();}
    public void checkDone() {
        if (!doneCheck.isDisplayed()) {
            logger.error("Form is not successfully completed.");
            throw new RuntimeException("Form is not successfully completed.");
        } else logger.info("Form successfully completed!");
    }

    public void fillInPageEight(String strProceduresForAppeal) {
        this.setProceduresForAppeal(strProceduresForAppeal);
        this.clickDone();
        this.checkDone();
    }

}
