package com.criticalgnome.automation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Project AT
 * Created on 13.03.2017.
 *
 * @author CriticalGnome
 */
public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText ="Features")
    WebElement menuLinkFeatures;

    @FindBy (linkText = "Explore")
    WebElement menuLinkExplore;

    @FindBy (linkText = "Pricing")
    WebElement menuLinkPricing;

    @FindBy (name = "q")
    WebElement searchTextField;

    @FindBy (css = "a[href='/login']")
    WebElement menuLinkSignIn;

    @FindBy (css = "a[href='/join?source=header-home']")
    WebElement menuLinkSignUp;

    @FindBy (id = "user[login]")
    WebElement nameTextField;

    @FindBy (id = "user[email]")
    WebElement emailTextFeild;

    @FindBy (id = "user[password]")
    WebElement passwordTextField;

    @FindBy (css = "button[Sign up for GitHub]")
    WebElement buttonSignUp;

    @Step("Click 'Features' link on top navigaton panel")
    public void clickMenuLinkFeatures() {
        menuLinkFeatures.click();
    }

    @Step("Click 'Explore' link on top navigaton panel")
    public void clickMenuLinkExplore() {
        menuLinkExplore.click();
    }

    @Step("Click 'Pricing' link on top navigaton panel")
    public void clickMenuLinkPricing() {
        menuLinkPricing.click();
    }

    @Step("Enter text {0} into search field ")
    public void putTextToSearchField(String text) {
        searchTextField.sendKeys(text);
    }

    @Step("Send ENTER key to search field")
    public void sendEnterToSearchField() {
        searchTextField.sendKeys(Keys.ENTER);
    }

    @Step("Clear search filed")
    public void clearSearchField() {
        searchTextField.clear();
    }

    @Step("Click 'Sign in' link")
    public void clickMenuLinkSignIn() {
        menuLinkSignIn.click();
    }

    @Step("Click 'Sign up' link")
    public void clickMenuLinkSignUp() {
        menuLinkSignUp.click();
    }

}
