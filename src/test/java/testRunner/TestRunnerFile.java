package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {
				"C:\\Users\\2304105\\eclipse-workspace\\Hackathon_Project\\Features\\Emi_Calculator.feature",
				"C:\\Users\\2304105\\eclipse-workspace\\Hackathon_Project\\Features\\HomeLoan_EMI.feature",
				"C:\\Users\\2304105\\eclipse-workspace\\Hackathon_Project\\Features\\Loan_Calculator.feature"},
		glue="stepDefinations",
		plugin= {"pretty", "html:cucumber_reports/c_report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"	
		}
		)

public class TestRunnerFile {

}
