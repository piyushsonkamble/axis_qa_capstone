package org.page.objects;

import java.io.IOException;

import org.base.config.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class SignupLoginPage extends HomePage{
	WebDriver driver;
	Actions action;
	
	public SignupLoginPage(WebDriver driver) throws IOException{
		super(driver);
		ConfigProperties.initializePropertyFile();
	}
	
	@FindBy(xpath="//*[text()='Login to your account']")
	WebElement loginLabel;
	
	@FindBy(xpath="(//*[@name='email'])[1]")
	WebElement loginEmailField;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement loginPasswordField;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[text()='Your email or password is incorrect!']")
	WebElement invalidCredentialsLabel;
	
	@FindBy(xpath="//*[text()='New User Signup!']")
	WebElement signupLabel;
	
	@FindBy(xpath="//*[@name='name']")
	WebElement signupNameField;
	
	@FindBy(xpath="(//*[@name='email'])[2]")
	WebElement signupEmailField;
	
	@FindBy(xpath="//button[text()='Signup']")
	WebElement signupButton;
	
	String wrongUsername = "example@123";
	String wrongPassword = "qwertyu";
	
	String Name;
	String Email;
	String Password;

	@Parameters({"Port"})
	public void getDetails(String Port) {
		if(Port.equalsIgnoreCase("5555")) {
			Name = ConfigProperties.property.getProperty("MName");
			Email = ConfigProperties.property.getProperty("MEmail");
			Password = ConfigProperties.property.getProperty("MPassword");
		}
		else {
			Name = ConfigProperties.property.getProperty("FName");
			Email = ConfigProperties.property.getProperty("FEmail");
			Password = ConfigProperties.property.getProperty("FPassword");
		}
		
	}
	
	public void verifyLoginLabel() {
		Assert.assertTrue(loginLabel.isDisplayed());
	}
	
	public void verifySignupLabel() {
		Assert.assertTrue(signupLabel.isDisplayed());
	}
	
	@Parameters({"Port"})
	public void validLogin(String Port) {
		getDetails(Port);
		loginEmailField.sendKeys(Email);
		loginPasswordField.sendKeys(Password);
		loginButton.click();
	}
	
	public void invalidLogin() {
		loginEmailField.sendKeys(wrongUsername);
		loginPasswordField.sendKeys(wrongPassword);
		loginButton.click();
	}
	
	@Parameters({"Port"})
	public void signUp(String Port) {
		getDetails(Port);
		signupNameField.sendKeys(Name);
		signupEmailField.sendKeys(Email);
		signupButton.click();
	}
	
	public void verifyInvalidLogin() {
		Assert.assertTrue(invalidCredentialsLabel.isDisplayed());
	}
	
}
