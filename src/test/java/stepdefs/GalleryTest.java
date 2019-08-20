package stepdefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;


public class GalleryTest {

    @Before
    public static void setUp() {

        Configuration.timeout = 30000;
        Configuration.browserSize = "1920x1080";
        WebDriverManager.chromedriver().version("75").setup();

    }

    @Given("Login page")
    public void loginPage() {

        open("http://127.0.0.1:3000/login");

    }

    @Then("Click on google authorization")
    public void clickOnGoogleAuthorization() {

        $(".login-button > span").click();

    }

    @Then("Enter Username and Password")
    public void enterUsernameAndPassword() {

        $("[type=email]").setValue("qasuperusertest@gmail.com").pressEnter();
        $("[type=password]").setValue("ucSBr9yNwrae").pressEnter();

    }

    @After
    public void TakeScreenshot() throws IOException {

        sleep(3000);
        System.out.println($("body").text());
        ScreenShooter.failedTests().succeededTests();

    }

}
