package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherByDayPage {

    WebDriver webDriver;
    @FindBy(xpath = "//a[contains( text(),'Подробный прогноз на 10 дней')]")
    public WebElement buttonTenDaysWeather;

    public WeatherByDayPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void weatherByDay() {
        buttonTenDaysWeather.click();
    }
}
