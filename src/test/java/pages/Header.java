package pages;

public interface Header {

    CitiesChoicePage openCitiesChoiceWindow();
    Header makeSearch(String searchParameter);
    Header changeLanguage(String language);
    Header clickOnCartIcon();
    ComparePage goToComparisionPage();



}
