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

public class PageOne {

    static final Logger logger = LogManager.getLogger(TestPF.class);

    WebDriver driver;

    @FindBy(xpath="//*[@id=\"Formcontent\"]/form/div[2]/div[2]/table/tbody/tr[1]/td[1]/b/a")
    WebElement newTender;
    @FindBy(id="NOTICE.REF")
    WebElement fileReference;
    @FindBy(id="cal-field-SIMAP.PUB.DATE")
    WebElement desiredDateOfPublication;
    @FindBy(name = "OB.CONT.TYPE")
    List<WebElement> RadioButtonOrder;
    @FindBy(name = "OB.PROC")
    List<WebElement> RadioButtonProcedure;
    @FindBy(name = "OB.WTO")
    List<WebElement> RadioButtonScope;
    @FindBy(xpath = "//*[@id=\"Formcontent\"]/div[2]/div[4]/span/a")
    WebElement page2;
    @FindBy(className = "orange")
    WebElement page2Check;

    public PageOne(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    public void clickNewTender(){

        newTender.click();
    }
    public void setFileReference (String strFileReference) {

        fileReference.sendKeys(strFileReference);
        if(strFileReference.equals("")) {
            logger.error("File reference can not be null!");
            throw new RuntimeException("File reference can not be null!");
        }
    }
    public void setDesiredDateOfPublication(String strDesiredDateOfPublication) {
        desiredDateOfPublication.sendKeys(strDesiredDateOfPublication);
        if(strDesiredDateOfPublication.equals("")) {
            logger.error("Desired date of publication can not be null!");
            throw new RuntimeException("Desired date of publication can not be null!");
        }
    }
    public void setRadioButtonOrder(String strOrder) {
        for(int i=0; i < RadioButtonOrder.size(); i++)
        {
            String val = RadioButtonOrder.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strOrder))
            {
                RadioButtonOrder.get(i).click();
                break;
            }
        }
    }
    public void setRadioButtonProcedure(String strProcedure) {
        for(int i=0; i < RadioButtonProcedure.size(); i++)
        {
            String val = RadioButtonProcedure.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strProcedure))
            {
                RadioButtonProcedure.get(i).click();
                break;
            }
        }
    }
    public void setRadioButtonScope(String strScope) {
        for(int i=0; i < RadioButtonScope.size(); i++)
        {
            String val = RadioButtonScope.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strScope))
            {
                RadioButtonScope.get(i).click();
                break;
            }
        }
    }
    public void clickPage2() {

        page2.click();

    }
    public void checkPage2(){
        if(!Objects.equals(page2Check.getText(), "Schritt 2")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        }
        else logger.info("First page done!");
    }
    public void fillInPageOne(String strFileReference, String strOrder, String strProcedure, String strScope, String strDesiredDateOfPublication) {

        this.clickNewTender();
        this.setFileReference(strFileReference);
        this.setRadioButtonOrder(strOrder);
        this.setRadioButtonProcedure(strProcedure);
        this.setRadioButtonScope(strScope);
        this.setDesiredDateOfPublication(strDesiredDateOfPublication);
        this.clickPage2();
        this.checkPage2();

    }

}
