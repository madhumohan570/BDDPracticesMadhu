package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
	
	//initiate a browser
		static WebDriver driver;
	
	@Given ("User is on login page")
	public void user_is_on_login_page() {
	
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://demo.cyclos.org/ui/login");
	}

	@When("User enters correct username and password")
	public void user_enters_correct_username_and_password() {
	
	    
	  driver.findElement(By.xpath("//input[@placeholder='User']")).sendKeys("demo");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("1234");
		
	}



	@When("Clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
	}

	@Then("User is navigated to home page")
	public void user_is_navigated_to_home_page() {
		
		Assert.assertTrue(driver.findElements(By.xpath("(//div[@class='title-text flex-grow-1 d-flex align-items-center'])[1]")).size()>0,"User is navigated to home page");
		
	}

	@Then("Close the browser")
	public void close_the_browser() {
	    driver.close();
	}

	@Then("User is performing payment")
	public void user_is_performing_payment() {
		driver.findElement(By.xpath("(//div[@class='quick-access-text'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@class='btn btn-icon ml-2']")).click();
		driver.findElement(By.xpath("//a[contains(text(),\"Active Walking\")]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("id_3")).sendKeys("100");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("id_4")).click();
		driver.findElement(By.id("id_4_direct")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),\"Confirm\")]")).click();
		
	}
	
	@Then("User is navigated to successful page")
	public void user_is_navigated_to_successful_page () {
		Assert.assertTrue(driver.findElements(By.xpath("//div[contains(text(),\"The payment was successfully processed\")]")).size()>0,"User is navigated to successful page");
		
	}

}
