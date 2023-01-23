package org.acme.tests;


import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@TestFeature(
        name = "SeleniumTest",
        description = "Our first Selenium test"
)
public class SeleniumTest extends QtafTestNGContext {
    String headlineSelector = "h1.display-1";

    @Test(
            testName = "Open browser and visit selenium documentation",
            description = "Open the browser and go to the selenium documentation website"
    )
    public void testBrowser() {
        openSite("https://selenium.dev");
        checkHeadline("Selenium automates browsers. That's it!");
    }

    public void openSite(String url) {
        // Visit Selenium documentation
        driver.get(url);
    }

    public void checkHeadline(String expectedText) {
        // Extract headline text from website
        String headlineText = driver.findElement(By.cssSelector(headlineSelector)).getText();
        Assert.assertEquals(headlineText, expectedText);
    }
}