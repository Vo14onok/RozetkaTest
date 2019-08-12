package stepdefs;

import static com.codeborne.selenide.Selenide.*;

import Pages.ComparePage;
import Pages.MainPage;
import Pages.ProductsPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

public class RoztkaTest {

    private MainPage mainPage = new MainPage();
    private ProductsPage productsPage = new ProductsPage();
    private ComparePage comparePage = new ComparePage();
//    ComparedProductsPage comparedProductsPage = new ComparedProductsPage();

    @Before
    public static void setUp() {
        Configuration.timeout = 30000;
        Configuration.browserSize = "1920x1080";
        WebDriverManager.chromedriver().version("75").setup();
    }

    @Given("^I open chrome and go to ([a-z]+.+[com]+.+[ua])$")
    public void GoToRozetka(String arg1) {

        open("http:\\" + arg1);

    }

    @Then("^select any city$")
    public void SelectCity() {

        mainPage.CitiesMenu();
        mainPage.RandomCity();

    }

    @Then("^I using search field search \"([^\"\"$]*)\"$")
    public void SearchItems(String arg1) {

        mainPage.SearchField(arg1);

    }

    @Then("^select producer \"([^\"\"$]*)\", \"([^\"\"$]*)\" and \"([^\"\"$]*)\"$")
    public void SelectProducer(String arg1, String arg2,String arg3) {

        productsPage.Producer(arg1, arg2, arg3);

    }

    @Then("^sort by popularity$")
    public void SortByPopularity () {

        productsPage.SortMenu();
        productsPage.SortMenuChoiseByPopularyty();

    }

    @Then("^select (\\d+) first results$")
    public void SelectResults(int arg1) {

        for (int i = 0; i < arg1; i++ ) {
            productsPage.ProductItem(i);
            productsPage.ProductItemComparisionIcon(i);

        }
    }

    @Then("^compare results$")
    public void CompareResults() {

        mainPage.CompareItemsIcon();
        comparePage.CompareItems();

        //Output compare result to console
//        ElementsCollection prompt = $$(By.cssSelector("div.comparison-t-row"));
//        for (WebElement item:prompt) {
//            String a = item.getText();
//            System.out.println(a);
//        }

    }

    @After
    public void TakeScreenshot () throws IOException {

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
