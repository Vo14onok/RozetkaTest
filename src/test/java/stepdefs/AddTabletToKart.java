package stepdefs;

import com.codeborne.selenide.Configuration;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;

import static com.codeborne.selenide.Selenide.open;

public class AddTabletToKart {

    private ProductsPage productsPage = new ProductsPage();
    private Header mainPageHeader = new MainPageHeader();
    private Header secondHeader = new SecondHeader();
    private ProductsTypeMenu productsTypeMenu = new ProductsTypeMenu();

    @Before
    public static void setUp() {
        Configuration.timeout = 30000;
        Configuration.browserSize = "1920x1080";
        WebDriverManager.chromedriver().version("75").setup();
    }

    @Then("change city by tipyng in serch field to {string}")
    public void changeCityByTipyngInSerchField(String city) {
        mainPageHeader.openCitiesChoiceWindow().searchByTypingInSearchField(city);
    }


    @Then("Select {string} language")
    public void selectLanguage(String language) {
        mainPageHeader.changeLanguage(language);
    }

//    @Then("click tablet on side menu")
//    public void clickTabletOnSideMenu() {
//
//    }

    @Then("click on all tablets")
    public void clickOnAllTablets() {
        productsTypeMenu.clickOnShowAllResults();
    }

    @Then("select first result and add to cart")
    public void selectFirstResults(Integer firstProduct) {
        productsPage.clickProductItemAddToKart(firstProduct);
    }


    @Then("go to cart")
    public void goToCart() {
        secondHeader.clickOnCartIcon();
    }


}
