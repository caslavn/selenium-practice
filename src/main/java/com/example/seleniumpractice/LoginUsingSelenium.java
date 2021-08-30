package com.example.seleniumpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class LoginUsingSelenium {

    @Test
    public void login() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromerdriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.schulung.simap.ch/shabforms/COMMON/login/login.jsf?view=3&GO=Projectmanager");
        WebElement username=driver.findElement(By.id("userlogin"));
        WebElement password=driver.findElement(By.id("userpwd"));
        WebElement login=driver.findElement(By.name("command"));
        username.sendKeys("olmero-test");
        password.sendKeys("jbZVF659aNYrkMp");
        login.click();
    }
}
