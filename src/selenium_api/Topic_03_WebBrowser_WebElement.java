package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_WebBrowser_WebElement {
	//Declare a driver
	WebDriver driver;
	//Enabled Element
	String email = "//input[@id='mail']";
	String AgeUnder18 = "//input[@id='under_18']";
	String Education = "//textarea[@id='edu']";
	String JobRole01 = "//select[@id='job1']";
	String InterestDev = "//input[@id='development']";
	String Slide01 = "//input[@id='slider-1']";
	String ButtonEnabled = "//button[@id='button-enabled']";
	//Disabled Element
	String Password = "//input[@id='password']";
	String DisabledRadio = "//label[text() = 'Radiobutton is disabled']";
	String Biography = "//textarea[@id = 'bio']";
	String JobRole02 = "//option[text() = 'Dropdown is disabled']";
	String InterestDisabled = "//label[text() = 'Checkbox is disabled']";
	String Slide02 = "//input[@id = 'slider-2']";
	String ButtonDisabled = "//button[@id='button-enabled']";
	
	@BeforeClass
  public void beforeClass() {
		driver = new FirefoxDriver();
			
	  }
	@Test(enabled = false)
  public void Exercise_01() {
		//Verify element display on website
		//Step 01
		//Open URL http://daominhdam.890m.com/
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Step 02
		//Verify Email/Age(Under 18)/Education
		IsDisplay(email);
		IsDisplay(AgeUnder18);
		IsDisplay(Education);
		//Step 03
		//Enter Automation Testing into Email/Education and select Age = Under 18
		Enter("Automation Testing", email);
		Enter("Automation Testing", Education);
		Click(AgeUnder18);
		//Finish ^^
   }
	@Test(enabled = true)
  public void Exercise_02() {
		//VERIFY ENABLE AND DISABLE
		//Step 01
		//Open URL http://daominhdam.890m.com/
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Step 02 +03 + 04
		//Verify Enable element
		IsEnabled(email);
		IsEnabled(AgeUnder18);
		IsEnabled(Education);
		IsEnabled(JobRole01);
		IsEnabled(InterestDev);
		IsEnabled(Slide01);
		IsEnabled(ButtonEnabled);
		
		//Verify Enable element
		IsDisabled(Password);
		IsDisabled(DisabledRadio);
		IsDisabled(Biography);
		IsDisabled(JobRole02);
		IsDisabled(InterestDisabled);
		IsDisabled(Slide02);
		IsDisabled(ButtonDisabled);
	}
	@Test(enabled = true)
	public void Exercise_03() {
		//VERIFY SELECTED ELEMENT
		//Step 1
		//Open URL http://daominhdam.890m.com/
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Step 02
		//Click Age/ Interest Dev
		Click(AgeUnder18);
		Click(InterestDev);
		//Step 03+04
		//Verify and click again if not yet selected
		IsSelected(AgeUnder18);
		IsSelected(InterestDev);
		}
	
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public void IsDisplay(String locator ) {
	  driver.findElement(By.xpath(locator)).isDisplayed();
  }
  
  public void Enter(String text,String locator) {
	  driver.findElement(By.xpath(locator)).sendKeys(text);
  }
  public void Click(String locator) {
	  driver.findElement(By.xpath(locator)).click();
  }
  public void IsEnabled(String locator ) {
	  if(driver.findElement(By.xpath(locator)).isEnabled())
		  System.out.println("Element is enabled");
  }
  public void IsDisabled(String locator ) {
	  if(!(driver.findElement(By.xpath(locator)).isEnabled()))
		  System.out.println("Element is disabled");
  }
  public void IsSelected(String locator ) {
	  if(driver.findElement(By.xpath(locator)).isSelected())
		  System.out.println("Element is selected");
	  else driver.findElement(By.xpath(locator)).click();
  }
}