import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"classpath:stepdefs"},
        plugin = {"pretty"},
        tags = {
//                "@SmokeTest"
                "@FirstTest"
        }
)

public class Test {
}
