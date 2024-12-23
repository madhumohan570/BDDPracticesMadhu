package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags="@Login", 
        features= {"src/test/resources/Features"},
        glue= {"StepDefinitions"}, 
        plugin= {"pretty"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
