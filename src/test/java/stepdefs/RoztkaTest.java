package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;


public class RoztkaTest {

    private WebDriver driver;

    @Given("^I open chrome and go to ([a-z]+.+[com]+.+[ua])$")
    public void GoToRozetka(String arg1) {

        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("http:\\" + arg1);

    }

    @Then("^select any city$")
    public void SelectCity() {

        int element;
        Random r = new Random();

        driver.findElement(By.cssSelector("a.header-cities__link.link-dashed")).click();
        List<WebElement> list = driver.findElements(By.cssSelector("a.header-location__popular-link"));
        element = r.nextInt((list.size()) - 1);
        driver.findElements(By.cssSelector("a.header-location__popular-link")).get(element).click();

    }

    @Then("^I using search field search \"([^\"\"$]*)\"$")
    public void SearchItems(String arg1) {

        driver.findElement(By.cssSelector("[name=search]")).sendKeys(arg1);
        driver.findElement(By.cssSelector("[name=search]")).sendKeys(Keys.ENTER);

    }

    @Then("^select (\\d+) first results$")
    public void SelectResults(int arg1) {

        Actions actions = new Actions(driver);

        List<WebElement> conditioners = driver.findElements(By.cssSelector("div.over-wraper"));

        for (int i = 0; i < arg1; i++ ) {
            WebElement conditioner = conditioners.get(i);
            actions.moveToElement(conditioner).perform();
            driver.findElements(By.cssSelector("[name=comparison_new_catalog]")).get(i).click();

        }
    }

    @Then("^compare results$")
    public void CompareResults() {

        Actions actions = new Actions(driver);

        WebElement compare = driver.findElement(By.cssSelector("#comparison-header"));
        actions.moveToElement(compare).perform();
        driver.findElement(By.cssSelector("#comparison-header")).click();
        driver.findElement(By.cssSelector("div.btn-link-to-compare > a > span")).click();


        //Output compare result to console
        List<WebElement> prompt = driver.findElements(By.cssSelector("div.comparison-t-row"));
        for (WebElement item:prompt) {
            String a = item.getText();
            System.out.println(a);
        }

        driver.close();
        driver.quit();
    }
}
