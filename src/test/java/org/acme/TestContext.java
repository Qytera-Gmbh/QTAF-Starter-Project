package org.acme;

import de.qytera.qtaf.testng.context.QtafTestNGContext;
import jakarta.inject.Inject;
import org.acme.page_objects.MainSitePO;
import org.acme.page_objects.PageHelper;


public class TestContext extends QtafTestNGContext {
    @Inject
    protected MainSitePO mainSitePO;

    @Inject
    protected PageHelper pageHelper;
}