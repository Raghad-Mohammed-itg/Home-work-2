package automationFramework;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import TestPackage.ShoppingCartViewPage;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomeWork2 {
	static String baseUrl = "https://devwcs.frontgate.com/ShoppingCartView";
    static String driverPath = "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe";
    static WebDriver driver ; 
	static ShoppingCartViewPage shoppingCartViewPage;

  @BeforeTest
  public static void launchBrowser(){
	  System.out.println("launching chrome..");
	  System.setProperty("webdriver.chrome.driver", driverPath);

	    driver = new ChromeDriver();
//		driver.get(baseUrl);
//		driver.findElement(By.cssSelector("button#details-button")).click();
//		driver.findElement(By.cssSelector("a#proceed-link")).click();
//		shoppingCartViewPage = new ShoppingCartViewPage(driver);
	      
  }
  @DataProvider
	public String[][] credentials() throws IOException {
	  System.out.println("file path is:  " + new java.io.File("HW.xlsx").getAbsolutePath());
		WriteOnExcel.createExcelData();
		String Path = new java.io.File("HW.xlsx").getAbsolutePath();
		String[][] creddentials = ReadFromExcel.getData(Path,
				"HW2");
		return creddentials;
	}
  
  @Test(dataProvider = "credentials", priority = 2)
	public void credentialsTest(String email, String password, String message) {

		SoftAssert softAssertion = new SoftAssert();

		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
System.out.println("email is:" + email);
		shoppingCartViewPage.clearEmailField();
		shoppingCartViewPage.enterEmail(email);

		

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		shoppingCartViewPage.clearPasswordField();
		shoppingCartViewPage.enterPassword(password);

		
		shoppingCartViewPage.clickSignIn();
		


		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		if (message.equals("valid credentials")) {

			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			Assert.assertFalse(shoppingCartViewPage.checkSignInDiv());

		} else if (message.equals("invalid password")) {

			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			Assert.assertTrue(shoppingCartViewPage.checkPasswordErrorDiv());

		} else {

			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			Assert.assertTrue(shoppingCartViewPage.checkEmailErrorDiv());
		}

	}
 

	

}


