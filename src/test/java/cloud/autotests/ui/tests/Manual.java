package cloud.autotests.ui.tests;


import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("all_tests"), @Tag("main_page")})
public class Manual {

    @Test
    @Manual("Ручные тесты")
    @AllureId("6890")
    @DisplayName("Страница переключается на английский язык")
    @Owner("lesnik0909")
    public void switchToEnglish() {
        step("Открыть страницу");
        step("Переключить страницу на английский");
        step("Проверить, что страница полностью переведена");
    }

    @Test
    @AllureId("6891")
    @DisplayName("Вакансии для соискателей размещены на главной странице")
    @Tag("main_page")
    @Manual("Ручные тесты")
    @Owner("lesnik0909")
    public void vacanciesOnMainPage() {
        step("На странице должна быть форма с вакансиями");
    }
}
