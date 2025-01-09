package SecondProject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StandardUser {

	WebDriver driver = new ChromeDriver();
	Random rand = new Random();

	String SauceDemo = "https://www.saucedemo.com/";
	String UserName = "standard_user";
	String Password = "secret_sauce";

	@BeforeTest
	public void Before_test() throws InterruptedException {
		driver.get(SauceDemo);
		driver.manage().window().maximize();
		// driver.manage().window().minimize();
		// driver.manage().window().fullscreen();
	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		WebElement UserNameInputField = driver.findElement(By.id("user-name"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));
		UserNameInputField.sendKeys(UserName);
		Thread.sleep(2000);

		PasswordInputField.sendKeys(Password);
		Thread.sleep(2000);

		LoginButton.click();
		Thread.sleep(2000);

	}

	@Test(priority = 2, enabled = true)
	public void AddToCart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(5000);

	}

	@Test(priority = 3, enabled = true)
	public void RemoveFromCart() throws InterruptedException {
		WebElement Cart = driver.findElement(By.className("shopping_cart_link"));
		Cart.click();
		Thread.sleep(2000);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
		Thread.sleep(2000);
		WebElement ContinueShoppingButton = driver.findElement(By.id("continue-shopping"));
		Thread.sleep(2000);

		ContinueShoppingButton.click();
	}

	@Test(priority = 4, enabled = true)
	public void AddAllToCart() throws InterruptedException {
//		wrong code 
//		driver.findElements(By.className("btn")).get(0).click();; 
//		driver.findElements(By.className("btn")).get(1).click();; 
//		driver.findElements(By.className("btn")).get(2).click();; 
//		driver.findElements(By.className("btn")).get(3).click();; 
//		driver.findElements(By.className("btn")).get(4).click();; 
//		driver.findElements(By.className("btn")).get(5).click();; 

		Thread.sleep(2000);
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i).click();
		}
	}

	@Test(priority = 5, enabled = false)
	public void AddRightItemsToCart() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i += 2) {
			AddToCartButtons.get(i).click();
		}
	}

	@Test(priority = 6, enabled = false)
	public void AddCertainNumberOfItems() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			// if (i==3) { // will add the items with index 0,1,2
			// break;}
			AddToCartButtons.get(i).click();
			if (i == 3) { // will add the items with index 0,1,2,3
				break;
				// ما بزبط اكتب بعد جملة بريك اي اشي
			}
			// if (i==2 || i==0 ) {|| this means OR , && this means AND
			// continue;} بتعمل سكيب عن هاد الايتم وبتكمل عاللي بعده
		}
	}

	@Test(priority = 7, enabled = false)
	public void AddItemsThatStartWithSause() {
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < ItemsNames.size(); i++) {
			System.out.println(ItemsNames.get(i).getText().toUpperCase());// .toLowerCase()
			System.out.println(ItemsNames.get(i).getText().startsWith("Sauce"));// startWith("") returns boolean
			if (ItemsNames.get(i).getText().startsWith("Sauce")) {
				AddToCartButtons.get(i).click();// .get(i) عشان يميز اي عناصر يضيف
// law bdi not to add them i will write continue(); inside {} and let click(); statement outside after {}
			}
		}

	}

	@Test(priority = 8, enabled = false)
	public void AddItemsThatStartWithOutSause() {
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < ItemsNames.size(); i++) {

			if (ItemsNames.get(i).getText().startsWith("Sauce")) {
				continue;
			}
			AddToCartButtons.get(i).click();
		}
	}

	@Test(priority = 9, enabled = false)
	public void AddRandomItem() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		// Math.random() highest value equals 0.99999999999
		int RandomIndex = rand.nextInt(AddToCartButtons.size());
		AddToCartButtons.get(RandomIndex).click();
		System.out.println(RandomIndex);
	
		//System.out.println(Math.random() * AddToCartButtons.size()); // highest returned value less than 6
		//System.out.println(Math.floor(6.5));// returns 6
		//System.out.println(Math.ceil(86.3));// returns 87
		//System.out.println(Math.floor(Math.random() * AddToCartButtons.size()));

		// int RandomIndex = Math.floor(Math.random()*AddToCartButtons.size()); ما بزبط
		// لانه اليمين دبل واليسار انتجر
		// AddToCartButtons.get(RandomIndex).click(); ما بزبط لانه جيت لازم تاخد انتجر
	}
	
	@Test(priority = 10, enabled = true)
	public void ChekoutProcess() throws InterruptedException {
		WebElement ShoppingCart = driver.findElement(By.className("shopping_cart_link"));
		ShoppingCart.click();
		Thread.sleep(2000);

		WebElement CheckoutButton = driver.findElement(By.id("checkout"));
		Thread.sleep(2000);

		CheckoutButton.click();
		
		WebElement FirstNameInput = driver.findElement(By.id("first-name"));
		WebElement LastNameInput = driver.findElement(By.id("last-name"));
		WebElement PostaCodeInput = driver.findElement(By.id("postal-code"));
		WebElement ContinueButton = driver.findElement(By.id("continue"));
		
		String [] FirstName = { "Ahmad","Mohammad","Mahmoud","Ibrahim","Saleh"};
		int RandomFirstName = rand.nextInt(FirstName.length);
		
		String [] LastName = { "Saeed","Saleem","Amer","Mamdouh","Murad"};
		int RandomLastName = rand.nextInt(LastName.length);

		String [] PostalCode = { "12345","67891","14785","52369","15987"};
		int RandomPostalCode = rand.nextInt(PostalCode.length);
		
		FirstNameInput.sendKeys(FirstName[RandomFirstName]);
		Thread.sleep(2000);
		LastNameInput.sendKeys(LastName[RandomLastName]);
		Thread.sleep(2000);
		PostaCodeInput.sendKeys(PostalCode[RandomPostalCode]);
		Thread.sleep(2000);
		ContinueButton.click();
		Thread.sleep(2000);
		WebElement FinishButton = driver.findElement(By.id("finish"));
		Thread.sleep(2000);

		FinishButton.click();
		
	}

	@AfterTest
	public void After_test() {
		driver.quit();
	}
}
