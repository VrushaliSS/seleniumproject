package testpckg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class CrossTest {
	public WebDriver driver;
  @Parameters("browser")
  @BeforeTest
  public void setup(@Optional("chrome")String browser) throws Exception{
	  if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver.exe");
		  driver =new FirefoxDriver();
	  }
	 else if(browser.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		  driver =new ChromeDriver();
	  }
	  else {
		  System.out.println("Browser is not correct");
	  }
  }
  @Test
  public void afterTest() throws Exception {
	  driver.get("http://demo.guru99.com/V4/");
		//Find user name
		WebElement userName = driver.findElement(By.name("uid"));
		//Fill user name
		userName.sendKeys("guru99");
		//Find password
		WebElement password = driver.findElement(By.name("password"));
		//Fill password
		password.sendKeys("guru99");
  }

}
