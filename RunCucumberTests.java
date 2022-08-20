package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature/Login.feature",
                 glue="stepDef",
                 monochrome=true,
                 publish=true
                 )

public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
