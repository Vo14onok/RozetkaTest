package pages;

import static com.codeborne.selenide.Selenide.$;

public class MainPageHeader implements Header {

    @Override
    public CitiesChoicePage openCitiesChoiceWindow() {
        $(".header-cities__link.link-dashed").click();
        return new CitiesChoicePage();
    }

    @Override
    public MainPageHeader makeSearch(String searchParameter) {
        $("[name=search]").val(searchParameter).pressEnter();
        return new MainPageHeader();
    }

    @Override
    public ComparePage goToComparisionPage() {
        $("header-actions__button-icon").click();
        return new ComparePage();
    }

}
