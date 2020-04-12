package com.company.StudingAT.Cases;

import com.company.StudingAT.RunTestable;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AuthorizationOnTheSiteTest implements RunTestable {
    public AuthorizationOnTheSiteTest(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl = "http://demo.guru99.com/test/login.html";


    public void RunTest() {
        driver.get(baseUrl);

        //using submit method to submit the form. Submit used on password field
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
        driver.findElement(By.id("SubmitLogin")).submit();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("body > div:nth-child(2) > div > div > h3"))));
            System.out.println("Login Done with Submit");
        } catch (TimeoutException e) {
            Assert.fail();
        }
    }
}