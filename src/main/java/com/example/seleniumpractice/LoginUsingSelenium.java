package com.example.seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginUsingSelenium {


    @Test
    public void login() {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.schulung.simap.ch/");

        WebElement username=driver.findElement(By.id("userlogin"));
        WebElement password=driver.findElement(By.id("userpwd"));
        WebElement login=driver.findElement(By.xpath("//*[@id=\"login\"]/input[3]"));

        username.sendKeys("olmero-test");
        password.sendKeys("jbZVF659aNYrkMp");
        login.click();

        //String actualUrl="";
        //String expectedUrl= driver.getCurrentUrl();

        //Assert.assertEquals(expectedUrl,actualUrl);


    }
}
