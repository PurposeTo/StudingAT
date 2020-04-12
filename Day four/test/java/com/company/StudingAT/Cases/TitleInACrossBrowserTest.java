package com.company.StudingAT.Cases;

import com.company.StudingAT.RunTestable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TitleInACrossBrowserTest implements RunTestable {

    private WebDriver driver;
    private String baseUrl = "http://demo.guru99.com/test/newtours/";

    public void RunTest() {

        String webdriverPathChrome = "src\\main\\resources\\webdrivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", webdriverPathChrome);
        driver = new ChromeDriver();

        checkTheTitleOnTheBrowser(driver);


        String webdriverPathFireFox = "src\\main\\resources\\webdrivers\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", webdriverPathFireFox);
        driver = new FirefoxDriver();

        checkTheTitleOnTheBrowser(driver);

//        safariDriver.get(baseUrl);
//        chromeDriver.get(baseUrl);
//
//        System.out.println("Safari title = " + safariDriver.getTitle());
//        System.out.println("Chrome title = " + chromeDriver.getTitle());
//        safariDriver.quit();
//        chromeDriver.quit();
    }

    private void checkTheTitleOnTheBrowser(WebDriver driver){
        driver.get(baseUrl);

        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        System.out.println(driver + " title = " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle);

        driver.quit();
    }


}
