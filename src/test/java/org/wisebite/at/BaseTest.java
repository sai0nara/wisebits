package org.wisebite.at;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import utils.ConfigUtils;

public class BaseTest {
    @Before
    public void configureWebBrowser() {

        Configuration.browserSize = "1920x1080";

//        Configuration.browser = System.getProperty(WEB_BROWSER);
//        Configuration.browserVersion = System.getProperty(WEB_BROWSER_VERSION);
        Configuration.baseUrl = ConfigUtils.baseUrl;
        Configuration.savePageSource = true;
        Configuration.screenshots = true;
//        SelenideLogger.addListener("AllureScreenshotListener", new AllureScreenshotListener()
//                .screenshots(true)
//                .savePageSource(false)
//                .screenshotSuccessSteps(true)
//        );
    }

}
