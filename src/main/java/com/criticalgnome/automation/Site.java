package com.criticalgnome.automation;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Project AT
 * Created on 13.03.2017.
 *
 * @author CriticalGnome
 */
public class Site {

    private WebDriver driver;

    public Site(WebDriver driver) { this.driver = driver; }

    public MainPage mainPage() { return new MainPage(driver); }
    public SearchPage searchPage() { return new SearchPage(driver); }
    public LoginPage loginPage() { return new LoginPage(driver); }
    public JoinPage JoinPage() { return new JoinPage(driver); }

    @Step("Open URl {0}")
    public void openPage(String url) {
        driver.get(url);
    }

    @Step("Maximize current window")
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @Step("Close current window")
    public void closeWindow() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Get URL of current window")
    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    @Attachment("Screenshot")
    @Step("Make screen shot of current page")
    public byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
