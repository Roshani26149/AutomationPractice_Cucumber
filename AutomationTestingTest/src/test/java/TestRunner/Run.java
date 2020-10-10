package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\CucumberProjects\\AutomationTestingTest\\src\\test\\resources\\features\\loginpage.feature",
                 glue="StepDefinations",
                 dryRun=false,
                 monochrome=true,
                 plugin= {
                		 "pretty","html:test_output"
                 }
             )

public class Run {
	

}
