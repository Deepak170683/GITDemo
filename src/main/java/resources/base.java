package resources;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
	    prop = new Properties();
	    
	    //1 use encapsulation varibale private methods public
	    // don't use hardcode path rather use below
	    //FileInputSream fis = new FileInputStream(System.getProperty("user.dir") + "");
	    
	    
	    
		FileInputStream fis = new FileInputStream("D:\\Workspace\\e2eproject\\src\\main\\java\\resources\\data.properties");	
		prop.load(fis);
		//mvn test -Dbrowser=chrome
		
		String browsername = System.getProperty("browser");
		//String browsername = prop.getProperty("browser");
				
		System.out.println(browsername);
		
		if (browsername.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/Workspace/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browsername.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}
		else if (browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:/Workspace/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testcasename, WebDriver driver) throws IOException
	{
		
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 String destinationFile = System.getProperty("user.dir")+ "\\reports\\"+testcasename+".png";
	 FileUtils.copyFile(source, new File(destinationFile));
	 return destinationFile; 
	 
	}
	
}
