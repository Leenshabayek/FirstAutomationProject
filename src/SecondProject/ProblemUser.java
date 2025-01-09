package SecondProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProblemUser {
	WebDriver driver = new ChromeDriver();
	String SauceDemo = "https://www.saucedemo.com/";
	String UserName = "problem_user";
	String Password = "secret_sauce";

	@BeforeTest()
	public void Before_Test() {
		driver.get(SauceDemo);
		driver.manage().window().maximize();
	}

	@Test (priority = 1)
	public void Login() {
		WebElement UserNameTextbox = driver.findElement(By.id("user-name"));
		WebElement PasswordTextbox = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));
		UserNameTextbox.sendKeys(UserName);
		PasswordTextbox.sendKeys(Password);
		LoginButton.click();
	}

	@Test(priority = 2)
	public void AddToCart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	}

	@Test(priority = 3)

	public void RemoveFromCart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
	}

	@AfterTest
	public void After_test() {
		
	}
}
