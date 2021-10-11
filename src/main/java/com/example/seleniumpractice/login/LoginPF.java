package com.example.seleniumpractice.login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPF {

    WebDriver driver;

    @FindBy(id="userlogin")
    WebElement username;
    @FindBy(id="userpwd")
    WebElement password;
    @FindBy(name="command")
    WebElement login;

    public LoginPF(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void setUserName (String strUserName) {

            username.sendKeys(strUserName);
    }

        public void setPassword(String strPassword) {

            password.sendKeys(strPassword);

        }

        public void clickLogin(){

            login.click();

        }

    public void loginToSimap(String strUserName,String strPassword) {

        this.setUserName(strUserName);

        this.setPassword(strPassword);

        this.clickLogin();

    }

}
