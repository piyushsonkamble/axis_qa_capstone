package org.page.objects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateAccountSuccessfulPage extends HomePage{
	public CreateAccountSuccessfulPage(WebDriver driver) throws IOException {
		super(driver);
	}
	
	@FindBy(xpath="//*[text()='Account Created!']")
	WebElement accountCreatedSuccessfulLabel;
	
	@FindBy(xpath="//*[text()='Continue']")
	WebElement accountCreatedContinueButton;
	
	public void verifyAccountCreation() {
		Assert.assertTrue(accountCreatedSuccessfulLabel.isDisplayed());
	}
	
	public void createContinue() {
		accountCreatedContinueButton.click();
		if(accountCreatedContinueButton.isDisplayed()) {
			accountCreatedContinueButton.click();
		}
	}
}
