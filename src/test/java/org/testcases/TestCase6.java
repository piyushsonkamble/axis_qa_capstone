package org.testcases;

import java.io.IOException;

import org.base.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.page.objects.HomePage;
import org.page.objects.ProductDetailsPage;
import org.page.objects.ProductsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase6 extends Configuration{
	WebDriver driver;
	HomePage homeObj;
	ProductsPage productsObj;
	ProductDetailsPage productViewObj;
	
	@Parameters({"Port"})
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException {
		driver = setup(Port);
		homeObj = new HomePage(driver);
		productsObj = new ProductsPage(driver);
		productViewObj = new ProductDetailsPage(driver);
	}
	
	@Test
	public void writeReviewTestCase() throws InterruptedException {
		homeObj.navigateToProductsPage();
		
		Thread.sleep(2000);
		closeAd();
		
		productsObj.navigateToProductDetailsPage();
		
		Thread.sleep(2000);
		closeAd();
		
		productViewObj.verifyWriteReviewLabel();
		productViewObj.writeReview();
		productViewObj.verifySuccessfulReview();
	}
	
	@AfterMethod
	public void closeTest() {
		driver.quit();
	}
}
