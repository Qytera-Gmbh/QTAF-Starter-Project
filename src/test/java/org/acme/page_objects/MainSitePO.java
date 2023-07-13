package org.acme.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import org.acme.TestContext;
import org.openqa.selenium.By;
import org.testng.Assert;
import jakarta.inject.Singleton;

@Singleton
public class MainSitePO extends TestContext {
    String headlineSelector = "div.text-center h1";

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
            description = "Check if the headline of the site contains a specific text"
    )
    public void checkHeadline(String expectedText) {
        // Extract headline text from website
        String headlineText = driver.findElement(By.cssSelector(headlineSelector)).getText();
        Assert.assertEquals(headlineText, expectedText);
    }

    @Step(
            name = "Check calculation",
            description = "Check calculation"
    )
    public void checkCalculation(int a, int b, int c) {
        Assert.assertEquals(a*b, c);
    }

    @Step(name = "sayHello", description = "Say Hello")
    public void sayHello(String text) {
        System.out.println(text);
    }
}