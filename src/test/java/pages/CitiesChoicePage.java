package pages;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * @author sbrit
 */
public class CitiesChoicePage {
    public MainPageHeader chooseRandomCity() {
        int element = new Random().nextInt(($$("a.header-location__popular-link").size()) - 1);
        $$("a.header-location__popular-link").get(element).click();
        return new MainPageHeader();
    }

    public MainPageHeader searchByTypingInSearchField(String city) {
        $("ng-pristine ng-valid ng-touched").setValue(city).pressEnter();
        return new MainPageHeader();
    }

}
