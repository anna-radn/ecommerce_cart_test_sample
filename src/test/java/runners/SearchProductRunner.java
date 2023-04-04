package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\java\\features\\SearchProduct.feature",
		glue="steps",
		tags="@searchProduct",
		monochrome=true,
        dryRun=false,
		plugin= {
				"pretty",
				"html:target/cucumber.html",
				"json:target/cucumber.json"
		}
		)

public class SearchProductRunner {

}
