package Pages;


import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public void CitiesMenu () {
        $(".header-cities__link.link-dashed").click();
    }

    public void SearchField (String arg1) {
        $("[name=search]").val(arg1).pressEnter();
    }

    public void CompareItemsIcon () {
        $("#comparison-header").click();
    }

    public void RandomCity () {
        int element = new Random().nextInt(($$("a.header-location__popular-link").size()) - 1);
        $$("a.header-location__popular-link").get(element).click();
    }


}
