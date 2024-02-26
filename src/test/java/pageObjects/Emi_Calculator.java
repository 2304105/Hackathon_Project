package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class Emi_Calculator extends BasePage {

	public Emi_Calculator(WebDriver driver) {
	// BasePage constructor //
		super(driver);
	}
	
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public Actions move = new Actions(driver);
	
	
	//To get title of current page
	public String carLoanTitle() {
		String Title_p1 = driver.getTitle();
		return Title_p1;
	}
	
	
	@FindBy(xpath="//a[text()='Car Loan']")
	WebElement car_loan;
	
	public void carloanbtn() {
		car_loan.click();
	}
	
	
	@FindBy(id="loanamountslider")
	WebElement home_loan;
	@FindBy(id="loanamount")
	WebElement home_amt;
	
	public String homeloanamt() {
		Action homeloan_amt = (Action) move.dragAndDropBy(home_loan, 163, 0).build();
		homeloan_amt.perform();
		String homeamt = home_amt.getAttribute("value");
		return homeamt;
	}
	
	
	@FindBy(id="loaninterestslider")
	WebElement interest_rate;
	@FindBy(id="loaninterest")
	WebElement int_rte;
	
	public String interestrate() {
		Action int_rate = (Action) move.dragAndDropBy(interest_rate, -130, 0).build();
		int_rate.perform();
		String intrate = int_rte.getAttribute("value");
		return intrate;
	}
	
	@FindBy(id="loantermslider")
	WebElement loan_tenure;
	@FindBy(id="loanterm")
	WebElement loan_t;
	
	public String loantenure() {
		Action loan_ten = (Action) move.dragAndDropBy(loan_tenure, -220, 0).build();
		loan_ten.perform();
		String l_t = loan_t.getAttribute("value");
		return l_t;
	}
	
	@FindBy(xpath="//*[@id=\"leschemewrapper\"]/div/div/div/div/label[1]")
	WebElement emi_advance;
	
	public boolean emiadvance() {
		js.executeScript("arguments[0].scrollIntoView();",emi_advance);
		emi_advance.click();
		return true;
	}
	
	
	@FindBy(id="year2024")
	WebElement year;
	
	public boolean yeartable() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();",year);
		year.click();
		Thread.sleep(3000);
		return true;
	}
	
	@FindBy(xpath="//*[@id=\"monthyear2024\"]/td/div/table/tbody/tr[2]/td[2]")
	WebElement principal;
	
	@FindBy(xpath="//*[@id=\"monthyear2024\"]/td/div/table/tbody/tr[2]/td[3]")
	WebElement interest;
	
	public String p_amt() {
		String p_amt = principal.getText();
		return p_amt;
	}
	
	public String i_amt() {
		String i_amt = interest.getText();
		return i_amt;
	}
	
	
	@FindBy(xpath="//*[@id=\"leschemewrapper\"]/div/div/div/div/label[2]")
	WebElement emi_arrears;
	
	public boolean emiarrears() {
		js.executeScript("arguments[0].scrollIntoView();",emi_arrears);
		emi_arrears.click();
		return true;
	}
	
	public String p_amtArr() {
		String p_armt = principal.getText();
		return p_armt;
	}
	
	public String i_rtArr() {
		String i_armt = interest.getText();
		return i_armt;
	}
	
	@FindBy(id="menu-item-2696")
	WebElement calculators;
	
	public void menubar() {
		calculators.click();
	}

	
	@FindBy(xpath="//*[@id=\"menu-item-3294\"]/a")
	WebElement home_emi;
	
	public void homeloanemi() {
		home_emi.click();
	}
		
}
