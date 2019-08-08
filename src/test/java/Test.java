import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"stepdefs"},
        plugin = {"pretty"},
        tags = {"@Broken, @NewTest"}
)

public class Test {
}
