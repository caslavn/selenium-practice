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

public class PageThree {

    static final Logger logger = LogManager.getLogger(TestPF.class);
    WebDriver driver;

    @FindBy(id="CONT.NAME")
    WebElement projectTitle;
    @FindBy(name = "CONT.WORK.TYPE-TYPE")
    List<WebElement> RadioButtonConstruction;
    @FindBy(name = "CONT.SUPP.TYPE-TYPE")
    List<WebElement> RadioButtonSupply;
    @FindBy(name = "DIVISION.INTO.LOT")
    List<WebElement> RadioButtonDivision;

    @FindBy(xpath = "//*[@id=\"formShab\"]/div[1]/div[4]/input[2]")
    WebElement page4;
    @FindBy(className = "orange")
    WebElement page4Check;


    public PageThree(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    public void setProjectTitle (String strProjectTitle) {

        projectTitle.sendKeys(strProjectTitle);
        if(strProjectTitle.equals("")) {
            logger.error("Project title can not be null!");
            throw new RuntimeException("Project title can not be null!");
        }
    }
    public void setRadioButtonConstruction(String strConstruction) {
        for(int i=0; i < RadioButtonConstruction.size(); i++)
        {
            String val = RadioButtonConstruction.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strConstruction))
            {
                RadioButtonConstruction.get(i).click();
                break;
            }
        }
    }
    public void setRadioButtonSupply(String strSupply) {
        for(int i=0; i < RadioButtonSupply.size(); i++)
        {
            String val = RadioButtonSupply.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strSupply))
            {
                RadioButtonSupply.get(i).click();
                break;
            }
        }
    }
    public void setRadioButtonDivision(String strDivision) {
        for(int i=0; i < RadioButtonDivision.size(); i++)
        {
            String val = RadioButtonDivision.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(strDivision))
            {
                RadioButtonDivision.get(i).click();
                break;
            }
        }
    }
    public void clickPage4() {
        page4.click();
    }
    public void checkPage4() {
        if (!Objects.equals(page4Check.getText(), "Schritt 4")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        } else logger.info("Third page done!");
    }
    public void fillInPageThree (String strProjectTitle, String strDivision)
    {
        this.setProjectTitle(strProjectTitle);
        this.setRadioButtonDivision(strDivision);
        this.clickPage4();
        this.checkPage4();
    }

    public void fillConstruction (String strConstruction) {
        this.setRadioButtonConstruction(strConstruction);
    }
    public void fillSupply (String strSupply) {
        this.setRadioButtonSupply(strSupply);
    }

}
