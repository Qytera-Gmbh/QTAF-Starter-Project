package org.acme.tests;


import de.qytera.qtaf.core.config.annotations.TestFeature;
import org.acme.TestContext;
import org.acme.page_objects.PageHelper;
import org.testng.annotations.*;

@TestFeature(
        name = "SeleniumTest",
        description = "Our first Selenium test"
)
public class SeleniumTest extends TestContext {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Hello, @BeforeSuite SeleniumTest");
        mainSitePO.checkCalculation(10, 4, 40);
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Hello, @BeforeTest SeleniumTest");
        mainSitePO.checkCalculation(-3, 3, -9);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Hello, @BeforeMethod SeleniumTest");
        mainSitePO.checkCalculation(-2, -10, 20);
    }

    @Test(
            testName = "Open browser and visit selenium documentation",
            description = "Open the browser and go to the selenium documentation website"
    )
    public void testBrowser() {
        mainSitePO.openSite("https://selenium.dev");
        mainSitePO.checkHeadline("Selenium automates browsers. That's it!");
        pageHelper.checkIfPresent("div");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Hello, @AfterMethod SeleniumTest");
        mainSitePO.checkCalculation(-2, -20, 40);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Hello, @AfterTest SeleniumTest");
        mainSitePO.checkCalculation(5, 4, 20);
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Hello, @AfterSuite SeleniumTest");
        mainSitePO.checkCalculation(10, 3, 30);
    }
}