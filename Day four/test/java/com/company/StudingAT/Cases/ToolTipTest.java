package com.company.StudingAT.Cases;

import com.company.StudingAT.RunTestable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ToolTipTest implements RunTestable {

    public ToolTipTest(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl = "http://demo.guru99.com/test/social-icon.html";

    public void RunTest() {
        openSite();

        String expectedTooltip = "Github";
        String actualTooltip = getActualTitleOfToolTip();
        Assert.assertEquals(actualTooltip, expectedTooltip);
    }

    private void openSite() {
        driver.get(baseUrl);
    }

    private String getActualTitleOfToolTip() {
        WebElement githubElement = findTheGithubIcon();
        String theTitle = getTheTitle(githubElement);
        return theTitle;
    }

    private WebElement findTheGithubIcon() {
        String githubIconXPath = ".//*[@class='soc-ico show-round']/a[4]";

        // Find the Github icon at the top right of the header
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(githubIconXPath)));
        WebElement githubElement = driver.findElement(By.xpath(githubIconXPath));
        return githubElement;
    }

    private String getTheTitle(WebElement element) {
        //get the value of the "title" attribute of the github icon
        String actualTooltip = element.getAttribute("title");

        return actualTooltip;
    }
}