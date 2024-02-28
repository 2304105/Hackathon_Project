package stepDefinations;

import java.io.IOException;
import java.util.Properties;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
import testBase.CucumberBaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	WebDriver driver;
	Properties p;
	@Before
	public void setup() throws IOException {
		driver = CucumberBaseClass.initilizeBrowser();
		p = CucumberBaseClass.getProperties();
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();
	}
	@After
	public void teardown() {
		driver.quit();
	}
	
	public void addScreenshot(Scenario scenario) {
		// this is for cucumber junit report  
        if(scenario.isFailed()) {
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        }
	}
}
