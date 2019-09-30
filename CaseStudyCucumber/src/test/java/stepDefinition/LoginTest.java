package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

	WebDriver driver;
	
	@Given("User is on TestMeApp Login Page")
	public void user_is_on_TestMeApp_Login_Page() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	}

	@When("User provides {string} and {string}")
	public void user_provides_and(String username, String pass) {
		driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("Login")).click();
	}

	@Then("Display message Logged-in successfully")
	public void display_message_Logged_in_successfully() {
		System.out.println("Logged in successfully"); 
		driver.findElement(By.xpath("//a[contains(.,'SignOut')]")).click();
		driver.close();
	}
}
