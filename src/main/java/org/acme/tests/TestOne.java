package org.acme.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import org.acme.TestContext;
import org.testng.annotations.Test;

@TestFeature(
        name = "TestCase One",
        description = "First test"
)
public class TestOne extends TestContext {

    @Test(testName = "Test Success", description = "This test should pass")
    public void testSuccess() {
        mainSitePO.checkCalculation(2, 2, 4);
    }

    @Test(testName = "Test Failure", description = "This test should fail")
    public void testFailure() {
        mainSitePO.checkCalculation(2, 2, 3);
    }
}