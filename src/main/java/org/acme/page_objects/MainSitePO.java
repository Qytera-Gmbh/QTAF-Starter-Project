package org.acme.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.qtaf.testng.context.QtafTestNGContext;

import org.openqa.selenium.By;
import org.testng.Assert;
import javax.inject.Singleton;


@Singleton
public class MainSitePO extends QtafTestNGContext {
    String headlineSelector = "div.td-content h1";

    @Step(
            name = "Open Site",
            description = "Open the selenium documentation website in the browser"
    )
    public void openSite(String url) {
        // Visit Selenium documentation
        driver.get(url);
    }

    @Step(
            name = "Check Headline",
            description = "Check if the headline of the site cintains a specific text"
    )
    public void checkHeadline(String expectedText) {
        // Extract headline text from website
        String headlineText = driver.findElement(By.cssSelector(headlineSelector)).getText();
        Assert.assertEquals(headlineText, "The Selenium Browser Automation Project");
    }
}