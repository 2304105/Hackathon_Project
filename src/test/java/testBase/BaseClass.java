package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	Properties p;
	
	
	@BeforeTest
	@Parameters("browser")
	public WebDriver driverSetup(String browser) throws IOException {
		logger = LogManager.getLogger(this.getClass());
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		
		//For Selenium Grid :- 
		/*
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabalities = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabalities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) {
				capabalities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("no matching os .....");
				return null;
			}
			//browser
			if(browser.equalsIgnoreCase("chrome")) {
				capabalities.setBrowserName("chrome");
			}
			else if(browser.equalsIgnoreCase("edge")) {
				capabalities.setBrowserName("MicrosoftEdge");
			}
			else {
				System.out.println("no matching browser .....");
				return null;
			}

			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			// launching browser based on condition - locally
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				logger.info("Chrome browser opened successfully");
			}
			else if(browser.equalsIgnoreCase("edge")){
				driver = new EdgeDriver();
				logger.info("Edge browser opened successfully");
			}
			else {
				System.out.println("no matching browser......");
				logger.info("no matching browser......");
				return null;
			}

		}
		*/
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		logger.info(browser+" opened successfully___☑️");
		
			driver.get(p.getProperty("URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().deleteAllCookies();
			
		logger.info("Website opened successfully___☑️");
			
		return driver;
	}
	
	public String screenshot(String name) throws IOException {
		TakesScreenshot ss = ((TakesScreenshot) driver);
			File src=ss.getScreenshotAs(OutputType.FILE);
		
			String trgpath = System.getProperty("user.dir")+ "./Reports/Screenshot/"+name+".png";
			File trg=new File(trgpath);
			FileUtils.copyFile(src, trg);
			return trgpath;
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		logger.info("Browser closed successfully___☑️");
	}
}
