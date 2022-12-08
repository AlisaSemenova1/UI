package org.example;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WeatherSteps {
    @Before
    public void pageOpen() {
        webDriver = new ChromeDriver();
    }
    WebDriver webDriver;
    @Дано("^захожу на страницу \"([^\"]*)\"$")
    public void openPage( String url) {
       OpenPage openPage;
       openPage = new OpenPage(webDriver, url);
       openPage.openPage();
    }
    @Когда("^выбираю город \"([^\"]*)\"$")
    public void chooseTown(String town) {
        TownPage townPage;
        townPage = new TownPage(webDriver);
        townPage.chooseTown(town);
    }

    @Тогда("^выбираю подробный прогноз на десять дней$")
    public void weatherViewing() {
        WeatherByDayPage weatherByDayPage;
        weatherByDayPage = new WeatherByDayPage(webDriver);
        weatherByDayPage.weatherByDay();
    }

    @Тогда("^выводится в консоль температура с сегодняшнего дня по заданный день$")
    public void weather() {
        WeatherToConsole weatherToConsole;
        weatherToConsole = new WeatherToConsole(webDriver);
        weatherToConsole.weatherToConsole();
        System.out.println();
    }
    @After
    public void pageClose() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}



