package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\java\\features\\EmptyCart.feature",
		glue="steps",
		tags="@emptyCart",
		monochrome=true,
		dryRun=false,
		plugin= {
				"pretty",
				"html:target/cucumber.html",
				"json:target/cucumber.json"
		}
		)

public class EmptyCartRunner {

}
