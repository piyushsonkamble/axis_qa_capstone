package org.page.objects;

import java.io.IOException;

import org.base.config.ConfigProperties;
import org.base.config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductsPage extends NavigationBar{
	public ProductsPage(WebDriver driver) throws IOException {
		super(driver);
		ConfigProperties.initializePropertyFile();
	}
	
	@FindBy(id="search_product")
	WebElement searchBox;
	
	@FindBy(id="submit_search")
	WebElement searchButton;
	
	@FindBy(xpath="//*[text()='All Products']")
	WebElement allProductsLabel;
	
	@FindBy(xpath="//*[text()='Searched Products']")
	WebElement searchedProductsLabel;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	private WebElement continueShoppingButton;
	
	@FindBy(xpath="(//*[text()='View Product'])[1]")
	WebElement viewProduct1Button;
	
	public void verifyProductsPage() {
		Assert.assertTrue(allProductsLabel.isDisplayed());
	}
	
	public void verifySearchProductsLabel() {
		Assert.assertTrue(searchedProductsLabel.isDisplayed());
	}
	
	public void searchProduct(String product) {
		searchBox.sendKeys(product);
		searchButton.click();
	}
	
	public void addAllSearchedItemsToCart() throws InterruptedException {
		int i=1;
		int count = 1;
		Configuration.scrollDown();
		while(i < 19) {
			
			String locator = "(//*[text()='Add to cart'])["+i+"]";
				driver.findElement(By.xpath(locator)).click();
				driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
				i += 2;
				count++;
				if(count % 3 == 0) {
					Configuration.scrollDown();
				}
			}
		}
	
	public void navigateToProductDetailsPage() {
		viewProduct1Button.click();
		
		if(!driver.getCurrentUrl().equalsIgnoreCase("https://automationexercise.com/product_details/1")) {
			viewProduct1Button.click();
		}
	}
}
