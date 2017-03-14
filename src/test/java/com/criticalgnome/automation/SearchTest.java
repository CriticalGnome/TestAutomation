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
@Title("Search engine test")
@Description("Testing site search engine")
public class SearchTest {
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

    @Title("Test two different search fields")
    @Description("Test search field on main page, than test search field on search page")
    @Test
    @Features({"Main Page","Search Page"})
    @Stories("Search")
    @Severity(SeverityLevel.CRITICAL)
    public void searchOnTwoPagesTest() throws Exception {
        site.mainPage().clearSearchField();
        site.mainPage().putTextToSearchField(Constants.MY_ACCOUNT);
        site.mainPage().sendEnterToSearchField();
        site.searchPage().clearSearchField();
        site.searchPage().putTextToSearchField(Constants.MY_ACCOUNT);
        site.searchPage().clickSearchButton();
        site.searchPage().openMyRepository();
        site.makeScreenShot();
        Assert.assertEquals("Page for CriticalGnome Repository is invalid",
                Constants.MY_GITHUB_SITE_PAGE_LINK,
                site.getPageUrl());
    }
}
