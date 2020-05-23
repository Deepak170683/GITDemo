package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LamdingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initalize() throws IOException
	{
		driver=initializeDriver();
		
	}
	
	
	@Test(dataProvider="getData")	
	public void basePagNavigation(String Username,String Password,String text) throws IOException
	{
	
		driver.get(prop.getProperty("url"));
		LamdingPage l = new LamdingPage(driver);
		l.getLogin().click();
		log.info("clicked on login button");
		LoginPage ln = new LoginPage(driver);
	    ln.getEmail().sendKeys(Username);
		ln.getPassword().sendKeys(Password);
		ln.clicklogin().click();
		log.info(text);
	}
	
	 @DataProvider
	 public Object[][] getData()
	 {
		 //row stands for how many differnt data types test should run
		 //columns stands for how many value per each test
		 Object[][] data=new Object[2][3];
		 data[0][0]="dsp@gmail.com";
		 data[0][1]="abc";
		 data[0][2]= "Restricted User";		 
		 data[1][0]="xyz@gmail.com";
		 data[1][1]="lmn";
		 data[1][2]= "Non Restricted User";
		 
		 return data;
	 }

	 
	 @AfterTest
		public void teardown()
		{
			driver.close();
		}
}
