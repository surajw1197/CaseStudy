package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions (
		features = "features\\Registration.feature",
		glue = {"stepDefinition"},
				plugin = {
						"json:target/cucumber-reports/Registration.json"
						}
		)

public class Registration {

}
