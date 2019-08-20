package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SecondHeader implements Header {

    @Override
    public CitiesChoicePage openCitiesChoiceWindow() {
        $("#city-chooser").click();
        return new CitiesChoicePage();
    }

    @Override
    public Header makeSearch(String searchParameter) {
        $("rz-header-search-input-text passive").val(searchParameter).pressEnter();
        return new SecondHeader();
    }

    @Override
    public Header changeLanguage(String language) {
        if (language.contains("Russian")) {
            $("li.header-topline__language-item:nth-child(1)");
        }
        if (language.contains("Ukranian")) {
            $("li.header-topline__language-item:nth-child(2)");
        }
        return new SecondHeader();
    }

    @Override
    public ComparePage goToComparisionPage() {
        $("#comparison-header").click();
        return new ComparePage();
    }

    @Override
    public Header clickOnCartIcon() {
        $("actions__item_type_cart").click();
        return new SecondHeader();
    }

}
