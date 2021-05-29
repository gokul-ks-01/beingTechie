package myproject.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IMethodInstance;
import org.testng.ITest;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;

import io.github.bonigarcia.wdm.WebDriverManager;
import myproject.data.ReadPropertiesFile;
import myproject.setorder.TestCaseMethodInterceptor;
import myproject.util.TestReport;
@Listeners(
	    {
	    	TestCaseMethodInterceptor.class,
	    	TestReport.class
	        
	    }
	)

public class TestCase   implements ITest {
	WebDriver driver ;
	static String url ;
	private String first_field ;
	private String second_field ;
	private String testName;
	private int order ;
	
	@BeforeSuite
	public void beforeSuiteMethod() throws IOException, DocumentException  {
		url = ReadPropertiesFile.getPropertyValue("URL");
		
		System.out.println("BeforeSuite");
		
	}
	@BeforeTest
	public void  beforeTestMethod() {
		System.out.println("BeforeTest");
	}
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("BeforeClass");
	}
	@BeforeMethod
	public void beforeMethod() throws DocumentException {
		
		  WebDriverManager.chromedriver().setup(); 
		  driver =new ChromeDriver();
		  TestReport.onCustomAction("started chrome session");
		  driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		 System.out.println("beforeMethod");
	}
	
	@Test
	public void testCaseMethod() throws DocumentException {
		driver.get(url); 
		TestReport.onCustomAction("Opened url >>" +url);
		driver.manage().window().maximize();
		TestReport.onCustomAction("inputs for the test : "+(first_field +"----"+second_field));
		System.out.println(first_field +"----"+second_field);
		System.out.println("test");
		 driver.quit(); 
		 TestReport.onCustomAction("Chrome session ended");
	}
	
	@AfterMethod
	public void afterMethod() throws DocumentException {
		System.out.println("afterMethod");
		
		
	}
	@AfterClass
	public void afterClassMethod() {
		System.out.println("afterclass");
	}
	@AfterTest
	public void afterTestMethod() {
		System.out.println("afterTest");
	}
	@AfterSuite
	public void afterSuiteMethod() throws FileNotFoundException, DocumentException {
		System.out.println("afterSuite");
	}
	
	public String getSecond_field() {
		return second_field;
	}

	public void setSecond_field(String second_field) {
		this.second_field = second_field;
	}

	public String getFirst_field() {
		return first_field;
	}

	public void setFirst_field(String first_field) {
		this.first_field = first_field;
	}


	public String getTestName() { 
		  return testName;
	}
	
	
	public void setTestName(String testName) {
		this.testName = testName; 
	}
	 
	public int getOrder() {
		return order;
	}
	public void setOrder(int i) {
		this.order = i;
	}
	

}

