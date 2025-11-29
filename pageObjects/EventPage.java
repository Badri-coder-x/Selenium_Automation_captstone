package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventPage {
	WebDriver driver;
	
	public EventPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void putKeyword(String str1) 
	{
		driver.findElement(By.xpath("//input[@name='event_desc']")).sendKeys(str1);
		
	}
	
	public void clickEventSearch() 
	{
		driver.findElement(By.xpath("//input[@src='Styles/Innovation/Images/en/ButtonSearch.gif']")).click();
	}
	
	
}
