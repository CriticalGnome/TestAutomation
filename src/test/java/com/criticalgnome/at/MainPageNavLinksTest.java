package com.criticalgnome.at;

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
    private String url = "https://github.com/";

    @Before
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        site = new Site(new ChromeDriver());
        site.openPage(url);
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
        Assert.assertEquals("Features link send to invalid page", "https://github.com/features", site.getPageUrl());
    }

    @Title("Test 'Explore' link")
    @Description("Test link to page Explore")
    @Features("Main Page")
    @Stories("Links")
    @Test
    public void menuLinkExploreTest() throws Exception {
        site.mainPage().clickMenuLinkExplore();
        Assert.assertEquals("Explore link send to invalid page", "https://github.com/explore", site.getPageUrl());
    }

    @Title("Test 'Pricing' link")
    @Description("Test link to page Pricing")
    @Features("Main Page")
    @Stories("Links")
    @Test
    public void menuLinkPricingTest() throws Exception {
        site.mainPage().clickMenuLinkPricing();
        Assert.assertEquals("Pricing link send to invalid page", "https://github.com/pricing", site.getPageUrl());
    }
}
