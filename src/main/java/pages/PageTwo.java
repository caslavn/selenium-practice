package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import test.TestPF;

import java.util.List;
import java.util.Objects;

public class PageTwo {

    static final Logger logger = LogManager.getLogger(TestPF.class);
    WebDriver driver;


    @FindBy(id="AUTH.CONTACT-AUTH.DEMAND")
    WebElement contractingAuthority;
    @FindBy(id="AUTH.CONTACT-AUTH.CANTONCODE")
    WebElement canton;
    @FindBy(id="AUTH.CONTACT-AUTH.NAME")
    WebElement organizer;
    @FindBy(id="AUTH.CONTACT-ADDRESS-STREET")
    WebElement addressOfCA;
    @FindBy(id="AUTH.CONTACT-ADDRESS-ZIPCODE")
    WebElement postalCodeOfCA;
    @FindBy(id="AUTH.CONTACT-ADDRESS-CITY")
    WebElement city;
    @FindBy(id="AUTH.CONTACT-ADDRESS-COUNTRY")
    WebElement countryOfCA;
    @FindBy(id="AUTH.CONTACT-ADDRESS-EMAIL")
    WebElement emailOfCA;
    @FindBy(name = "AUTH.SEND-TYPE")
    List<WebElement> RadioButtonAddress;
    @FindBy(name = "OB01.COND.SEND.DEADLINE-RADIO")
    List<WebElement> RadioButtonDeadLine;
    @FindBy(id="cal-field-OB01.COND.SEND.DEADLINE.DATE")
    WebElement submittingDeadline;
    @FindBy(id="cal-field-OB01.COND.OFFER.OPEN.DATE")
    WebElement dateOfTheOpeningOfBids;
    @FindBy(id="OB01.COND.SEND.DEADLINE.DAYS")
    WebElement days;

    @FindBy(id="AUTH.SEND-AUTH.NAME")
    WebElement addressName;
    @FindBy(id="AUTH.SEND-ADDRESS-STREET")
    WebElement addressStreet;
    @FindBy(id="AUTH.SEND-ADDRESS-ZIPCODE")
    WebElement addressZip;
    @FindBy(id="AUTH.SEND-ADDRESS-CITY")
    WebElement addressCity;
    @FindBy(id="AUTH.SEND-ADDRESS-COUNTRY")
    WebElement addressCountry;
    @FindBy(id="AUTH.SEND-ADDRESS-EMAIL")
    WebElement addressEmail;

    @FindBy(xpath = "//*[@id=\"formShab\"]/div[1]/div[4]/input[2]")
    WebElement page3;
    @FindBy(className = "orange")
    WebElement page3Check;

