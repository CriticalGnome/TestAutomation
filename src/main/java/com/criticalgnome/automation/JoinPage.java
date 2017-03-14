package com.criticalgnome.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Project TestAutomation
 * Created on 14.03.2017.
 *
 * @author CriticalGnome
 */
public class JoinPage {

    private WebDriver driver;

    public JoinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "user_login")
    WebElement loginField;

    @FindBy (id = "user_email")
    WebElement emailField;

    @FindBy (id = "user_password")
    WebElement passwordField;

    @FindBy (id = "signup_button")
    WebElement submitButton;

    @FindBy (css = "div[There were problems creating your account]")
    WebElement problemAlertWindow;

    @FindBy (css = "dd[Username is already taken]")
    WebElement usernameTakenAlertWindow;

    @FindBy (css = "dd[Email is invalid or already taken]")
    WebElement emailTakenAlertWindow;

    @Step("Clear login field")
    public void clearLoginField() {
        loginField.clear();
    }

    @Step("Put {0} into login field")
    public void putTextIntoLoginField(String text) {
        loginField.sendKeys(text);
    }

    @Step("Clear email field")
    public void clearEmailField() {
        emailField.clear();
    }

    @Step("Put {0} into email field")
    public void putTextIntoEmailField(String text) {
        emailField.sendKeys(text);
    }

    @Step("Clear password field")
    public void clearPasswordField() {
        passwordField.clear();
    }

    @Step("Put {0} into password field")
    public void putTextIntoPasswordField(String text) {
        passwordField.sendKeys(text);
    }

    @Step("Click Submit button")
    public void clickSubmitButton() {
        submitButton.click();
    }

    @Step("Return Problem Alert Window if present")
    public WebElement returnProblemAlertWindow() {
        return problemAlertWindow;
    }

    @Step("Return Username taken Alert Window if present")
    public WebElement returnUsernameTakenAlertWindow() {
        return usernameTakenAlertWindow;
    }

    @Step("Return Email taken Alert Window if present")
    public WebElement returnEmailTakenAlertWindow() {
        return emailTakenAlertWindow;
    }
}
