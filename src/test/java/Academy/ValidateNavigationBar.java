package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LamdingPage;
import pageObjects.LoginPage;
import resources.base;



// Adding logs
//Generating Html reports
// screenshots on failure
//Jenkins integration





public class ValidateNavigationBar extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initalize() throws IOException
	{
		driver=initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
	}

	
	@Test()	
	public void basePagNavigation() throws IOException
	{
	
		//creating object to that class and invoke methods of it
		LamdingPage l = new LamdingPage(driver);
		//compare the text from browser with text 
		Assert.assertTrue(l.getNaviBar().isDisplayed());
		log.info("Nvaigation Bar is visible.");
		
		//FEATURED COURSES
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
