package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TownPage {
    WebDriver webDriver;
    int TIMEOUT = 10;
    @FindBy(xpath = "//input[@placeholder=\"Город или район\"]")
    public WebElement inputTown;

    public TownPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void chooseTown(String town) {
        inputTown.sendKeys(town);
        inputTown.sendKeys(Keys.ENTER);
        var linkTown = webDriver.findElement(By.xpath("//a[contains( text(),'" + town + "')]"));
        var webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT), Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOf(linkTown));
        linkTown.click();
    }
}
