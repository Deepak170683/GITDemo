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

public class ValidateTitle extends base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initalize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver intilized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	
	}
	
	
	
	
	@Test()	
	public void basePagNavigation() throws IOException
	{
	
		//creating object to that class and invoke methods of it
		LamdingPage l = new LamdingPage(driver);
		//compare the text from browser with text 
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES123");
		log.info("Successfuly validated test message");		
		
		//FEATURED COURSES
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
