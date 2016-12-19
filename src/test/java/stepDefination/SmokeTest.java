package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	
	WebDriver driver = new FirefoxDriver();
	
	@Given("^Open the web page$")
	public void open_the_web_page() throws Throwable {
	    driver.manage().window().maximize();
		driver.get("https://www.udemy.com/");
	}

	@When("^Provide the signing up details$")
	public void provide_the_signing_up_details() throws Throwable {
	   driver.findElement(By.xpath(".//*[@id='udemy']/div[1]/div[2]/div[4]/div[4]/div/require-auth/div/a")).click();
	}

	@When("^Tick the check box$")
	public void tick_the_check_box() throws Throwable {
		Thread.sleep(3000);
	    driver.findElement(By.cssSelector("#id_fullname")).sendKeys("Mickey Jang");
	    driver.findElement(By.cssSelector("#id_email")).sendKeys("manishthapa09@gmail.com");
	    driver.findElement(By.cssSelector("#id_password")).sendKeys("mondeo35");
	    driver.findElement(By.cssSelector(".checkbox-label")).click();
	}

	@Then("^Click the sign up button$")
	public void click_the_sign_up_button() throws Throwable {
	    
	}
	
	@Then("^Close the web page$")
	public void close_the_web_page() throws Throwable {
	    driver.quit();
	}
}
