package com.company.StudingAT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ExampleE2ETest {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver ;


    @BeforeClass
    public void openWebdriver() {
        String webdriverPath = "src\\main\\resources\\webdrivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", webdriverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void openSite() {
        driver.get(baseUrl);
    }

    @Test
    public void verifyHomepageTitle() {
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyMainLabel() {
        String actualText = driver.findElement(By.cssSelector("#site-name > a")).getText();
        String expectedText = "Demo Site";
        Assert.assertEquals(actualText, expectedText);
    }

    @AfterClass
    public void closeSite() {
        driver.close();
    }

}
