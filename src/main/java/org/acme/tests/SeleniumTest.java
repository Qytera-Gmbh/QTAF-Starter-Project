package org.acme.tests;


import de.qytera.qtaf.core.config.annotations.TestFeature;
import org.acme.TestContext;
import org.testng.annotations.Test;

@TestFeature(
        name = "SeleniumTest",
        description = "Our first Selenium test"
)
public class SeleniumTest extends TestContext {

    @Test(
            testName = "Open browser and visit selenium documentation",
            description = "Open the browser and go to the selenium documentation website"
    )
    public void testBrowser() {
        mainSitePO.openSite("https://selenium.dev");
        mainSitePO.checkHeadline("Selenium automates browsers. That's it!");
    }
}