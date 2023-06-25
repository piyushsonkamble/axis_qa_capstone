package org.page.objects;

import java.io.IOException;

import org.base.config.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NavigationBar {
	WebDriver driver;
	
	public NavigationBar(WebDriver driver) throws IOException{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		ConfigProperties.initializePropertyFile();

	}
	
	@FindBy(xpath="//*[text()=' Home']")
	WebElement homeButton;
	
	@FindBy(xpath="//*[text()=' Products']")
	WebElement productsButton;
	
	@FindBy(xpath="//*[text()=' Cart']")
	WebElement cartButton;
	
	@FindBy(xpath="//*[text()=' Signup / Login']")
	WebElement signupLoginButton;
	
	@FindBy(xpath="//*[text()=' Logout']")
	WebElement logoutButton;
	
	@FindBy(xpath="//*[text()=' Delete Account']")
	WebElement deleteAccountButton;
	
	@FindBy(xpath="//*[text()=' Test Cases']")
	WebElement testCasesButton;
	
	@FindBy(xpath="//*[text()=' API Testing']")
	WebElement apiTestingButton;
	
	@FindBy(xpath=" Video Tutorials")
	WebElement videoTutorialsButton;
	
	@FindBy(xpath="//*[text()=' Contact us']")
	WebElement contactUsButton;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	WebElement continueShoppingButton;
	
	@FindBy(xpath="//*[text()=' Logged in as ']")
	WebElement loggedInUserLabel;
	
	public void navigateToHomePage() {
		homeButton.click();
		if(!driver.getTitle().equalsIgnoreCase("Automation Exercise")) {
			homeButton.click();
		}
	}
	public void navigateToSignupLoginPage() {
		signupLoginButton.click();
		if(!driver.getTitle().equalsIgnoreCase("Automation Exercise - Signup / Login")) {
			signupLoginButton.click();
		}
	}
	
	public void navigateToProductsPage() {
		productsButton.click();
		if(!driver.getTitle().equalsIgnoreCase("Automation Exercise - All Products")) {
			productsButton.click();
		}
	}
	
	public void navigateToCartPage() {
		cartButton.click();
		if(!driver.getTitle().equalsIgnoreCase("Automation Exercise - Checkout")) {
			cartButton.click();
		}
	}
	
	public void userLogOut() {
		logoutButton.click();
	}
	
	public void navigateToTestCasesPage() {
		testCasesButton.click();
	}
	
	public void navigateToApiTestingPage() {
		apiTestingButton.click();
	}
	
	public void navigateToVideoTutorialsPage() {
		videoTutorialsButton.click();
	}
	
	public void navigateToContactUsPage() {
		contactUsButton.click();
	}
	
	public void verifyUserLogin() {
		Assert.assertTrue(loggedInUserLabel.isDisplayed());
	}
	
	public void deleteAccount() {
		deleteAccountButton.click();
	}
}
