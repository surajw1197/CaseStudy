package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CaseStudyTest 
{
	WebDriver driver;

	@Given("user has logged in TestmeApp")
	public void user_has_logged_in_TestmeApp() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		driver.findElement(By.name("userName")).sendKeys("suraj0024");
		driver.findElement(By.name("password")).sendKeys("suraj0024");
		driver.findElement(By.name("Login")).click();
	}

	@When("user searches for a product by typing four characters")
	public void user_searches_for_a_product_by_typing_four_characters() {
		WebElement serachBox=driver.findElement(By.xpath("//input[@type='text']"));
		Actions act=new Actions(driver);
		act.keyDown(serachBox, Keys.SHIFT);
		act.sendKeys("h").pause(300).sendKeys("e").pause(300).sendKeys("a").pause(300).sendKeys("d").build().perform();
		String str=driver.findElement(By.xpath("(//div[contains(.,'Headphone')])[4]")).getText();
		boolean flag=str.toLowerCase().contains("head");
		if(flag==true) {
			System.out.println("Product Suggestions are avilable");
		}
		else System.out.println("There is no product available with name" +str);


	}

	@Then("user gets all the suggestions")
	public void user_gets_all_the_suggestions() {
		driver.close();

	}

}
