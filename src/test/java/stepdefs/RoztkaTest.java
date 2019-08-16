package stepdefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MainPage;
import pages.MainPageHeader;
import pages.ProductsPage;

import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static pages.Constants.ROZETKA_URL;

public class RoztkaTest {

    private MainPage mainPage = new MainPage();
    private ProductsPage productsPage = new ProductsPage();
    private MainPageHeader mainPageHeader = new MainPageHeader();

    @Before
    public static void setUp() {
        Configuration.timeout = 30000;
        Configuration.browserSize = "1920x1080";
        WebDriverManager.chromedriver().version("75").setup();
    }

    @Given("^I open chrome and go to rozetka.com.ua$")
    public void GoToRozetka() {

        open(ROZETKA_URL);

    }

    @Then("^select any city$")
    public void SelectCity() {

        mainPageHeader.openCitiesChoiceWindow().chooseRandomCity();

    }

    @Then("^I using search field search \"([^\"\"$]*)\"$")
    public void SearchItems(String searchParameter) {

        mainPageHeader.makeSearch(searchParameter);

    }

    @Then("^select product owners$")
    public void SelectProducer(List<String> productOwners) {

        productsPage.selectProductOwner(productOwners);

    }

    @Then("^sort by ([^\"\"$]*)$")
    public void SortByPopularity(String sortChoice) {

        productsPage.openSortMenu().selectSortChoise(sortChoice);

    }

    @Then("^select (\\d+) first results$")
    public void SelectResults(int numOfResults) {

        for (int i = 0; i < numOfResults; i++) {
            productsPage.clickProductItemComparisionIcon(i);

        }
    }

    @Then("^compare results$")
    public void CompareResults() {

        mainPage.goToComparisionPage().compareItems().printDifferent();

    }

    @After
    public void TakeScreenshot() throws IOException {

        ScreenShooter.failedTests().succeededTests();

//        File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")
//                + File.separator
//                + "screenshot"
//                + File.separator
//                + java.time.LocalDate.now()
//                +".jpg"));
//
//        driver.quit();

    }

}
