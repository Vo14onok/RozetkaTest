package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class RoztkaTest {

    private WebDriver driver;

    @Given("^I open chrome and go to ([a-z]+.+[com]+.+[ua])$")
    public void GoToRozetka(String arg1) {

        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("start-maximized")
               .addArguments("disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("http:\\" + arg1);

    }

    @Then("^select any city$")
    public void SelectCity() {

        driver.findElement(By.cssSelector(".header-cities__link.link-dashed")).click();
        int element = new Random().nextInt((driver.findElements(By.cssSelector("a.header-location__popular-link")).size()) - 1);
        driver.findElements(By.cssSelector("a.header-location__popular-link")).get(element).click();

    }

    @Then("^I using search field search \"([^\"\"$]*)\"$")
    public void SearchItems(String arg1) {

        driver.findElement(By.cssSelector("[name=search]")).sendKeys(arg1);
        driver.findElement(By.cssSelector("[name=search]")).sendKeys(Keys.ENTER);

    }

    @Then("^select producer \"Boch\", \"LG\" and \"Samsung\"$")
    public void SelectProducer() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name=producer_148]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name=producer_14]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name=producer_12]"))).click();

    }

    @Then("^sort by popularity$")
    public void SortByPopularity () {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sort_view > a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#filter_sortpopularity"))).click();
//        driver.findElement(By.cssSelector("#sort_view > a")).click();
//        driver.findElement(By.cssSelector("#filter_sortpopularity")).click();

    }

    @Then("^select (\\d+) first results$")
    public void SelectResults(int arg1) {

        for (int i = 0; i < arg1; i++ ) {
            WebElement conditioner = driver.findElements(By.cssSelector("div.over-wraper")).get(i);
            new Actions(driver).moveToElement(conditioner).perform();
            driver.findElements(By.cssSelector("[name=comparison_new_catalog]")).get(i).click();

        }
    }

    @Then("^compare results$")
    public void CompareResults() {

        WebElement compare = driver.findElement(By.cssSelector("#comparison-header"));
        new Actions(driver).moveToElement(compare).perform();
        driver.findElement(By.cssSelector("#comparison-header")).click();
        driver.findElement(By.cssSelector("div.btn-link-to-compare > a")).click();

        //Output compare result to console
        List<WebElement> prompt = driver.findElements(By.cssSelector("div.comparison-t-row"));
        for (WebElement item:prompt) {
            String a = item.getText();
            System.out.println(a);
        }

    }

    @Then("^take screenshot$")
    public void TakeScreenshot () throws IOException {

        File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\screenshot\\" + java.time.LocalDate.now() +".jpg"));

        driver.quit();

    }

}
