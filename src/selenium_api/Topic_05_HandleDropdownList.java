package selenium_api;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;







@Test
public class Topic_05_HandleDropdownList {
	WebDriver driver;
	WebDriverWait waitExplicit;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  waitExplicit = new WebDriverWait(driver, 30); 
	  
  }
  

  public void TC_01_HandleDropdownlist() throws Exception {
	  
	  // Step 01 - Truy cập vào trang: https://daominhdam.github.io/basic-form/index.html
	  driver.get(" https://daominhdam.github.io/basic-form/index.html");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  // Step 02 - Kiểm tra dropdown Job Role 01 không hỗ trợ thuộc tính multi-select
	  Select select = new  Select(driver.findElement(By.xpath("//select[@id =  'job1']")));
	  select.isMultiple();
	  
	  // Step 03 - Chọn giá trị Automation Tester trong dropdown bằng phương thức selectVisible
	  // Step 04 - Kiểm tra giá trị đã được chọn thành công
	  
	 select.selectByVisibleText("Automation Tester");
	 Assert.assertEquals(select.getFirstSelectedOption().getText(), "Automation Tester");
	 Thread.sleep(3000);
	  
	 // Step 05 - Chọn giá trị Manual Tester trong dropdown bằng phương thức selectValue
	//	Step 06 - Kiểm tra giá trị đã được chọn thành công
	 select.selectByValue("manual");
	 Assert.assertEquals(select.getFirstSelectedOption().getText(), "Manual Tester");
	 
	 // Step 07 - Chọn giá trị Mobile Tester trong dropdown bằng phương thức selectIndex
	//	Step 08 - Kiểm tra giá trị đã được chọn thành công
	 select.selectByIndex(3);
	 Assert.assertEquals(select.getFirstSelectedOption().getText(), "Mobile Tester");
	 
	 // Step 09 - Kiểm tra dropdown có đủ 5 giá trị
	 //Lấy ra số phần tử của dropdown
	 Assert.assertEquals(select.getOptions().size(), 5);

  }
  
  @Test
  public void TC_02_JqueryDropdown() throws Exception {
	  
	  // Step 01 - Truy cập vào link dưới
	  driver.get(" http://jqueryui.com/resources/demos/selectmenu/default.html");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  // Step 02 - Chọn item cuối cùng: số 19
	  selectItemInCustomDropdown("//span[@id='number-button']", "/ul[@id = 'number-menu']//li[@class = 'ui-menu-item']//div", "19");
	  
	  // Step 03 - Kiểm tra item đã được chọn thành công
	  Assert.assertTrue(driver.findElement(By.xpath("//span[@id='number-button']//span[@class = 'ui-selectmenu-text' and text() = '19']")).isDisplayed());
	   Thread.sleep(3000);
  }
  

  public void selectItemInCustomDropdown(String parenXpath, String childXpath, String expectedItem) {
	  // click vào dropdown
	  WebElement element = driver.findElement(By.xpath(parenXpath));
	  element.click();
	  
	  //Danh sách phần tử
	  List <WebElement> childList = driver.findElements(By.xpath(childXpath));
	  
	  //Đợi hiển thị tất cả các phần tử
	  waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));
	  
	  for(WebElement child: childList) {
		  
		  String textItem = child.getText();
		  System.out.println("Text in Dropdown = " +textItem);
		  
		  if(textItem.equals(expectedItem)) {
			  child.click();
			  break;
		  }
	  }
	  
	  
	  
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
