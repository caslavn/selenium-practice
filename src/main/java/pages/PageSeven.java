package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.TestPF;

import java.util.Objects;

public class PageSeven {

    static final Logger logger = LogManager.getLogger(TestPF.class);
    WebDriver driver;

    @FindBy(id = "OB01.COND.DOC.SIMAP-VALUE")
    WebElement tenderingDocumentationSource;

    @FindBy(xpath = "//*[@id=\"formShab\"]/div[1]/div[6]/input[2]")
    WebElement page8;
    @FindBy(className = "orange")
    WebElement page8Check;

    public PageSeven(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickPage8() {page8.click();}
    public void checkPage8() {
        if (!Objects.equals(page8Check.getText(), "Schritt 8")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        } else logger.info("Seventh page done!");
    }

    public void fillInPageSeven() {
        tenderingDocumentationSource.click();
        this.clickPage8();
        this.checkPage8();
    }
}
