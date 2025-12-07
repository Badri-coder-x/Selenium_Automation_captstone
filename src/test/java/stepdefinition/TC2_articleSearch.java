package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

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
import utility.ScreenshotGenerator;
import utility.reportGenerator;

public class TC2_articleSearch extends reportGenerator {
	WebDriver driver;
	WebElement element;
	@Given("user is on the Home page")
	public void user_is_on_the_Home_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver = new EdgeDriver();
        driver.get("http://examples.codecharge.com/Portal/Default.php");
	    System.out.println("The user is on Home page");
	    
	    Thread.sleep(3000);
	    
	}
	
	@When("the user enters a valid keyword {string} in the search field")
	public void the_user_enters_a_valid_keyword_in_the_search_field(String string){
	    // Write code here that turns the phrase above into concrete actions
		reportGenerator.test= reportGenerator.extent.startTest("Test 105");
	    System.out.println("user enters the valid keyword");
	    string  = "club";
	    HomePage home  = new HomePage(driver);
	    home.putKeyword(string);
	    
	    
	}
	
	@When("the user enters an invalid keyword {string} in the search field")
	public void the_user_enters_an_invalid_keyword_in_the_search_field(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("User enters the invalid keyword");
	    reportGenerator.test= reportGenerator.extent.startTest("Test 106");
	    string  = "123456";
	    HomePage home  = new HomePage(driver);
	    home.putKeyword(string);
	    
	    
	}
	
	@When("the user clicks on search button")
	public void the_user_clicks_on_search_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("User clicks the search button");
	    HomePage home  = new HomePage(driver);
	    home.clickArticleSearch();
	}
	
	@Then("the user is directed to SVEC articles page")
	public void the_user_is_directed_to_SVEC_articles_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("The user is navigated to the articles page");
	    
	    
	    try 
	    {
	    	element = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[1]/td"));
		    String str2 = element.getText();
		    System.out.println(str2);
		    reportGenerator.test.log(LogStatus.PASS, "Test case 105 is Pass");
	    	assertTrue(true);
	    	Allure.step("Passed");
	    }
	    catch(Exception e) 
	    {
	    	reportGenerator.driver = driver;
	    	ScreenshotGenerator.takeScreenshot();
	    	reportGenerator.test.log(LogStatus.FAIL, "Test case 105 is fail");
	    	Allure.addAttachment("Failed", e.getMessage());
	    	assertTrue(false);
	    }
	    finally 
	    {
	    	driver.quit();
	    }
	    
	    
	}
	
	@Then("an error message that no elements found is displayed")
	public void an_error_message_that_no_elements_found_is_displayed() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("System throws the error");
	    
	   
	    
	    try 
	    {
	    	String str1 = "No records";
		    element = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td"));
		    String str2 = element.getText();
		    if(str2.contains(str1)) 
		    {
		    	System.out.println(str2);
			    reportGenerator.test.log(LogStatus.PASS, "Test case 105 is Pass");
		    	assertTrue(true);
		    	Allure.step("Passed");
		    }
		    
	    }
	    catch(Exception e) 
	    {
	    	reportGenerator.driver = driver;
	    	ScreenshotGenerator.takeScreenshot();
	    	reportGenerator.test.log(LogStatus.FAIL, "Test case 106 is fail");
	    	Allure.addAttachment("Failed", e.getMessage());
	    	assertTrue(false);
	    }
	    finally 
	    {
	    	driver.quit();
	    }
	    
	}
	
	
}
