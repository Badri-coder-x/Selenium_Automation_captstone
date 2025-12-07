package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
public class reportGenerator {
	public static ExtentReports extent;
    public static ExtentTest test;  
    public static WebDriver driver;
    static int i=1;
    
    @BeforeSuite
    public void beforeSuite() 
    {
    	extent = new ExtentReports("C:\\project demo automation\\capstone\\reports\\report.html", true);
    }
    
    @AfterSuite
    public void afterSuite()
    {
    	extent.flush();
    }
    
    
   
    
  
}
