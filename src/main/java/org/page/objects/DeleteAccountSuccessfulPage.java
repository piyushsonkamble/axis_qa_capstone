package org.page.objects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DeleteAccountSuccessfulPage extends HomePage {
	public DeleteAccountSuccessfulPage(WebDriver driver) throws IOException {
		super(driver);
	}
	
	@FindBy(xpath="//*[text()='Account Deleted!']")
	WebElement accountDeleteSuccessfulLabel;
	
	@FindBy(xpath="//*[text()='Continue']")
	WebElement accountDeletedContinueButton;
	
	public void verifyAccountDelete() {
		Assert.assertTrue(accountDeleteSuccessfulLabel.isDisplayed());
	}
	
	public void deleteContinue() {
		accountDeletedContinueButton.click();
	}
	
}
