package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCartViewPage {

	WebDriver driver;

	public ShoppingCartViewPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	By emailField = By.cssSelector("input#gwt-sign-in-modal");
	By passwordField = By.cssSelector("input#passwordReset");
	By signInButton = By.cssSelector("button#logonButton");
	By signInDiv = By.cssSelector("div.signIn");
	By passwordErrorDiv = By.cssSelector("span.gwt-InlineHTML");
	By emailErrorDiv = By.cssSelector("span.gwt-InlineHTML");

	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clearEmailField() {
		driver.findElement(emailField).clear();
	}

	public void clearPasswordField() {
		driver.findElement(passwordField).clear();
	}

	public void clickSignIn() {
		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(signInButton)).perform();
	}
	
	public boolean checkSignInDiv() {
		return driver.findElement(signInDiv).isDisplayed();
	}
	
	public boolean checkPasswordErrorDiv() {
		return driver.findElement(passwordErrorDiv).isDisplayed();
	}
	
	public boolean checkEmailErrorDiv() {
		return driver.findElement(emailErrorDiv).isDisplayed();
	}
}
