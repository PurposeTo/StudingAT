package com.company.StudingAT;

import com.company.StudingAT.Cases.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainE2ETest {
    private WebDriver driver;
    private WebDriverWait wait;

    private RunTestable currentTest;

    @BeforeClass
    public void openWebdriver() {
        String webdriverPath = "src\\main\\resources\\webdrivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", webdriverPath);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);

    }


    @Test
    public void RunAlertDemoTest() {
        currentTest = new AlertDemoTest(this.driver, this.wait);
        currentTest.RunTest();
    }


    @Test
    public void RunPopUpDemoTest() {
        currentTest = new PopupDemoTest(this.driver, this.wait);
        currentTest.RunTest();
    }


    @Test
    public void RunToolTipTest() {
        currentTest = new ToolTipTest(this.driver, this.wait);
        currentTest.RunTest();
    }

    @Test
    public void RunValidationDemoTest() {
        currentTest = new ValidationDemoTest(this.driver, this.wait);
        currentTest.RunTest();
    }

    @Test
    public void RunTitleInACrossBrowserTest() {
        currentTest = new TitleInACrossBrowserTest();
        currentTest.RunTest();
    }

    @Test
    public void RunAuthorizationOnTheSiteTest() {
        currentTest = new AuthorizationOnTheSiteTest(this.driver, this.wait);
        currentTest.RunTest();
    }

    @Test
    public void RunUploadFileTest() {
        currentTest = new UploadFileTest(this.driver, this.wait);
        currentTest.RunTest();
    }

    @Test
    public void RunDownloadCommandTest() {
        currentTest = new DownloadCommandTest(this.driver, this.wait);
        currentTest.RunTest();
    }


    @AfterClass
    public void closeWebdriver() {
        driver.quit();
    }
}
