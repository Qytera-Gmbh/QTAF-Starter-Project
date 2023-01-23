package org.acme;

import de.qytera.qtaf.testng.context.QtafTestNGContext;
import org.acme.page_objects.*;

import javax.inject.Inject;


public class TestContext extends QtafTestNGContext {

    @Inject
    protected MainSitePO mainSitePO;
}