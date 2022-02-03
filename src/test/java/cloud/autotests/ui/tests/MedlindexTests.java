package cloud.autotests.ui.tests;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import annotations.Microservice;
import cloud.autotests.ui.helpers.DriverUtils;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Layer("web")
@Owner("zatulivetrova")
@Story("Medindex")
@Feature("Главная страница")
@Tags({@Tag("all_tests"), @Tag("main_page")})

public class MedlindexTests extends TestBase {
    @Microservice("Main page")
    @Test
    @AllureId("7005")
    @DisplayName("Главная страница содержит форму для соискателей")
    @Feature("Форма для соискателей")
    @Description("Тесты для Medindex")
    @JiraIssues({@JiraIssue("HOMEWORK-278")})
    void formforapplicantsTest() {
        step("Открываем главную страницу сайта", () ->
                open(baseUrl));

        step("Проверяем, что на главной странице есть форма для соискателей", () ->
                $(By.className("container")).shouldBe(visible));
    }

    @Microservice("Англоязычная версия сайта")
    @Test
    @AllureId("7017")
    @DisplayName("Проверяем, что страница переключается на английский язык")
    @Feature("Переключение на английский")
    @Description("Тесты для Medindex")
    @JiraIssues({@JiraIssue("HOMEWORK-278")})
    void pageisswitchesTest() {
        step("Открываем главную страницу сайта", () ->
                open(baseUrl));

        step("Переключаем страницу на английский язык", () ->
                $(By.linkText("Eng")).click());

        step("Название страницы должно содержать 'Medindex: Healthcare IT solutions'", () -> {
            String expectedTitle = "Medindex: Healthcare IT solutions";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Microservice("Главная страница")
    @Test
    @AllureId("7018")
    @DisplayName("На главной странице должна быть форма с вакансиями")
    @Feature("Форма с вакансиями")
    @Description("Тесты для Medindex")
    @JiraIssues({@JiraIssue("HOMEWORK-278")})
    void vacanciesforapplicantsTest() {
        step("Открываем главную страницу сайта", () ->
                open(baseUrl));

        step("Проверяем, что на ней есть форма с вакансиями", () ->
                $(By.className("vacancy-accordion")).shouldBe(visible));
    }

    @Microservice("Заголовок")
    @Test
    @AllureId("7019")
    @DisplayName("Проверка корректности заголовка главной страницы")
    @Feature("Заголовок")
    @Description("Тесты для Medindex")
    @JiraIssues({@JiraIssue("HOMEWORK-278")})
    void titleTest() {
        step("Открываем главную страницу сайта", () ->
                open(baseUrl));

        step("Заголовок страницы должен содержать текст 'Мединдекс: ИТ решения для медицины'", () -> {
            String expectedTitle = "Мединдекс: ИТ решения для медицины";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Microservice("Ошибки в логах")
    @Test
    @AllureId("7020")
    @DisplayName("Console log не должен содержать ошибок")
    @Feature("Console log")
    @Description("Тесты для Medindex")
    @JiraIssues({@JiraIssue("HOMEWORK-278")})
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем главную страницу сайта", () ->
                open(baseUrl));

        step("Console logs не должен содержать текст 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
