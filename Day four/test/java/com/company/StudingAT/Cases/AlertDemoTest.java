package com.company.StudingAT.Cases;

import com.company.StudingAT.RunTestable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class AlertDemoTest implements RunTestable {
    public AlertDemoTest(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
    }

    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl = "http://demo.guru99.com/test/delete_customer.php";



    public void RunTest(){
        openSite();
        chooseTheCustomer();

        String expectedMessage = "Do you really want to delete this Customer?";
        String actualAlertMessage = getVerifyAlertMessage();
        Assert.assertEquals(actualAlertMessage, expectedMessage);

        String expectedMessage2 = "Customer Successfully Delete!";
        String actualAlertMessage2 = getVerifyAlertMessage2();
        Assert.assertEquals(actualAlertMessage2, expectedMessage2);
    }


    private void openSite() {
        driver.get(baseUrl);
    }


    private void chooseTheCustomer() {
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();
    }


    private String getVerifyAlertMessage() {
        wait.until(ExpectedConditions.alertIsPresent());
        // Switching to Alert
        Alert alert = driver.switchTo().alert();


        String actualAlertMessage = alert.getText();
        System.out.println(actualAlertMessage);
        alert.accept();

        return actualAlertMessage;
    }


    private String getVerifyAlertMessage2() {
        wait.until(ExpectedConditions.alertIsPresent());
        // Switching to Alert
        Alert alert2 = driver.switchTo().alert();

        // Capturing alert message.
        String actualAlertMessage2 = alert2.getText();
        System.out.println(actualAlertMessage2);
        alert2.accept();
        return actualAlertMessage2;
    }
}