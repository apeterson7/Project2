package cuke;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/resources/CaliberHome.feature"},
		glue = {"cuke"}
		)
public class NGCucumberRunner extends AbstractTestNGCucumberTests {
	
		
}