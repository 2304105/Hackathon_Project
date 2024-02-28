package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import pageObjects.Emi_Calculator;
import testBase.BaseClass;

public class TC1_CarLoan extends BaseClass {
	Emi_Calculator ec;
	
	@Test(priority = 1,groups= {"master","sanity"})
	void btncarloan() {
		ec = new Emi_Calculator(driver);
		Assert.assertEquals(ec.carLoanTitle(), "EMI Calculator for Home Loan, Car Loan & Personal Loan in India");
		ec.carloanbtn();
		logger.info("Test Case : 1 executed successfully___☑️");
	}
	
	@Test(priority = 2,groups= {"master","regression","sanity"})
	void amthomeloan() {
		Assert.assertEquals(ec.homeloanamt(),"15,00,000");
		logger.info("Test Case : 2 executed successfully___☑️");
	}
	
	@Test(priority = 3,groups= {"master","regression"})
	void rateinterest() {
		Assert.assertEquals(ec.interestrate(), "9.5");
		logger.info("Test Case : 3 executed successfully___☑️");
	}
	
	@Test(priority = 4,groups= {"master","regression"})
	void tenureloan() throws Exception {
		Assert.assertEquals(ec.loantenure(), "1");
		Thread.sleep(2000);
		logger.info("Test Case : 4 executed successfully___☑️");
	}
	
	@Test(priority = 5,groups= {"master","sanity"})
	void advanceemibtn() {
		Assert.assertTrue(ec.emiadvance(), "Invalid Button");
		logger.info("Test Case : 5 executed successfully___☑️");
	}
	
	@Test(priority = 6,groups= {"master"})
	void tableyear() throws InterruptedException {
		Assert.assertTrue(ec.yeartable(), "Invalid Scroll");
		logger.info("Test Case : 6 executed successfully___☑️");
	}
	
	@Test(priority = 7,groups= {"master","regression"})
	void amtp_int() throws IOException {
		ExcelUtility.write("EMI", 0, 0, "EMI IN ADAVNCED");
		ExcelUtility.write("EMI", 1, 0, "Principal Amount");
		ExcelUtility.write("EMI", 2, 0, ec.p_amt());
		ExcelUtility.write("EMI", 1, 1, "Interest Amount");
		ExcelUtility.write("EMI", 2, 1, ec.i_amt());

		logger.info("Test Case : 7 executed successfully___☑️");
	}
	
	@Test(priority = 8,groups= {"master","regression"})
	void arrearsemi() {
		Assert.assertTrue(ec.emiarrears(), "Invalid Scroll");
		logger.info("Test Case : 8 executed successfully___☑️");
	}
	
	@Test(priority = 9,groups= {"master","regression"})
	void arrAmtp_int() throws Exception {
		ec.yeartable();
		ExcelUtility.write("EMI", 3, 0, "EMI IN Arrears");
		ExcelUtility.write("EMI", 4, 0, "Principal Amount");
		ExcelUtility.write("EMI", 5, 0, ec.p_amtArr());
		ExcelUtility.write("EMI", 4, 1, "Interest Amount");
		ExcelUtility.write("EMI", 5, 1, ec.i_rtArr());
		logger.info("Test Case : 9 executed successfully___☑️");
	}
	
	//To Menu Bar for Home Loan EMI Calculator//
		@Test(priority = 10,groups= {"master","regression"})
		void menuBar() {
			ec.menubar();
			ec.homeloanemi();
			logger.info("Test Case : 10 executed successfully___☑️");
		}
	
	
}
