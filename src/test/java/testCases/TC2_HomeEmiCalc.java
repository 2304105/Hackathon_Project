package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomeLoan_EMI;
import testBase.BaseClass;

public class TC2_HomeEmiCalc extends BaseClass {
	HomeLoan_EMI hl;
	
	
	
	
	@Test(priority = 1)
	void yearTable() throws Exception {
		hl = new HomeLoan_EMI(driver);
		Assert.assertEquals(hl.homeEmiCalcTitle(), "Home Loan EMI Calculator with Prepayments, Taxes & Insurance");
		screenshot("Home_Loan_Details");
		hl.year_Table();
		logger.info("Test Case : 11 executed successfully___☑️");
	}
	
	@Test(priority = 2)
	void tableloan() throws Exception {
		hl.loantable();
		screenshot("LoanTable");
		logger.info("Test Case : 12 executed successfully___☑️");
	}

}
