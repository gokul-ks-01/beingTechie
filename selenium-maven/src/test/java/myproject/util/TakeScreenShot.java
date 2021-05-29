package myproject.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {

	public void getScreenshot(WebDriver driver,String fileName ) throws IOException {
		
		String project_path = System.getProperty("user.dir");
		TakesScreenshot screenShotInstance = ((TakesScreenshot) driver );
		File scrshot = screenShotInstance.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrshot, new File(project_path+"\\src\\test\\java\\myproject\\results\\"+fileName+".png"));
	}
}
