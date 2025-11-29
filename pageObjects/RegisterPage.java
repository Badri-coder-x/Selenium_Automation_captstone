package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void toRegister(String login, String password, String fname, String lname, String email) throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@name='member_login']")).sendKeys(login);
		driver.findElement(By.xpath("//input[@name='member_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lname);
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@src='Styles/Innovation/Images/en/ButtonInsert.gif']")).click();
//		Thread.sleep(2000);
		
		
	}
	
	public void clickAdd() throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@src='Styles/Innovation/Images/en/ButtonInsert.gif']")).click();
		Thread.sleep(2000);
	}
}
