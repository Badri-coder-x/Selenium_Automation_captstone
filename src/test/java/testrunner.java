import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="features",glue= {"stepdefinition"} ,plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json",
        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"  
    },
    monochrome = true)
public class testrunner extends AbstractTestNGCucumberTests{

}