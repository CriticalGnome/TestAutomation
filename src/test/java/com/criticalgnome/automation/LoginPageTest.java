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
 * Project AT
 * Created on 14.03.2017.
 *
 * @author CriticalGnome
 */
@Title("Login Page test")
@Description("Stress test for login page")
public class LoginPageTest {
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

    @Title("Test #1 for Login & Password fields")
    @Description("Test login page for empty values")
    @Features("Login Page")
    @Stories("Fields")
    @Test
    public void loginPageFieldsEmptyTest() {
        site.mainPage().clickMenuLinkSignIn();
        site.loginPage().clearLoginField();
        site.loginPage().clearPasswordField();
        site.loginPage().clickSubmitButton();
        Assert.assertNotNull("Page not valid", site.loginPage().returnAlertWindow());
    }

    @Title("Test #2 for Login & Password fields")
    @Description("Test login page for abracadabra values")
    @Features("Login Page")
    @Stories("Fields")
    @Test
    public void loginPageFieldsAbracadabraTest() {
        site.mainPage().clickMenuLinkSignIn();
        site.loginPage().clearLoginField();
        site.loginPage().clearPasswordField();
        site.loginPage().putTextInLoginField(Constants.ABRACADABRA1);
        site.loginPage().putTextInPasswordField(Constants.ABRACADABRA2);
        site.loginPage().clickSubmitButton();
        Assert.assertNotNull("Page not valid", site.loginPage().returnAlertWindow());
    }

    @Title("Test #3 for Login & Password fields")
    @Description("Test login page for SQL Injection")
    @Features("Login Page")
    @Stories("Fields")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginPageFieldsSQLInjectionTest() {
        site.mainPage().clickMenuLinkSignIn();
        site.loginPage().clearLoginField();
        site.loginPage().clearPasswordField();
        site.loginPage().putTextInLoginField(Constants.QUOTATION);
        site.loginPage().putTextInPasswordField(Constants.DOUBLE_QUOTATION);
        site.loginPage().clickSubmitButton();
        Assert.assertNotNull("Page not valid", site.loginPage().returnAlertWindow());
    }

}
