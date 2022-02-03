package cloud.autotests.ui.tests;

import cloud.autotests.ui.config.Project;
import cloud.autotests.ui.helpers.AllureAttachments;
import cloud.autotests.ui.helpers.DriverSettings;
import cloud.autotests.ui.helpers.DriverUtils;
import cloud.autotests.ui.steps.MedindexSteps;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    MedindexSteps medindexSteps = new MedindexSteps();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
