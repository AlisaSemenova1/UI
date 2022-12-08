package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OpenPage {
    private final WebDriver webDriver;
    private final String url;

    public OpenPage(WebDriver webDriver, String url) {
        this.webDriver = webDriver;
        this.url = url;
        PageFactory.initElements(webDriver, this);
    }

    public void openPage() {
        webDriver.manage().window().maximize();
        webDriver.get(url);
    }

}
