package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtility;

public class HomeLoan_EMI extends BasePage {

	public HomeLoan_EMI(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public Actions move = new Actions(driver);
	public List<String> loantable = new ArrayList<>();
	

	public String homeEmiCalcTitle() {
		String Title_p2 = driver.getTitle();
		return Title_p2;
	}
	
	@FindBy(id="homeloanterm")
	WebElement loan_T;

	
	@FindBy(id="year2024")
	WebElement year;
	
	public void year_Table() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();",year);
		Thread.sleep(3000);
	}
	
	
	
	/*Apache POI writing data */
	


	@FindBy(xpath = "//*[@id='paymentschedule']/table")
	WebElement loan_table;
	

	public void loantable() throws IOException, InterruptedException {
	List<WebElement> header = loan_table.findElements(By.xpath("//tr/th"));
	List<WebElement> rows = loan_table.findElements(By.xpath("//tr[@class=\"row no-margin yearlypaymentdetails\"]"));

		for (int i = 1; i < header.size() + 1; i++) {
			ExcelUtility.write("LoanTable", 0, i - 1, header.get(i - 1).getText());
			for (int j = 0; j < rows.size(); j++) {
				ExcelUtility.write("LoanTable", j + 1, i - 1, rows.get(j).findElement(By.xpath("td[" + i + "]")).getText());
 
			}
		}
	
	
	}

}
