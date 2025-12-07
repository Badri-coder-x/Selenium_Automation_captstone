package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import utility.ScreenshotGenerator;
import utility.reportGenerator;

public class TC1_registration extends reportGenerator {
	WebDriver driver;
	WebElement error1,errorElement;
	
	
	@Given("user is on the registration page")
	public void user_is_on_the_registration_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver = new EdgeDriver();
        driver.get("http://examples.codecharge.com/Portal/Default.php");
	    System.out.println("Okay");
	    HomePage home = new HomePage(driver);
	    home.clickRegister();
	    Thread.sleep(3000);    
	    
	}
	
	@When("user enters the mandatory fields by the following")
	public void user_enters_the_mandatory_fields_by_the_following(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		reportGenerator.test= reportGenerator.extent.startTest("Test 101");
		
	   Map<String, String> rows = dataTable.asMap(String.class, String.class);

	   
	   String login = rows.get("login");
	   String password = rows.get("password");
	   String fname = rows.get("firstname");
	   String lname = rows.get("lastname");
	   String email = rows.get("email");
	   
	   RegisterPage register = new RegisterPage(driver);
	   register.toRegister(login, password, fname, lname, email);
	   System.out.println("Details filled");
	   
	   
	   
	}
	
	
	@When("user does not fill the mandatory page")
	public void user_does_not_fill_the_mandatory_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		reportGenerator.test= reportGenerator.extent.startTest("Test 102");
		
		RegisterPage register = new RegisterPage(driver);
		register.toRegister("", "", "", "", "");
		register.clickAdd();
		System.out.println("Details filled");
	    
	}
	
	@When("user enters invalid email")
	public void user_enters_invalid_email(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		Map<String, String> rows = dataTable.asMap(String.class, String.class);
		reportGenerator.test= reportGenerator.extent.startTest("Test 103");

		   
		   String login = rows.get("login");
		   String password = rows.get("password");
		   String fname = rows.get("firstname");
		   String lname = rows.get("lastname");
		   String email = rows.get("email");
		   
		   RegisterPage register = new RegisterPage(driver);
		   register.toRegister(login, password, fname, lname, email);
		   System.out.println("Details filled");
	}
	
	@When("user enters invalid firstname and lastname")
	public void user_enters_invalid_firstname_and_lastname(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		Map<String, String> rows = dataTable.asMap(String.class, String.class);
		reportGenerator.test= reportGenerator.extent.startTest("Test 104");

		   
		   String login = rows.get("login");
		   String password = rows.get("password");
		   String fname = rows.get("firstname");
		   String lname = rows.get("lastname");
		   String email = rows.get("email");
		   
		   RegisterPage register = new RegisterPage(driver);
		   register.toRegister(login, password, fname, lname, email);
		   System.out.println("Details filled");
		
	}
	
	
	@When("the user clicks add")
	public void the_user_clicks_add() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		RegisterPage register = new RegisterPage(driver);
		register.clickAdd();
		
	    System.out.println("User clicks add");
	}
	
	
	
	
	
	
	
	@Then("the system navigates to Home page")
	public void the_system_navigates_to_Home_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    
	    try 
		{
			boolean isErrorVisible = false;
			
			
			try 
			{
				errorElement = driver.findElement(By.xpath("//tr[@class='Error']"));
				if(errorElement.isDisplayed())
				{
					isErrorVisible = true;
				}
			}
			catch(NoSuchElementException e) 
			{
				isErrorVisible = false;
			}
			
			if(isErrorVisible) {
				throw new Exception("Error appeared after clicking add");
			}
			System.out.println("System navigates to Home page");
			test.log(LogStatus.PASS, "Registered successfully");
			Allure.step("Passed");
		}
		catch (Exception e) 
		{
			reportGenerator.driver = driver;
			ScreenshotGenerator.takeScreenshot();
			test.log(LogStatus.FAIL, "Couldn't register successfully");
			Allure.addAttachment("Failed", e.getMessage());
			assertTrue(false);
			
		}
		finally
		{
			driver.quit();
		}
	    
	    
	}
	
	@Then("the system throws error")
	public void the_system_throws_error() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		String myErrMsg = "is required.";
		error1 = driver.findElement(By.xpath("//tr[@class='Error']"));
		String errMessage = error1.getText();
		if(errMessage.contains(myErrMsg)) 
		{
			reportGenerator.test.log(LogStatus.PASS, "Error thrown successfully");
			assertTrue(true);
			Allure.step("Passed");
		}
		else {
			ScreenshotGenerator.driver = driver;
			ScreenshotGenerator.takeScreenshot();
			reportGenerator.test.log(LogStatus.FAIL, "Error not thrown");
			Allure.addAttachment("Failed","Error not thrown");
			assertTrue(false);
			
		}
		System.out.println("The system throws the error");
		driver.quit();
	}
	
	@Then("the system throws error that email is invalid")
	public void the_system_throws_error_that_email_is_invalid() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		String myErrMsg = "Invalid Email";
		error1 = driver.findElement(By.xpath("//tr[@class='Error']"));
		String errMessage = error1.getText();
		if(errMessage.contains(myErrMsg)) 
		{
			reportGenerator.test.log(LogStatus.PASS, "Error thrown successfully");
			assertTrue(true);
			Allure.step("Passed");
		}
		else {
			ScreenshotGenerator.driver = driver;
			ScreenshotGenerator.takeScreenshot();
			reportGenerator.test.log(LogStatus.FAIL, "Error not thrown");
			Allure.addAttachment("Failed", "Error not thrown");
			assertTrue(false);
		}
		System.out.println("The system throws the error");
		driver.quit();
		
	}
	
	@Then("the system throws error that firstname and lastname is invalid")
	public void the_system_throws_error_that_firstname_and_lastname_is_invalid() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("The system throws the error");
		try 
		{
			
			
			String errorName = driver.findElement(By.xpath("//tr[@class='Error']")).getText();
			if((errorName.contains("Invalid Firstname")) && (errorName.contains("Invalid Lastname"))) 
			{
				assertTrue(true);
				Allure.step("Passed");
			}
			else {
				throw new Exception("Firstname and Lastname is invalid");
			}
			
			
		}
		catch (Exception e) 
		{
			reportGenerator.driver = driver;
			ScreenshotGenerator.takeScreenshot();
			test.log(LogStatus.FAIL, "Error not thrown");
			Allure.addAttachment("Failed", e.getMessage());
			assertTrue(false);
			
		}
		finally
		{
			driver.quit();
		}
		
		
		
	}
	
	
	
}