    public PageTwo(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    public void setContractingAuthority (String strContractingAuthority) {

        contractingAuthority.sendKeys(strContractingAuthority);
        if(strContractingAuthority.equals("")) {
            logger.error("Contracting authority can not be null!");
            throw new RuntimeException("Contracting authority can not be null!");
        }
    }
    public void setCanton (String strCanton) {

        Select cantonDropDown = new Select(canton);
        cantonDropDown.selectByVisibleText(strCanton);
        if(strCanton.equals("")) {
            logger.error("Canton is not selected!");
            throw new RuntimeException("Canton is not selected!");
        }
    }
    public void setOrganizer(String strOrganizer) {

        organizer.sendKeys(strOrganizer);
        if(strOrganizer.equals("")) {
            logger.error("Organizer can not be null!");
            throw new RuntimeException("Organizer can not be null!");
        }
    }
    public void setAddressOfCA(String strAddressOfCA) {

        addressOfCA.sendKeys(strAddressOfCA);
        if(strAddressOfCA.equals("")) {
            logger.error("Address of CA can not be null!");
            throw new RuntimeException("Address of CA can not be null!");
        }
    }
    public void setPostalCodeOfCA(String strPostalCodeOfCA) {

        postalCodeOfCA.sendKeys(strPostalCodeOfCA);
        if(strPostalCodeOfCA.equals("")) {
            logger.error("Postal code of CA can not be null!");
            throw new RuntimeException("Postal code of CA can not be null!");
        }
    }
    public void setCity(String strCity) {

        city.sendKeys(strCity);
        if(strCity.equals("")) {
            logger.error("City can not be null!");
            throw new RuntimeException("City can not be null!");
        }
    }
    public void setCountryOfCA(String strCountryOfCA) {

        countryOfCA.sendKeys(strCountryOfCA);
        if(strCountryOfCA.equals("")) {
            logger.error("Country of CA can not be null!");
            throw new RuntimeException("Country of CA can not be null!");
        }
    }
    public void setEmailOfCA(String strEmailOfCA) {

        emailOfCA.sendKeys(strEmailOfCA);
        if(strEmailOfCA.equals("")) {
            logger.error("Email can not be null!");
            throw new RuntimeException("Email can not be null!");
        }
    }
    public void setRadioButtonAddress(String strAddress) {
        for(int i=0; i < RadioButtonAddress.size(); i++)
        {
            String val = RadioButtonAddress.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strAddress))
            {
                RadioButtonAddress.get(i).click();
                break;
            }
        }
    }
    public void setDays(String strDays) {
        days.sendKeys(strDays);
        if(strDays.equals("")) {
            logger.error("Required field not filled!");
            throw new RuntimeException("Required field not filled!");
        }
    }
    public void setAddressName(String strAddressName) {
        addressName.sendKeys(strAddressName);
        if(strAddressName.equals("")) {
            logger.error("Required field not filled!");
            throw new RuntimeException("Required field not filled!");
        }
    }
    public void setAddressStreet(String strAddressStreet) {
        addressStreet.sendKeys(strAddressStreet);
        if(strAddressStreet.equals("")) {
            logger.error("Required field not filled!");
            throw new RuntimeException("Required field not filled!");
        }
    }
    public void setAddressZip(String strAddressZip) {
        addressZip.sendKeys(strAddressZip);
        if(addressZip.equals("")) {
            logger.error("Required field not filled!");
            throw new RuntimeException("Required field not filled!");
        }
    }
    public void setAddressCity(String strAddressCity) {
        addressCity.sendKeys(strAddressCity);
        if(strAddressCity.equals("")) {
            logger.error("Required field not filled!");
            throw new RuntimeException("Required field not filled!");
        }
    }
    public void setAddressCountry(String strAddressCountry) {
        addressCountry.sendKeys(strAddressCountry);
        if(strAddressCountry.equals("")) {
            logger.error("Required field not filled!");
            throw new RuntimeException("Required field not filled!");
        }
    }
    public void setAddressEmail(String strAddressEmail) {
        addressEmail.sendKeys(strAddressEmail);
        if(addressEmail.equals("")) {
            logger.error("Required field not filled!");
            throw new RuntimeException("Required field not filled!");
        }
    }
    public void setRadioButtonDeadLine(String strDeadLine) {
        for(int i=0; i < RadioButtonDeadLine.size(); i++)
        {
            String val = RadioButtonDeadLine.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strDeadLine))
            {
                RadioButtonDeadLine.get(i).click();
                break;
            }
        }
    }
    public void setSubmittingDeadline(String strSubmittingDeadLine) {
        submittingDeadline.sendKeys(strSubmittingDeadLine);
        if(strSubmittingDeadLine.equals("")) {
            logger.error("Submitting dead line can not be null!");
            throw new RuntimeException("Submitting dead line can not be null!");
        }
    }
    public void setDateOfTheOpeningOfBids(String strDateOfTheOpeningOfBids) {
        dateOfTheOpeningOfBids.sendKeys(strDateOfTheOpeningOfBids);
        if(strDateOfTheOpeningOfBids.equals("")) {
            logger.error("Date of the opening of bids can not be null!");
            throw new RuntimeException("Date of the opening of bids can not be null!");
        }
    }
    public void clickPage3() {
        page3.click();
    }
    public void checkPage3() {
        if(!Objects.equals(page3Check.getText(), "Schritt 3")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        }
        else logger.info("Second page done!");
    }
    public void fillInAddressInfo(String strAddressName, String strAddressStreet, String strAddressZip, String strAddressCity, String strAddressCountry, String strAddressEmail) {
        this.setAddressName(strAddressName);
        this.setAddressStreet(strAddressStreet);
        this.setAddressZip(strAddressZip);
        this.setAddressCity(strAddressCity);
        this.setAddressCountry(strAddressCountry);
        this.setAddressEmail(strAddressEmail);
    }
    public void fillInPageTwo(String strContractingAuthority, String strCanton, String strOrganizer, String strAddressOfCA, String strPostalCodeOfCA, String strCity,
                              String strCountryOfCA, String strEmailOfCA, String strAddress, String strDeadLine, String strDateOfTheOpeningOfBids) {
        this.setContractingAuthority(strContractingAuthority);
        this.setOrganizer(strOrganizer);
        this.setAddressOfCA(strAddressOfCA);
        this.setPostalCodeOfCA(strPostalCodeOfCA);
        this.setCity(strCity);
        this.setCountryOfCA(strCountryOfCA);
        this.setEmailOfCA(strEmailOfCA);
        this.setRadioButtonAddress(strAddress);
        this.setRadioButtonDeadLine(strDeadLine);
        this.setCanton(strCanton);
        this.setDateOfTheOpeningOfBids(strDateOfTheOpeningOfBids);
    }
    public void fillInDeadlineDate(String strSubmittingDeadLine) {
        this.setSubmittingDeadline(strSubmittingDeadLine);
    }
    public void fillInDeadlineDays(String strDays) {
        this.setDays(strDays);
    }
    public void goToPage3() {
        this.clickPage3();
        this.checkPage3();
    }

}

