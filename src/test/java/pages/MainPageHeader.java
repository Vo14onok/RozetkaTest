package pages;

import static com.codeborne.selenide.Selenide.$;

public class MainPageHeader implements Header {

    @Override
    public CitiesChoicePage openCitiesChoiceWindow() {
        $(".header-cities__link.link-dashed").click();
        return new CitiesChoicePage();
    }

    @Override
    public Header makeSearch(String searchParameter) {
        $("[name=search]").val(searchParameter).pressEnter();
        return new MainPageHeader();
    }

    @Override
    public Header changeLanguage(String language) {
        if (language.contains("Russian")) {
            $("li.header-topline__language-item:nth-child(1)");
        }
        if (language.contains("Ukranian")) {
            $("li.header-topline__language-item:nth-child(2)");
        }
        return new MainPageHeader();
    }

    @Override
    public ComparePage goToComparisionPage() {
        $("header-actions__button-icon").click();
        return new ComparePage();
    }

    @Override
    public Header clickOnCartIcon() {
        $("js-rz-cart").click();
        return new MainPageHeader();
    }

}
