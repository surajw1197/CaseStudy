package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions (
		features = "features\\caseStudy.feature",
		glue = {"stepDefinition"},
				plugin = {
						"json:target/cucumber-reports/caseStudy.json"
						}
		)

public class CaseStudyRunner {

}
