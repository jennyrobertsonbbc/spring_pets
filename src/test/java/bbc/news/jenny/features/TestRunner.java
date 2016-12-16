package bbc.news.jenny.features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" }
//        tags = "@UserAccounts, @HireCar"
)
//class name has to end in test for cucumber tests to be run by Maven
public class TestRunner {
}
