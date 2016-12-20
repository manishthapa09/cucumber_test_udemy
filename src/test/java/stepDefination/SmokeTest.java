package stepDefination;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

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

	@Given("^I open the web page$")
	public void i_open_the_web_page() throws Throwable {
		driver.manage().window().maximize();
		driver.get("https://www.udemy.com/");
	}

	@When("^I click on the Login button$")
	public void i_click_on_the_Login_button() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='udemy']/div[1]/div[2]/div[4]/div[3]/div/require-auth/div/a")).click();
	}

	@When("^I provide the email and password$")
	public void i_provide_the_email_and_password() throws Throwable {

		// Need to go back to console window and pick one option
		System.out.println("Please choose the mode of login:-");
		System.out.println("Type 1 for Facebook");
		System.out.println("Type 2 for Google");
		System.out.println("Type 3 for Email");

		Scanner picked_opt = new Scanner(System.in);

		int val = Integer.parseInt(picked_opt.next());

		// For facebook login need to pick 1
		if (val == 1) {
			driver.findElement(By.cssSelector(".social-btn.facebook-btn.js-facebook-btn.shadowed-btn.fxac")).click();
			driver.findElement(By.cssSelector("#email")).sendKeys("manishthapa09@gmail.com");
			driver.findElement(By.cssSelector("#pass")).sendKeys("manish35sonika");

			// For google login need to pick 2
		} else if (val == 2) {
			driver.findElement(By.cssSelector(".social-btn.google-btn.shadowed-btn.fxac")).click();
			driver.quit();
			Thread.sleep(2000);

			// on click new page is getting popped up
			WebDriver google_drv = new FirefoxDriver();
			google_drv.get(
					"https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?client_id%3D700206021005-fntgseouuq3ah1jtko8ejh2vckk8sbn6.apps.googleusercontent.com%26redirect_uri%3Dpostmessage%26response_type%3Dcode%2Btoken%2Bid_token%2Bgsession%26scope%3Dhttps://www.googleapis.com/auth/plus.login%2Bhttps://www.googleapis.com/auth/plus.profile.emails.read%26request_visible_actions%3Dhttp://schemas.google.com/AddActivity%26cookie_policy%3Dsingle_host_origin%26include_granted_scopes%3Dtrue%26proxy%3Doauth2relay561264608%26origin%3Dhttps://www.udemy.com%26gsiwebsdk%3D1%26state%3D919925749%257C0.2312826%26%26jsh%3Dm;/_/scs/apps-static/_/js/k%253Doz.gapi.en_GB.XuYsDC2AtZY.O/m%253D__features__/am%253DAQ/rt%253Dj/d%253D1/rs%253DAGLTcCO6XqhQq3v3P0O-Of1mcz9YxeJd5Q%26from_login%3D1%26as%3D-4ef78c01424ac84c&oauth=1&sarp=1&scc=1#identifier");
			google_drv.findElement(By.cssSelector("#Email")).clear();
			google_drv.findElement(By.cssSelector("#Email")).sendKeys("manitechsoln@gmail.com");
			google_drv.findElement(By.cssSelector("#next")).click();
			
			Thread.sleep(1000);
			WebDriver google_drv_pass = new FirefoxDriver();
			google_drv_pass.get(
					"https://accounts.google.com/ServiceLogin?passive=1209600&continue=https://accounts.google.com/o/oauth2/auth?client_id%3D700206021005-fntgseouuq3ah1jtko8ejh2vckk8sbn6.apps.googleusercontent.com%26redirect_uri%3Dpostmessage%26response_type%3Dcode%2Btoken%2Bid_token%2Bgsession%26scope%3Dhttps://www.googleapis.com/auth/plus.login%2Bhttps://www.googleapis.com/auth/plus.profile.emails.read%26request_visible_actions%3Dhttp://schemas.google.com/AddActivity%26cookie_policy%3Dsingle_host_origin%26include_granted_scopes%3Dtrue%26proxy%3Doauth2relay561264608%26origin%3Dhttps://www.udemy.com%26gsiwebsdk%3D1%26state%3D919925749%257C0.3109176331%26%26jsh%3Dm;/_/scs/apps-static/_/js/k%253Doz.gapi.en_GB.XuYsDC2AtZY.O/m%253D__features__/am%253DAQ/rt%253Dj/d%253D1/rs%253DAGLTcCO6XqhQq3v3P0O-Of1mcz9YxeJd5Q%26from_login%3D1%26as%3D-67f4c0d3180aa645&oauth=1&sarp=1&scc=1#password");
			google_drv_pass.findElement(By.cssSelector("#Passwd")).clear();
			google_drv_pass.findElement(By.id("Passwd")).sendKeys("mondeo35");
			google_drv_pass.findElement(By.cssSelector("#signIn")).click();
		}

		// For just email login need to pick 3
		else {
			driver.findElement(By.cssSelector("#id_email")).sendKeys("manishthapa09@gmail.com");
			driver.findElement(By.cssSelector("#id_password")).sendKeys("mondeo35");
		}
	}

	@Then("^I click the login button$")
	public void i_click_the_login_button() throws Throwable {
		driver.findElement(By.cssSelector("#submit-id-submit")).click();
	}
}
