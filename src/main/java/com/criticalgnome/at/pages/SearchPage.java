package com.criticalgnome.at.pages;

import com.google.common.base.Predicate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Project AT
 * Created on 14.03.2017.
 *
 * @author CriticalGnome
 */
public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (name = "q")
    WebElement searchTextField;

    @FindBy (css = "button[type='submit']")
    WebElement searchButton;

    @FindBy (css = "a[href='/CriticalGnome/criticalgnome.github.io']")
    WebElement findedRepository;

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

    @Step("Click 'Search' button")
    public void clickSearchButton() {
        searchButton.click();
    }

    @Step("Open repository 'CriticalGnome'")
    public void openMyRepository() {
        findedRepository.click();
    }

}
