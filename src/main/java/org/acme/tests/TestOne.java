package org.acme.tests;

import de.qytera.qtaf.core.config.annotations.TestFeature;
import org.acme.TestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@TestFeature(
        name = "TestCase One",
        description = "First test"
)
public class TestOne extends TestContext {

    static class DebugClassTwo implements IData {
        @Override
        public void doSomething() {
            System.out.println("Hello from DebugClassTwo");
        }
    }

    @DataProvider(name = "myDataProvider", parallel = true)
    public String[][] getData() {
        return new String[][] {
                { "Hello" },
                { "World" },
                { "This" },
                { "is" },
                { "a" },
                { "message" },
                { "from" },
                { "TestNG" },
        };
    }

    @DataProvider(name = "dataProvider2")
    public Object[][] getDataTwo() {
        return new IData[][] {
                { new DebugClassTwo() },
                { new DebugClass() }
        };
    }

    @Test(testName = "Test Success", description = "This test should pass")
    public void testSuccess() {
        mainSitePO.checkCalculation(2, 2, 4);
    }

    @Test(testName = "Test Failure", description = "This test should fail")
    public void testFailure() {
        mainSitePO.checkCalculation(2, 2, 3);
    }

    @Test(testName = "Test DataProvider", description = "Test the data provider", dataProvider = "myDataProvider")
    public void testDataProvider(String[] s) {
        System.out.println("Provided String: " + s[0]);
        Thread thread = Thread.currentThread();
        System.out.println("THREAD: " + thread.getName());
        assert s[0].length() > 0;
    }

    @Test(testName = "Test DataProvider 2", description = "Test the data provider 2", dataProvider = "dataProvider2")
    public void testDataProviderTwo(IData d) {
        d.doSomething();
        Thread thread = Thread.currentThread();
        System.out.println("THREAD: " + thread.getName());
    }
}

interface IData {
    void doSomething();
}

class DebugClass implements IData {
    @Override
    public void doSomething() {
        System.out.println("Hello from DebugClass");
    }
}