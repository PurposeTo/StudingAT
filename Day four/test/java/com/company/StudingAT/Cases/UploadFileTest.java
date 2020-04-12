package com.company.StudingAT.Cases;

import com.company.StudingAT.RunTestable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadFileTest implements RunTestable {
    public UploadFileTest(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl = "http://demo.guru99.com/test/upload/";

    public void RunTest() {
        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\Users\\firec\\Documents\\Downloads\\commandLine.zip");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();


        WebElement resultElement = driver.findElement(By.cssSelector("#res"));
        WebElement resultText = driver.findElement(By.cssSelector("#res > center"));
        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();

        wait.until(ExpectedConditions.attributeContains(resultElement, "style", "display: block"));

        boolean isContainsExisting = resultText.getText().contains(" successfully");
        Assert.assertTrue(isContainsExisting);

    }
}