package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class checkCalculator {
	
	WebDriver driver ;
	
	@Given("user have opened the url")
	public void open_url() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver() ;
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		driver.manage().window().maximize();
	}
	@And("user enter {int} in field1")
	public void enter_integer1(int arg) {
		System.out.println("value 1" +arg);
		  
	} 
	@And("user enter {int} in field2")
	public void enter_integer2(int arg) {
		System.out.println("value 2" +arg);
		  
	} 
	
	@When ("I Press the button to calculate")
	public void click_calculate_button () {
	  System.out.println("calculting");
	} 
	@Then ("I check the result with {int}")
	public void then_i_click_on_result(int arg) { 
	  System.out.println("sum is"+arg);
	}
	@And("if it is same mark it as Pass and if not same mark it as Failed")
	public void mark_pass_or_fail() { 
		  System.out.println("result");
	}
}
