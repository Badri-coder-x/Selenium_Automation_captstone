package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;

public class ScreenshotGenerator extends reportGenerator {
    static int i=1;
	public static void takeScreenshot() throws IOException 
    {
    	 
    			System.out.println("Taking screenshot");
    			File scrFile;
    			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    			Files.copy(scrFile, new File("C:\\project demo automation\\capstone\\reports\\screenshots\\screenshot"+i+".jpeg"));
    			i++;
    }
}
