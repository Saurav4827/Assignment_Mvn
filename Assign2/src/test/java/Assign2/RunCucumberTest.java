package Assign2;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Assign2/javat.feature",glue= {"Assign2.Stepdefs"},plugin = {"pretty"})
public class RunCucumberTest {
	
}
