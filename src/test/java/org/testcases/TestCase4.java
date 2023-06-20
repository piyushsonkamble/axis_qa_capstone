package org.testcases;

import java.io.IOException;

import org.base.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.page.objects.CartPage;
import org.page.objects.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase4 extends Configuration{
	WebDriver driver;
	HomePage homeObj;
	CartPage cartObj;
	
	@Parameters({"Port"})
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException {
		driver = setup(Port);
		homeObj = new HomePage(driver);
		cartObj = new CartPage(driver);
	}
	
	@Test
	public void removeItemsTestCase() throws InterruptedException {
		closeAd();
		homeObj.verifyHomePage();
		homeObj.addItemsToCart(5);
		homeObj.navigateToCartPage();
		
		Thread.sleep(2000);
		closeAd();
		
		cartObj.verifyCartPage();
		cartObj.emptyCart();
		cartObj.verifyEmptyCart();
	}
	
	@AfterMethod
	public void closeTest() {
		driver.quit();
	}
}
