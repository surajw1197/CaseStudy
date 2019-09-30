package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions (
		features = "features\\CartAvailability.feature",
		glue = {"stepDefinition"},
				plugin = {
						"json:target/cucumber-reports/CartAvailability.json"
						}
		)


public class CartAvailability {

}
