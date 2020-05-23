package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LamdingPage {
	
	public WebDriver driver;
	By signin = By.xpath("//*[@id='homepage']/header/div[1]/div/nav/ul/li[4]/a");
	By title = By.xpath("//*[@id='content']/div/div/h2");   
	By navibar = By.xpath("//*[@id='homepage']/header/div[2]");
	
	public LamdingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  WebElement getLogin()
	{
				return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		
		return driver.findElement(title);
	}
	
	
	public WebElement getNaviBar()
	{
		
		return driver.findElement(navibar);
	}
	
}
