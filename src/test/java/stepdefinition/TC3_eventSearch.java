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
import pageObjects.EventPage;
import pageObjects.HomePage;
import utility.ScreenshotGenerator;
import utility.reportGenerator;

public class TC3_eventSearch extends reportGenerator {
	WebDriver driver;
	WebElement element;
	@Given("user is on the event page")
	public void user_is_on_the_event_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver = new EdgeDriver();
        driver.get("http://examples.codecharge.com/Portal/Default.php");
		System.out.println("User is on the Event page");
	    HomePage home = new HomePage(driver);
	    home.clickEvent();
	    Thread.sleep(3000); 
	    
	}
	
	@When("the user enters a valid keyword {string} in the event search field")
	public void the_user_enters_a_valid_keyword_in_the_event_search_field(String string) {
	    // Write code here that turns the phrase above into concrete actions
		reportGenerator.test= reportGenerator.extent.startTest("Test 107");
		string = "Problems";
		System.out.println("User enters valid keyword");
		EventPage event = new EventPage(driver);
		event.putKeyword(string);
	}
	
	@When("the user enters a invalid keyword {string} in the event search field")
	public void the_user_enters_a_invalid_keyword_in_the_event_search_field(String string) {
	    // Write code here that turns the phrase above into concrete actions
		reportGenerator.test= reportGenerator.extent.startTest("Test 108");
		string = "123456";
		System.out.println("User enters invalid keyword");
		EventPage event = new EventPage(driver);
		event.putKeyword(string);
	    
	}
	
	@When("the user clicks on event search button")
	public void the_user_clicks_on_event_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User clicks search button");
		EventPage event = new EventPage(driver);
		event.clickEventSearch();
		
	    
	}
	
	@Then("the user is directed to SVEC event page")
	public void the_user_is_directed_to_SVEC_event_page() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		String str1 = "Presenter";
		System.out.println("User directed to the SVEC event page");
		Thread.sleep(3000);
		element = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[1]/th[3]/a"));
		
		String str2 = element.getText();
		System.out.println(str2);
		if(str2.contains(str1)) 
	    {
	    	reportGenerator.test.log(LogStatus.PASS, "Test case 107 is Pass");
	    	assertTrue(true);
	    	Allure.step("Passed");
	    }
	    else {
	    	reportGenerator.driver = driver;
	    	ScreenshotGenerator.takeScreenshot();
	    	reportGenerator.test.log(LogStatus.FAIL, "Test case 107 is fail");
	    	assertTrue(false);
	    	
	    }
		driver.quit();
	    
	}
	
	
	@Then("an error message that no events found is shown")
	public void an_error_message_that_no_events_found_is_shown() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("System throws an error");
	    String str1 = "No records";
	    Thread.sleep(2000);
	    element = driver.findElement(By.xpath("//tr[@class = 'NoRecords']"));
	    String str2 = element.getText();
	    System.out.println(str2);
	    if(str2.contains(str1)) 
	    {
	    	reportGenerator.test.log(LogStatus.PASS, "Test case 108 is Pass");
	    	assertTrue(true);
	    	Allure.step("Passed");
	    }
	    else 
	    {
	    	reportGenerator.driver = driver;
	    	ScreenshotGenerator.takeScreenshot();
	    	reportGenerator.test.log(LogStatus.FAIL, "Test case 108 is fail");
	    	Allure.addAttachment("Failed", "Failed");
	    	assertTrue(false);
	    }
	    
	    driver.quit();
	}
	
	
	
	
}
