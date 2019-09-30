package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationTest {
	WebDriver driver;
	@Given("user is on home page")
	public void user_is_on_home_page() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	}

	@When("user clicks on signup")
	public void user_clicks_on_signup() {
		driver.findElement(By.xpath("//a[contains(.,'SignUp')]")).click();
	}

	@When("user enter the registration creds")
	public void user_enter_the_registration_creds(io.cucumber.datatable.DataTable usercrdentials) {
		List<String> data=usercrdentials.asList();
		driver.findElement(By.id("userName")).sendKeys(data.get(0));
		driver.findElement(By.id("firstName")).sendKeys(data.get(1));
		driver.findElement(By.id("lastName")).sendKeys(data.get(2));
		driver.findElement(By.id("password")).sendKeys(data.get(3));
		driver.findElement(By.id("pass_confirmation")).sendKeys(data.get(4));
		driver.findElement(By.xpath("//input[@value='"+data.get(5)+"']")).click();
		driver.findElement(By.id("emailAddress")).sendKeys(data.get(6));
		driver.findElement(By.id("mobileNumber")).sendKeys(data.get(7));

		//for date
		driver.findElement(By.xpath("//img[@src='images/calendar.png']")).click();
		Select months = new Select(driver.findElement(By.className("ui-datepicker-month")));
		months.selectByVisibleText(data.get(8));
		Select ye = new Select(driver.findElement(By.className("ui-datepicker-year")));
		ye.selectByVisibleText(data.get(10));
		driver.findElement(By.linkText(data.get(9))).click();


		driver.findElement(By.id("address")).sendKeys(data.get(11));
		Select secquestion = new Select(driver.findElement(By.id("securityQuestion")));
		secquestion.selectByVisibleText(data.get(12));
		driver.findElement(By.id("answer")).sendKeys(data.get(13));

		driver.findElement(By.name("Submit")).click();
	}

	@Then("Registration successfull")
	public void registration_successfull() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Successfull");
	}
}
