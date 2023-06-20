package org.page.objects;

import java.io.IOException;

import org.base.config.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductDetailsPage extends HomePage{
	public ProductDetailsPage(WebDriver driver) throws IOException {
		super(driver);
		ConfigProperties.initializePropertyFile();
	}
	
	@FindBy(xpath="//*[text()='Write Your Review']")
	WebElement writeReviewLabel;
	
	@FindBy(id="name")
	WebElement reviewNameField;
	
	@FindBy(id="email")
	WebElement reviewEmailField;
	
	@FindBy(id="review")
	WebElement reviewTextBox;
	
	@FindBy(id="button-review")
	WebElement reviewSubmitButton;
	
	@FindBy(xpath="//*[text()='Thank you for your review.']")
	WebElement reviewThankYouLabel;
	
	public void verifyWriteReviewLabel() {
		Assert.assertTrue(writeReviewLabel.isDisplayed());
	}
	
	public void writeReview() {
		reviewNameField.sendKeys("example");
		reviewEmailField.sendKeys("example@123.com");
		reviewTextBox.sendKeys("Good Product");
		reviewSubmitButton.click();
	}
	
	public void verifySuccessfulReview() {
		Assert.assertTrue(reviewThankYouLabel.isDisplayed());
	}
	
	
	
}
