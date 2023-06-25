package org.page.objects;

import java.io.IOException;

import org.base.config.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends NavigationBar {
	public CartPage(WebDriver driver) throws IOException {
		super(driver);
		ConfigProperties.initializePropertyFile();
	}
	
	@FindBy(xpath="//*[text()='Shopping Cart']")
	WebElement shoppingCartLabel;

	@FindBy(xpath = "//b[text()='Cart is empty!']")
	WebElement emptyCartLabel;

	public void verifyCartPage() {
		Assert.assertTrue(shoppingCartLabel.isDisplayed());
	}
	
	public void verifyEmptyCart() {
		Assert.assertTrue(emptyCartLabel.isDisplayed());
	}

	public void emptyCart() throws InterruptedException {
		int i=1;
		while (!emptyCartLabel.isDisplayed()) {
			String path = "(//*[@class='cart_quantity_delete'])["+i+"]";
			driver.findElement(By.xpath(path)).click();
			Thread.sleep(500);
		}
		
	}
}
