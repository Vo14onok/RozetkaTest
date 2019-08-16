package pages;

import static com.codeborne.selenide.Selenide.$;

public class SecondHeader implements Header {

    @Override
    public CitiesChoicePage openCitiesChoiceWindow() {
        $("#city-chooser").click();
        return new CitiesChoicePage();
    }

    @Override
    public MainPageHeader makeSearch(String searchParameter) {
        $("rz-header-search-input-text passive").val(searchParameter).pressEnter();
        return new MainPageHeader();
    }

    @Override
    public ComparePage goToComparisionPage() {
        $("#comparison-header").click();
        return new ComparePage();
    }

}
