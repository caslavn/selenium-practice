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

public class PageFive {

    static final Logger logger = LogManager.getLogger(TestPF.class);
    WebDriver driver;

    @FindBy(name = "CONT.VARIANTS")
    List<WebElement> RadioButtonVariants;
    @FindBy(name = "CONT.PARTIALS")
    List<WebElement> RadioButtonPartials;
    @FindBy(name = "CONT.DEADLINE-RADIO")
    List<WebElement> RadioButtonDeadLine;
    @FindBy(id="cal-field-CONT.DATE.START")
    WebElement implementationDateStart;
    @FindBy(id="cal-field-CONT.DATE.END")
    WebElement implementationDateEnd;
    @FindBy(id="CONT.MONTHS")
    WebElement contMonths;

    @FindBy(xpath = "//*[@id=\"formShab\"]/div[1]/div[5]/input[2]")
    WebElement page6First;
    @FindBy(xpath = "//*[@id=\"formShab\"]/div[1]/div[4]/input[2]")
    WebElement page6Second;
    @FindBy(className = "orange")
    WebElement page6Check;

    public PageFive(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    public void setRadioButtonVariants(String strVariants) {
        for (int i = 0; i < RadioButtonVariants.size(); i++) {
            String val = RadioButtonVariants.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strVariants)) {
                RadioButtonVariants.get(i).click();
                break;
            }
        }
    }
    public void setRadioButtonPartials(String strPartials) {
        for (int i = 0; i < RadioButtonPartials.size(); i++) {
            String val = RadioButtonPartials.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strPartials)) {
                    RadioButtonPartials.get(i).click();
                    break;
            }
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
    public void setImplementationDateStart(String strImplementationDateStart) {
        implementationDateStart.sendKeys(strImplementationDateStart);
        if (strImplementationDateStart.equals("")) {
            logger.error("Start date of implementation can not be null!");
            throw new RuntimeException("Start date of implementation can not be null!");
        }
    }
    public void setImplementationDateEnd(String strImplementationDateEnd) {
        implementationDateEnd.sendKeys(strImplementationDateEnd);
        if (strImplementationDateEnd.equals("")) {
            logger.error("End date of implementation can not be null!");
            throw new RuntimeException("End date of implementation can not be null!");
        }
    }
    public void setContMonths(String strContMonths) {
        contMonths.sendKeys(strContMonths);
        if (strContMonths.equals("")) {
            logger.error("Required field not filled!");
            throw new RuntimeException("Required field not filled!");
        }
    }
    public void clickPage6One() {
        page6First.click();
    }
    public void clickPage6Two() {
        page6Second.click();
    }
    public void checkPage6() {
        if (!Objects.equals(page6Check.getText(), "Schritt 6")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        } else logger.info("Fifth page done!");
    }
    public void fillCase(String strDeadLine) {
        this.setRadioButtonDeadLine(strDeadLine);
    }

    public void fillInContDate (String strImplementationDateStart, String strImplementationDateEnd) {
        this.setImplementationDateStart(strImplementationDateStart);
        this.setImplementationDateEnd(strImplementationDateEnd);
    }
    public void fillInContMonths(String strContMonths) {
        this.setContMonths(strContMonths);
    }

    public void fillPageFive(String strVariants, String strPartials) {
        this.setRadioButtonVariants(strVariants);
        this.setRadioButtonPartials(strPartials);
    }
    public void openPage6First() {
        this.clickPage6One();
        this.checkPage6();
    }
    public void openPage6Second() {
        this.clickPage6Two();
        this.checkPage6();
    }
}
