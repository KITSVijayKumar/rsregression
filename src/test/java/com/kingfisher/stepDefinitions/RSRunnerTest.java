package com.kingfisher.stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty", 
				"html:target/cucumber-html-report", 
				"json:target/cucumber-json-report.json", 
				"pretty:target/cucumber-pretty.txt", 
				"usage:target/cucumber-usage.json", 
				"junit:target/cucumber-junit-report/cucumber-results.xml"},
		//features={"src/test/resources/002RSsellingContent.feature"},
		//features={"src/test/resources/002RS_SIT_sellingContent.feature"},
		features={"src/test/resources/RSsellingContent.feature"},
		glue={"com/kingfisher/stepDefinitions"},
		tags={"@SellingContentPush"} 
		//tags={"@SellingContentExport"}
		//tags={"@updateAttributeValues"}
		)
public class RSRunnerTest {
}
