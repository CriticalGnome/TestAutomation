package com.criticalgnome.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Project AT
 * Created on 14.03.2017.
 *
 * @author CriticalGnome
 */
public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login_field")
    WebElement loginField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "input[name='commit']")
    WebElement submitButton;

    @FindBy(css = "div[Incorrect username or password]")
    WebElement alertWindowWithIncorrectUserPasswordtext;

    @Step("Enter text {0} to login field")
    public void putTextInLoginField(String text) {
        loginField.sendKeys(text);
    }

    @Step("Clear login field")
    public void clearLoginField() {
        loginField.clear();
    }

    @Step("Enter text {0} to password field")
    public void putTextInPasswordField(String text) {
        passwordField.sendKeys(text);
    }

    @Step("Clear password field")
    public void clearPasswordField() {
        passwordField.clear();
    }

    @Step("Click Submit button")
    public void clickSubmitButton() {
        submitButton.click();
    }

    @Step("Return Alert Window if present")
    public WebElement returnAlertWindow() {
        return alertWindowWithIncorrectUserPasswordtext;
    }
}
