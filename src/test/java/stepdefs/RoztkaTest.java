package stepdefs;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.cssSelector;
import com.codeborne.selenide.junit.ScreenShooter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.IOException;
import java.util.Random;


public class RoztkaTest {

    @Given("^I open chrome and go to ([a-z]+.+[com]+.+[ua])$")
    public void GoToRozetka(String arg1) {

        open("http:\\" + arg1);

    }

    @Then("^select any city$")
    public void SelectCity() {

        $(cssSelector(".header-cities__link.link-dashed")).click();
        int element = new Random().nextInt(($$(cssSelector("a.header-location__popular-link")).size()) - 1);
        $$(cssSelector("a.header-location__popular-link")).get(element).click();

    }

    @Then("^I using search field search \"([^\"\"$]*)\"$")
    public void SearchItems(String arg1) {

        $(cssSelector("[name=search]")).val(arg1).pressEnter();

    }

    @Then("^select producer \"([^\"\"$]*)\", \"([^\"\"$]*)\" and \"([^\"\"$]*)\"$")
    public void SelectProducer(String arg1, String  arg2, String arg3) {

        $(cssSelector("[name=producer_148]")).click();
        $(cssSelector("[name=producer_14]")).click();
        $(cssSelector("[name=producer_12]")).click();

    }

    @Then("^sort by popularity$")
    public void SortByPopularity () {

        $(cssSelector("a.dropdown-link")).click();
        $("#filter_sortpopularity").should(visible).click();

    }

    @Then("^select (\\d+) first results$")
    public void SelectResults(int arg1) {


        for (int i = 0; i < arg1; i++ ) {
            $$(cssSelector("div.over-wraper")).get(i).hover();
            $$(cssSelector("[name=comparison_new_catalog]")).get(i).hover().doubleClick();

        }
    }

    @Then("^compare results$")
    public void CompareResults() {

        $(cssSelector("#comparison-header")).doubleClick();
        $(cssSelector("div.btn-link-to-compare > a")).doubleClick();

        //Output compare result to console
//        ElementsCollection prompt = $$(By.cssSelector("div.comparison-t-row"));
//        for (WebElement item:prompt) {
//            String a = item.getText();
//            System.out.println(a);
//        }

    }

    @Then("^take screenshot$")
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
