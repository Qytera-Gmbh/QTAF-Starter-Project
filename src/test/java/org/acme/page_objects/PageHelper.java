package org.acme.page_objects;

import de.qytera.qtaf.core.guice.annotations.Step;
import jakarta.inject.Singleton;
import org.acme.TestContext;

@Singleton
public class PageHelper extends TestContext {
    @Step(name = "check_if_present", description = "Check if element is present")
    public void checkIfPresent(String selector) {
        System.out.println("Before static method");
        boolean b = selector.length() < 0;
        System.out.println("After static method");
    }

    @Step(name = "outer step", description = "Outer step method")
    public void outerStep() {
        System.out.println("Outer Step");
        innerStep();
        mainSitePO.checkCalculation(2, 2, 4);
    }

    @Step(name = "inner step", description = "Inner step method")
    public void innerStep() {
        System.out.println("Inner Step");
    }
}
