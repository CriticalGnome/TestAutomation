package com.criticalgnome.automation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

/**
 * Project TestAutomation
 * Created on 14.03.2017.
 *
 * @author CriticalGnome
 */
@Title("Join Page test")
@Description("Stress test for join page")
public class JoinPageTest {
    private Site site;

    @Before
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        site = new Site(new ChromeDriver());
        site.openPage(Constants.SITE_URL);
        site.maximizeWindow();
    }

    @After
    public void tearDown() {
        site.closeWindow();
    }

    @Title("Test #1 for Login, Email & Password fields")
    @Description("Test join page for empty values")
    @Features("Join Page")
    @Stories("Fields")
    @Test
    public void joinPageFieldsEmptyTest() {
        site.mainPage().clickMenuLinkSignUp();
        site.JoinPage().clearLoginField();
        site.JoinPage().clearEmailField();
        site.JoinPage().clearPasswordField();
        site.JoinPage().clickSubmitButton();
        Assert.assertNotNull("Page not valid", site.JoinPage().returnProblemAlertWindow());
    }

    @Title("Test #2 for Login, Email & Password fields")
    @Description("Test join page for already taken values values")
    @Features("Join Page")
    @Stories("Fields")
    @Test
    public void joinPageFieldsTakenTest() {
        site.mainPage().clickMenuLinkSignUp();
        site.JoinPage().clearLoginField();
        site.JoinPage().clearEmailField();
        site.JoinPage().clearPasswordField();
        site.JoinPage().putTextIntoLoginField(Constants.MY_ACCOUNT);
        site.JoinPage().putTextIntoEmailField(Constants.MY_EMAIL);
        Assert.assertNotNull("Script not working properly", site.JoinPage().returnUsernameTakenAlertWindow());
        Assert.assertNotNull("Script not working properly", site.JoinPage().returnEmailTakenAlertWindow());
    }

    @Title("Test #3 for Login, Email & Password fields")
    @Description("Test join page for SQL Injection")
    @Features("Join Page")
    @Stories("Fields")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void joinPageFieldsSQLInjectionTest() {
        site.mainPage().clickMenuLinkSignUp();
        site.JoinPage().clearLoginField();
        site.JoinPage().clearEmailField();
        site.JoinPage().clearPasswordField();
        site.JoinPage().putTextIntoLoginField(Constants.QUOTATION);
        site.JoinPage().putTextIntoEmailField(Constants.SEMICOLON);
        site.JoinPage().putTextIntoPasswordField(Constants.DOUBLE_QUOTATION);
        site.JoinPage().clickSubmitButton();
        Assert.assertNotNull("Page not valid", site.JoinPage().returnProblemAlertWindow());
    }

}
