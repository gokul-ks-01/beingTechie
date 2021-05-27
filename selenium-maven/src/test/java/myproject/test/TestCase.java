package myproject.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IMethodInstance;
import org.testng.ITest;
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
import io.github.bonigarcia.wdm.WebDriverManager;
import myproject.data.ReadPropertiesFile;
import myproject.setorder.TestCaseMethodInterceptor;
@Listeners(
	    {
	    	TestCaseMethodInterceptor.class
	        
	    }
	)

public class TestCase {
	WebDriver driver ;
	static String url ;
	private String first_field ;
	private String second_field ;
	private String testName;
	private int order ;
	
	@BeforeSuite
	public void beforeSuiteMethod() throws IOException  {
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
	public void beforeMethod() {
		
		 WebDriverManager.chromedriver().setup(); 
		 driver =new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS) ;
		
		 System.out.println("beforeMethod");
	}
	
	@Test
	public void testCaseMethod() {
		driver.get(url);
		 driver.manage().window().maximize();
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 60);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "at-cv-lightbox-close"))).click();
		 * driver.findElement(By.id("sum1")).sendKeys(first_field);
		 * driver.findElement(By.id("sum2")).sendKeys(second_field);
		 */
		System.out.println(first_field +"----"+second_field);
		System.out.println("test");
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
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
	public void afterSuiteMethod() {
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

