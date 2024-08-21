package guru99.Ecommerce.TechPandaWebsite.Automation.runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/TechPandaWebsiteAutomation.feature",
    glue = "guru99.Ecommerce.TechPandaWebsite.Automation.stepDefinition",
    tags = "@eighthScenerio" 	
    // @fifthScenario or @sixthScenario
   // plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();	
        	
        
    }
}
	

	

	

	

	
