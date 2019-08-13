package pages;


import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public CitiesChoicePage openCitiesChoiceWindow() {
        $(".header-cities__link.link-dashed").click();
        return new CitiesChoicePage();
    }

    public MainPage makeSearch(String searchParameter) {
        $("[name=search]").val(searchParameter).pressEnter();
        return new MainPage();
    }

    public ComparePage goToComparisionPage() {
        $("#comparison-header").click();
        return new ComparePage();
    }


}
