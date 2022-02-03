package cloud.autotests.ui.steps;

import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;

public class MedindexSteps {

    @DisplayName("Открываем главную страницу")
    public MedindexSteps openMainPage() {
        open("https://medindex.ru/");
        return this;
    }
}
