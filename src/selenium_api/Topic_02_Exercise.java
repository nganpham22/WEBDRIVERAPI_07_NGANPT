package selenium_api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Exercise {
	WebDriver driver;

	@BeforeClass
	public void BeforeClass() {
		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		// Wait Time = 30
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	// Script 01: Verify URL and Title
	public void Ex_01_Verify_URL_Title() {
		// Step 1 get url
		driver.get("http://live.guru99.com/");
		// Step 2: Get Title url
		String HomePageTitle = driver.getTitle();
		Assert.assertEquals(HomePageTitle, "Home page");
		// Step 3: Click My Account link
		WebElement myAccount = driver.findElement(By.xpath("//div[@class = 'footer']//a[text() = 'My Account']"));
		myAccount.click();
		// Step 4: Click Create an Account button
		driver.findElement(By.xpath("//span[text() = 'Create an Account']")).click();
		// Step 5: Back login page
		driver.navigate().back();
		// Step 6: Validate URL
		String urlLogin = driver.getCurrentUrl();
		Assert.assertEquals(urlLogin, "http://live.guru99.com/index.php/customer/account/login/");
		// Step 7: Forward to create account page
		driver.navigate().forward();
		// Step 8: Validate URL create account page
		String urlCreateAcc = driver.getCurrentUrl();
		Assert.assertEquals(urlCreateAcc, "http://live.guru99.com/index.php/customer/account/create/");
	}

	@Test
	// SCript 02: Login Empty
	public void Ex_02_Login_Empty() {
		// Step 1 get url
		driver.get("http://live.guru99.com/");
		driver.manage().window().maximize();
		// Wait Time = 30
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Step 2: Click My Account link
		driver.findElement(By.xpath("//div[@class = 'footer']//a[text() = 'My Account']")).click();

		// Step 3: Empty username & password
		// Step 4: Click login button
		driver.findElement(By.xpath("//button[@id = 'send2']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Step 05
		// Verify error message for email
		String errMsg_Email = driver.findElement(By.xpath("//div[@id = 'advice-required-entry-email']")).getText();
		Assert.assertEquals(errMsg_Email, "This is a required field.");
		// Verify error message for password
		String errMsg_Pass = driver.findElement(By.xpath("//div[@id = 'advice-required-entry-email']")).getText();
		Assert.assertEquals(errMsg_Pass, "This is a required field.");

	}

	@Test
	// Script 03: Login with Email invalid
	public void Ex_03_Login_Email_Invalid() {
		// Step 01: Get page
		driver.get("http://live.guru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Step 02: Click My Account link
		driver.findElement(By.xpath("//div[@class = 'footer']//a[text() = 'My Account']")).click();
		// Step 03: Enter invalid Email
		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("123434234@12312.123123");
		// Step 04: Click login button
		driver.findElement(By.xpath("//button[@id = 'send2']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Step 05: Verify error message
		String err_mess = driver.findElement(By.xpath("//div[@id = 'advice-validate-email-email']")).getText();
		Assert.assertEquals(err_mess, "Please enter a valid email address. For example johndoe@domain.com.");

	}
	
	@Test
	//Script 04: Login with password less 6 characters
	public void Ex_04_Login_Pass_Less_6chars() {
		//Step 01: Get page 
		driver.get("http://live.guru99.com/");
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Step 02: Click My Account link
		driver.findElement(By.xpath("//div[@class = 'footer']//a[text() = 'My Account']")).click();
		// Step 03: Enter valid Email & invalid Password
		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id = 'pass']")).sendKeys("123");
		// Step 04: click login button
		driver.findElement(By.xpath("//button[@id = 'send2']")).click();
		// Step05: verify error message
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String err_msspass = driver.findElement(By.xpath("//div[@id = 'advice-validate-password-pass']")).getText();
		Assert.assertEquals(err_msspass, "Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test
	// Script 05: Login with pass invalid
	public void Ex_05_Login_Pass_Invalid() {
		// Step 01: Get page
		driver.get("http://live.guru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Step 02: Click My Account link
		driver.findElement(By.xpath("//div[@class = 'footer']//a[text() = 'My Account']")).click();
		// Step 03: Enter valid Email & invalid Password
		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id = 'pass']")).sendKeys("testonline123");
		// Step 04: click login button
		driver.findElement(By.xpath("//button[@id = 'send2']")).click();
		// Step05: verify error message
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String err_msspass = driver.findElement(By.xpath("//span[text() = 'Invalid login or password.']")).getText();
		Assert.assertEquals(err_msspass, "Invalid login or password.");

	}

	@Test
	//Script 06: Create an account
	public void Ex_06_Create_Account() {
		// Step 01: Get page
		driver.get("http://live.guru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Step 02: Click My Account link
		driver.findElement(By.xpath("//div[@class = 'footer']//a[text() = 'My Account']")).click();
		// Step 03: Click Create an button
		driver.findElement(By.xpath("//a[@class = 'button']//span[text() = 'Create an Account']")).click();
		// Step 04: Enter valid info: First Name/ Last Name/ Email Address/ Password/
		// Confirm Password
		driver.findElement(By.xpath("//input[@id = 'firstname']")).sendKeys("Jon");
		driver.findElement(By.xpath("//input[@id = 'middlename']")).sendKeys("G");
		driver.findElement(By.xpath("//input[@id = 'lastname']")).sendKeys("Bush");
		String email = "Jonh" + Rannumber() + "@gmail.com";
		driver.findElement(By.xpath("//input[@id = 'email_address']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("Jon@123");
		driver.findElement(By.xpath("//input[@id = 'confirmation']")).sendKeys("Jon@123");
		// Step 05: Click Register
		driver.findElement(By.xpath("//button[@class = 'button']//span[text() = 'Register']")).click();
		// Step 06: Verify message
		driver.findElement(By.xpath("//span[text() = 'Thank you for registering with Main Website Store.']")).isDisplayed();
		
		// Step 07: logout
		driver.findElement(By.xpath("//span[text() = 'Account' and @class = 'label']")).click();
		driver.findElement(By.xpath("//a[text() = 'Log Out']")).click();
		
		// Verify navigate to Home page
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(), 'This is demo site for')]")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		 //driver.quit();
	}

	public int Rannumber() {
		Random r = new Random();
		int r_number = r.nextInt(9999999);
		System.out.print("Random number = " + r_number);
		return r_number;
	}

}
