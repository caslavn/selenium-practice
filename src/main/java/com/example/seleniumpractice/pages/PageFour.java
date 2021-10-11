package com.example.seleniumpractice.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.example.seleniumpractice.test.TestPF;

import java.util.List;
import java.util.Objects;

public class PageFour {

    static final Logger logger = LogManager.getLogger(TestPF.class);
    WebDriver driver;

    @FindBy(id="CONT.CPV.LIST")
    WebElement cpv;
    @FindBy(id="CONT.DESCR")
    WebElement subjectAndScopeOfTheContract;
    @FindBy(id="CONT.LOC")
    WebElement locationOfImplementation;
    @FindBy(id="cal-field-TIMEFRAME-DATE.START")
    WebElement dateStart;
    @FindBy(id="cal-field-TIMEFRAME-DATE.END")
    WebElement dateEnd;
    @FindBy(name = "TIMEFRAME-RADIO")
    List<WebElement> RadioButtonDuration;
    @FindBy(id="TIMEFRAME-MONTHS")
    WebElement timeframeMonths;
    @FindBy(name = "OPTION-RADIO")
    List<WebElement> RadioButtonOptions;
    @FindBy(name = "AWARD.CRITERIA-VALUE")
    List<WebElement> RadioButtonAward;
    @FindBy(name = "LOT.SUBMIT-TO")
    List<WebElement> RadioButtonOffers;
    @FindBy(id="LOT.SUBMIT-MAXCOUNT")
    WebElement maxCount;

    @FindBy(xpath = "//*[@id=\"formShab\"]/div[1]/div[3]/input[2]")
    WebElement page5;
    @FindBy(className = "orange")
    WebElement page5Check;

    public PageFour(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    public void setCpv(String strCpv) {
        cpv.sendKeys(strCpv);
        if(strCpv.equals("")) {
            logger.error("CPV can not be null!");
            throw new RuntimeException("CPV can not be null!");
        }
    }
    public void setSubjectAndScopeOfTheContract(String strSubjectAndScope) {
        subjectAndScopeOfTheContract.sendKeys(strSubjectAndScope);
        if(strSubjectAndScope.equals("")) {
            logger.error("Subject and scope of the contract can not be null!");
            throw new RuntimeException("Subject and scope of the contract can not be null!");
        }
    }
    public void setLocationOfImplementation(String strLocation) {
        locationOfImplementation.sendKeys(strLocation);
        if(locationOfImplementation.equals("")) {
            logger.error("Location of implementation can not be null!");
            throw new RuntimeException("Location of implementation can not be null!");
        }
    }
    public void setDateStart(String strDateStart) {
        dateStart.sendKeys(strDateStart);
        if (strDateStart.equals("")) {
            logger.error("Start date can not be null!");
            throw new RuntimeException("Start date can not be null!");
        }
    }
    public void setDateEnd(String strDateEnd) {
        dateEnd.sendKeys(strDateEnd);
        if (strDateEnd.equals("")) {
            logger.error("End date can not be null!");
            throw new RuntimeException("End date can not be null!");
        }
    }
    public void setRadioButtonAward(String strAward) {
        for(int i=0; i < RadioButtonAward.size(); i++)
        {
            String val = RadioButtonAward.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strAward))
            {
                RadioButtonAward.get(i).click();
                break;
            }
        }
    }
    public void setRadioButtonOptions(String strOptions) {
        for(int i=0; i < RadioButtonOptions.size(); i++)
        {
            String val = RadioButtonOptions.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strOptions))
            {
                RadioButtonOptions.get(i).click();
                break;
            }
        }
    }
    public void setRadioButtonDuration(String strDuration) {
        for(int i=0; i < RadioButtonDuration.size(); i++)
        {
            String val = RadioButtonDuration.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strDuration))
            {
                RadioButtonDuration.get(i).click();
                break;
            }
        }
    }
    public void setTimeframeMonths(String strTimeframeMonths) {
        timeframeMonths.sendKeys(strTimeframeMonths);
        if (strTimeframeMonths.equals("")) {
            logger.error("Required field not filled!");
            throw new RuntimeException("Required field not filled!");
        }
    }
    public void setRadioButtonOffers(String strOffers) {
        for(int i=0; i < RadioButtonOffers.size(); i++)
        {
            String val = RadioButtonOffers.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strOffers))
            {
                RadioButtonOffers.get(i).click();
                break;
            }
        }
    }
    public void setMaxCount(String strMaxCount) {
        maxCount.sendKeys(strMaxCount);
        if (strMaxCount.equals("")) {
            logger.error("Required field not filled!");
            throw new RuntimeException("Required field not filled!");
        }
    }
    public void clickPage5() {
        page5.click();
    }
    public void checkPage5() {
        if (!Objects.equals(page5Check.getText(), "Schritt 5")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        } else logger.info("Fourth page done!");
    }
    public void fillCaseOne(String strDuration, String strOptions, String strAward) {
        this.setRadioButtonDuration(strDuration);
        this.setRadioButtonOptions(strOptions);
        this.setRadioButtonAward(strAward);
    }
    public void fillInTimeFrameDate(String strDateStart, String strDateEnd) {
        this.setDateStart(strDateStart);
        this.setDateEnd(strDateEnd);
    }
    public void fillInTimeFrameMonths(String strTimeFrameMonths) {
        this.setTimeframeMonths(strTimeFrameMonths);
    }

    public void fillCaseTwo (String strOffers) {
        this.setRadioButtonOffers(strOffers);
    }

    public void fillMaxCount(String strMaxCount) {
        this.setMaxCount(strMaxCount);
    }

    public void fillInPageFour (String strCpv, String strSubjectAndScope, String strLocation) {
        this.setCpv(strCpv);
        this.setSubjectAndScopeOfTheContract(strSubjectAndScope);
        this.setLocationOfImplementation(strLocation);
        this.clickPage5();
        this.checkPage5();
    }
}
