package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.TestPF;

import java.util.List;
import java.util.Objects;

public class PageSix {

    static final Logger logger = LogManager.getLogger(TestPF.class);
    WebDriver driver;

    @FindBy(name = "OB01.COND.TECHNICAL-VALUE")
    List<WebElement> RadioButtonEligCriteria;
    @FindBy(name = "OB01.COND.PROOF-VALUE")
    List<WebElement> RadioButtonEvidence;
    @FindBy(name = "LANGUAGE.EC-DE")
    WebElement germanOffers;
    @FindBy(name = "LANGUAGE.EC-EN")
    WebElement offersLanguage;
    @FindBy(name = "LANGUAGE.PROC.EC-DE")
    WebElement germanProcedure;
    @FindBy(name = "LANGUAGE.PROC.EC-EN")
    WebElement procedureLanguage;


    @FindBy(xpath = "//*[@id=\"formShab\"]/div[1]/div[6]/input[2]")
    WebElement page7;
    @FindBy(className = "orange")
    WebElement page7Check;

    public PageSix(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void setRadioButtonEligCriteria(String strEligCriteria) {
        for (int i = 0; i < RadioButtonEligCriteria.size(); i++) {
            String val = RadioButtonEligCriteria.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strEligCriteria)) {
                RadioButtonEligCriteria.get(i).click();
                break;
            }
        }
    }

    public void setRadioButtonEvidence(String strEvidence) {
        for (int i = 0; i < RadioButtonEvidence.size(); i++) {
            String val = RadioButtonEvidence.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strEvidence)) {
                RadioButtonEvidence.get(i).click();
                break;
            }
        }
    }

    public void clickGermanOffers() {
        germanOffers.click();
    }
    public void clickOffersLanguage() {
        offersLanguage.click();
    }
    public void clickGermanProcedure() {
        germanProcedure.click();
    }
    public void clickProcedureLanguage() {
        procedureLanguage.click();
    }

    public void clickPage7() {
        page7.click();
    }
    public void checkPage7() {
        if (!Objects.equals(page7Check.getText(), "Schritt 7")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        } else logger.info("Sixth page done!");
    }

    public void fillInPageSix(String strEligCriteria, String strEvidence) {
        this.setRadioButtonEligCriteria(strEligCriteria);
        this.setRadioButtonEvidence(strEvidence);
        this.clickGermanOffers();
        this.clickOffersLanguage();
        this.clickGermanProcedure();
        this.clickProcedureLanguage();
        this.clickPage7();
        this.checkPage7();
    }

}
