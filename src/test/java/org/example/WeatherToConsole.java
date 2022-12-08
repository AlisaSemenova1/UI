package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WeatherToConsole {
    WebDriver webDriver;

    public WeatherToConsole(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void weatherToConsole() {
        var cards = webDriver.findElements(By.xpath(".//article[@class=\"card\"]"));
        for (var card : cards) {
            String day = card.findElement(By.xpath(".//strong")).getText();
            String dayMonth = card.findElement(By.xpath(".//small")).getText();
            var weather = card.findElements(By.xpath(".//tr[@class=\"weather-table__row\"]"));
            for (var weathers : weather) {
                String weatherTable = weathers.findElement(By.xpath(".//td")).getText();
                System.out.println(day + " " + dayMonth + " " + weatherTable);
            }

        }

    }
}

