package stepDefinations;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import Utilities.ExcelUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Emi_Calculator;
import pageObjects.HomeLoan_EMI;
import pageObjects.Loan_Calculator;
import testBase.CucumberBaseClass;

public class Allsteps {
	WebDriver driver;
	Properties p;
	Emi_Calculator ec = new Emi_Calculator(CucumberBaseClass.getDriver());
	HomeLoan_EMI hl = new HomeLoan_EMI(CucumberBaseClass.getDriver());
	Loan_Calculator lc = new Loan_Calculator(CucumberBaseClass.getDriver());
	
	

	public List<String> loantable = new ArrayList<>();
	
	@Given("User fetch the car loan title")
	public void user_fetch_the_car_loan_title() throws Exception {
		ec.carLoanTitle();
	}

	@When("User verifies the title")
	public void user_verifies_the_title() {
		
		Assert.assertEquals(ec.carLoanTitle(), "EMI Calculator for Home Loan, Car Loan & Personal Loan in India");
	}

	@Then("User clicks on Car Loan button")
	public void user_clicks_on_car_loan_button() {
		
		ec.carloanbtn();
	}

	@Then("User changes values using slider")
	public void user_changes_values_using_slider() {
		
		Assert.assertEquals(ec.homeloanamt(),"15,00,000");
		Assert.assertEquals(ec.interestrate(), "9.5");
		Assert.assertEquals(ec.loantenure(), "1");
	}

	@Then("User fetch the principal and interest for advance and arrears")
	public void user_fetch_the_principal_and_interest_for_advance_and_arrears() throws Exception {
		
		Assert.assertTrue(ec.emiadvance(), "Invalid Button");
		Assert.assertTrue(ec.yeartable(), "Invalid Scroll");
		
		ExcelUtility.write("EMI", 0, 0, "EMI IN ADAVNCED");
		ExcelUtility.write("EMI", 1, 0, "Principal Amount");
		ExcelUtility.write("EMI", 2, 0, ec.p_amt());
		ExcelUtility.write("EMI", 1, 1, "Interest Amount");
		ExcelUtility.write("EMI", 2, 1, ec.i_amt());


		Assert.assertTrue(ec.emiarrears(), "Invalid Scroll");
		ec.yeartable();
		ExcelUtility.write("EMI", 3, 0, "EMI IN Arrears");
		ExcelUtility.write("EMI", 4, 0, "Principal Amount");
		ExcelUtility.write("EMI", 5, 0, ec.p_amtArr());
		ExcelUtility.write("EMI", 4, 1, "Interest Amount");
		ExcelUtility.write("EMI", 5, 1, ec.i_rtArr());

	}
	
	@Given("User clicks on homeloan button")
	public void user_clicks_on_homeloan_button() {
		
		ec.menubar();
		ec.homeloanemi();
	}

	@When("User scrolls to year table")
	public void user_scrolls_to_year_table() throws Exception {
		
		hl.year_Table();
	}

	@Then("fetch the year webtable to excel")
	public void fetch_the_year_webtable_to_excel() throws Exception {
		
		hl.loantable();
	}
	
	@Given("User clicks on loan calculator")
	public void user_clicks_on_loan_calculator() {
		lc.menubar();
		lc.loancalc();
		Assert.assertEquals(lc.loanCalcTitle(), "Loan Calculator — Calculate EMI, Affordability, Tenure & Interest Rate");
		
	}
	@When("User clicks on emi calculator button")
	public void user_clicks_on_emi_calculator_button() {
		lc.emi();
	}
	@Then("User changes values using slide1")
	public void user_changes_values_using_slide1() {
		
		Assert.assertEquals(lc.loanamt(),"40,00,000");
		Assert.assertEquals(lc.interestr(),"13.5");
		Assert.assertNotEquals(lc.loanTenureYear(), lc.loanTenureYr());
		Assert.assertNotEquals(lc.loanTenureMonth(), lc.loanTenureMn());
	}
	@Then("User clicks on loan amount calculator")
	public void user_clicks_on_loan_amount_calculator() {
		lc.loanAmount();
	}
	@Then("User changes values using slide2")
	public void user_changes_values_using_slide2() {
		
		Assert.assertEquals(lc.loanEMI(), "26,500.00");
		Assert.assertEquals(lc.interestr(),"13.5");
		Assert.assertNotEquals(lc.loanTenureYear(), lc.loanTenureYr());
		Assert.assertNotEquals(lc.loanTenureYear(), lc.loanTenureYr());
	}
	@Then("User clicks on loan tenure calculator")
	public void user_clicks_on_loan_tenure_calculator() {
		lc.loanTenure();
	}
	@Then("User changes values using slide3")
	public void user_changes_values_using_slide3() {
		
		Assert.assertEquals(lc.loanamt(),"41,00,000");
		Assert.assertEquals(lc.loanEMI(), "46,961.90");
		Assert.assertEquals(lc.interestr(),"13.5");
	}

	
}
