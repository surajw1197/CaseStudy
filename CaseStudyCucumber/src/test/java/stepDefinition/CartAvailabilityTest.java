package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartAvailabilityTest {
	WebDriver driver;
	@Given("User is registered on testmeApp")
	public void user_is_registered_on_testmeApp() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		driver.findElement(By.name("userName")).sendKeys("suraj0024");
		driver.findElement(By.name("password")).sendKeys("suraj0024");
		driver.findElement(By.name("Login")).click();
	}

	@When("User searches for the product like headphone")
	public void user_searches_for_the_product_like_headphone() {

		Actions act1 =new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'All\n" + 
				"										Categories')]"))).click().pause(1000).perform();
		act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"))).click().pause(1000).perform();
		act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Head Phone')]"))).click().pause(1000).perform();
	}

	@When("try to process the payment without adding any item in the cart")
	public void try_to_process_the_payment_without_adding_any_item_in_the_cart() {
		String menu=driver.findElement(By.className("shop-menu")).getText();
		Assert.assertFalse(menu.contains("Cart"));

	}

	@Then("TestMeApp doesnt display the cart icon")
	public void testmeapp_doesnt_display_the_cart_icon()
	{
		driver.findElement(By.xpath("//a[contains(.,'Add to cart')]")).click();
		String menu=driver.findElement(By.className("shop-menu")).getText();
		Assert.assertTrue(menu.contains("Cart"));
		System.out.println("Item not displayed");
		driver.close();

	}


}
