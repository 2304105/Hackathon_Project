package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Loan_Calculator;
import testBase.BaseClass;

public class TC3_LoanCalc extends BaseClass {
	Loan_Calculator lc;
	
	@Test(priority = 1)
	void calcLoan() {
		lc = new Loan_Calculator(driver);
		lc.menubar();
		lc.loancalc();
		Assert.assertEquals(lc.loanCalcTitle(), "Loan Calculator — Calculate EMI, Affordability, Tenure & Interest Rate");
		logger.info("Test Case : 13 executed successfully___☑️");
	}
	
	@Test(priority = 2)
	void emiBtn() {
		lc.emi();
		logger.info("Test Case : 14 executed successfully___☑️");
	}
	
	@Test(priority = 3)
	void amtLoan() {
		Assert.assertEquals(lc.loanamt(),"40,00,000");
		logger.info("Test Case : 15 executed successfully___☑️");
	}
	
	@Test(priority = 4)
	void rInterest() {
		Assert.assertEquals(lc.interestr(),"13.5");
		logger.info("Test Case : 16 executed successfully___☑️");
	}
	
	//Loan Tenure for Year
	@Test(priority = 5)
	void yearLoanTenure() throws IOException {
		screenshot("EMI_Calculator_Year");
		Assert.assertNotEquals(lc.loanTenureYear(), lc.loanTenureYr());
		logger.info("Test Case : 17 executed successfully___☑️");
	}
	
	//Loan Tenure for Month
	@Test(priority = 6)
	void monthLoanTenure() throws IOException {
		screenshot("EMI_Calculator_Month");
		Assert.assertNotEquals(lc.loanTenureMonth(), lc.loanTenureMn());
		logger.info("Test Case : 18 executed successfully___☑️");
	}
	
	@Test(priority = 7)
	void amountLoan() throws IOException {
		lc.loanAmount();
		Assert.assertEquals(lc.loanEMI(), "26,500.00");
		Assert.assertEquals(lc.interestr(),"13.5");
		Assert.assertNotEquals(lc.loanTenureYear(), lc.loanTenureYr());
		screenshot("L_A_Calculator_Year");
		Assert.assertNotEquals(lc.loanTenureYear(), lc.loanTenureYr());
		screenshot("L_A_Calculator_Month");
		logger.info("Test Case : 19 executed successfully___☑️");
	}
	
	@Test(priority = 8)
	void tenureLoan() throws IOException {
		lc.loanTenure();
		Assert.assertEquals(lc.loanamt(),"41,00,000");
		Assert.assertEquals(lc.loanEMI(), "46,961.90");
		Assert.assertEquals(lc.interestr(),"13.5");
		screenshot("Loan Tenure Calculator");
		logger.info("Test Case : 20 executed successfully___☑️");
	}
	
}
