package com.criticalgnome.automation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Project AT
 * Created on 14.03.2017.
 *
 * @author CriticalGnome
 */
@Title("Main page navigation test")
@Description("Test top navigation bar links")
public class MainPageNavLinksTest {
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

    @Title("Test 'Features' link")
    @Description("Test link to page Features")
    @Features("Main Page")
    @Stories("Links")
    @Test
    public void menuLinkFeaturesTest() throws Exception {
        site.mainPage().clickMenuLinkFeatures();
        Assert.assertEquals("Features link send to invalid page", Constants.FEATURES_PAGE_LINK, site.getPageUrl());
    }

    @Title("Test 'Explore' link")
    @Description("Test link to page Explore")
    @Features("Main Page")
    @Stories("Links")
    @Test
    public void menuLinkExploreTest() throws Exception {
        site.mainPage().clickMenuLinkExplore();
        Assert.assertEquals("Explore link send to invalid page", Constants.EXPLORE_PAGE_LINK, site.getPageUrl());
    }

    @Title("Test 'Pricing' link")
    @Description("Test link to page Pricing")
    @Features("Main Page")
    @Stories("Links")
    @Test
    public void menuLinkPricingTest() throws Exception {
        site.mainPage().clickMenuLinkPricing();
        Assert.assertEquals("Pricing link send to invalid page", Constants.PRICING_PAGE_LINK, site.getPageUrl());
    }
}
