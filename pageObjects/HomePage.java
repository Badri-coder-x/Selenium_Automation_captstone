package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	WebElement register, event;
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		
	}
	
	public void clickRegister() 
	{
		register = driver.findElement(By.xpath("//img[@src='images/p_reg.gif']"));
		register.click();
		
	}
	
	public void clickEvent() 
	{
		event = driver.findElement(By.xpath("//img[@src='images/p_events.gif']"));
		event.click();
	}
	
	public void putKeyword(String keyInput) {
		driver.findElement(By.xpath("//input[@name='article_title']")).sendKeys(keyInput);
	}
	
	public void clickArticleSearch() throws InterruptedException {
		driver.findElement(By.xpath("//input[@src='Styles/Innovation/Images/en/ButtonSearch.gif']")).click();
		Thread.sleep(2000);
	}
	

	
}
