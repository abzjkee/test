import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWindow;

public class Rabotaem {

    @Test
    public void fillFormTest() {
        open("https://coinmarketcap.com/ru/");
        $("#__next > div.sc-7c7f3865-1.hhqoRw.global-layout-v2 > div.main-content > div.sc-7c7f3865-0.jZHXCc > div.HeaderV3_global-header__Rdkas > div.HeaderV3_main-header__xTs_o > div.HeaderV3_main-header-right__8ENee > div.UserDropdown_user-section-wrapper__oKrXr > div > div > div > div").click();
        sleep(4000);
        closeWindow();
    }
}