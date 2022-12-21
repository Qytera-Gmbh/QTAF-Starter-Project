package org.acme.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import de.qytera.qtaf.testng.context.QtafTestNGContext;
import org.testng.Assert;
import org.testng.annotations.Test;

@TestFeature(
        name = "TestCase One",
        description = "First test"
)
public class TestOne extends QtafTestNGContext {

    @Test(testName = "Test Success", description = "This test should pass")
    public void testSuccess() {
        Assert.assertEquals(2 * 2, 4);
    }

    @Test(testName = "Test Failure", description = "This test should fail")
    public void testFailure() {
        Assert.assertEquals(2 * 2, 3);
    }
}