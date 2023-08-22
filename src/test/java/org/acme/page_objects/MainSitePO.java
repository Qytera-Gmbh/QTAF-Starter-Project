package org.acme.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import jakarta.inject.Singleton;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

@Singleton
public class MainSitePO extends QtafTestNGContext {
    By headlineSelector = By.cssSelector("div.text-center h1");

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
        String headlineText = $(headlineSelector).text();
        assertEquals(headlineText, expectedText);
    }

    @Step(
            name = "Check calculation",
            description = "Check calculation"
    )
    public void checkCalculation(int a, int b, int c) {
        assertEquals(a * b, c);
    }

    @Step(name = "sayHello", description = "Say Hello")
    public void sayHello(String text) {
        System.out.println(text);
    }
}