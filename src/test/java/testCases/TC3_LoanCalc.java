package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Loan_Calculator;
import testBase.BaseClass;

public class TC3_LoanCalc extends BaseClass {
	Loan_Calculator lc;
	
	@Test(priority = 1,groups= {"master","sanity"})
	void calcLoan() {
		lc = new Loan_Calculator(driver);
		lc.menubar();
		lc.loancalc();
		Assert.assertEquals(lc.loanCalcTitle(), "Loan Calculator — Calculate EMI, Affordability, Tenure & Interest Rate");
		logger.info("Test Case : 13 executed successfully___☑️");
	}
	
	@Test(priority = 2,groups= {"master","sanity"})
	void emiBtn() {
		lc.emi();
		logger.info("Test Case : 14 executed successfully___☑️");
	}
	
	@Test(priority = 3,groups= {"master","regression"})
	void amtLoan() {
		Assert.assertEquals(lc.loanamt(),"40,00,000");
		logger.info("Test Case : 15 executed successfully___☑️");
	}
	
	@Test(priority = 4,groups= {"master","regression"})
	void rInterest() {
		Assert.assertEquals(lc.interestr(),"13.5");
		logger.info("Test Case : 16 executed successfully___☑️");
	}
	
	//Loan Tenure for Year
	@Test(priority = 5,groups= {"master","regression"})
	void yearLoanTenure() throws IOException {
		Assert.assertNotEquals(lc.loanTenureYear(), lc.loanTenureYr());
		logger.info("Test Case : 17 executed successfully___☑️");
	}
	
	//Loan Tenure for Month
	@Test(priority = 6,groups= {"master","regression"})
	void monthLoanTenure() throws IOException {
		Assert.assertNotEquals(lc.loanTenureMonth(), lc.loanTenureMn());
		logger.info("Test Case : 18 executed successfully___☑️");
	}
	
	@Test(priority = 7,groups= {"master","regression"})
	void amountLoan() throws IOException {
		lc.loanAmount();
		Assert.assertEquals(lc.loanEMI(), "26,500.00");
		Assert.assertEquals(lc.interestr(),"13.5");
		Assert.assertNotEquals(lc.loanTenureYear(), lc.loanTenureYr());
		Assert.assertNotEquals(lc.loanTenureYear(), lc.loanTenureYr());
		logger.info("Test Case : 19 executed successfully___☑️");
	}
	
	@Test(priority = 8,groups= {"master","regression"})
	void tenureLoan() throws IOException {
		lc.loanTenure();
		Assert.assertEquals(lc.loanamt(),"41,00,000");
		Assert.assertEquals(lc.loanEMI(), "46,961.90");
		Assert.assertEquals(lc.interestr(),"13.5");
		logger.info("Test Case : 20 executed successfully___☑️");
	}
	
} 
