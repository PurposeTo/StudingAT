package com.company.StudingAT.Cases;

import com.company.StudingAT.RunTestable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class PopupDemoTest implements RunTestable {

    public PopupDemoTest(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl = "http://demo.guru99.com/popup.php";


    public void RunTest() {
        openSite();
        clickOnButtonWhichOpenedNewWindow();
        switchToNewChildWindowAndOutUserPasswordAndId();
    }

    private void openSite() {
        driver.get(baseUrl);
        //driver.manage().window().maximize();
    }

    private void clickOnButtonWhichOpenedNewWindow() {
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
    }

    private void switchToNewChildWindowAndOutUserPasswordAndId() {
        String mainWindow = driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> allWindows = driver.getWindowHandles();

        for (String childWindow : allWindows) {

            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                // Switching to Child window
                driver.switchTo().window(childWindow);

                getAccessToDetailsAboutTheUser();
                waitTableDetails();

                checkUserId();
                checkUserPassword();

                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(mainWindow);
    }

    private void getAccessToDetailsAboutTheUser() {
        driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
        driver.findElement(By.name("btnLogin")).click();
    }

    private void waitTableDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr[1]/td/h2")));
    }


    private void checkUserId() {
        WebElement userIdElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]"));
        String userIdText = userIdElement.getText();
        System.out.println("User id - " + userIdText);

        Assert.assertNotEquals("", userIdText);
    }

    private void checkUserPassword() {
        WebElement passwordElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]"));
        String userPasswordText = passwordElement.getText();
        System.out.println("User password - " + userPasswordText);

        Assert.assertNotEquals("", userPasswordText);
    }
}