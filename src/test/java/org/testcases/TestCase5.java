package org.testcases;

import java.io.IOException;

import org.base.config.ConfigProperties;
import org.base.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.page.objects.CartPage;
import org.page.objects.CreateAccountSuccessfulPage;
import org.page.objects.DeleteAccountSuccessfulPage;
import org.page.objects.HomePage;
import org.page.objects.ProductsPage;
import org.page.objects.SignupFormPage;
import org.page.objects.SignupLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase5 extends Configuration{
	WebDriver driver;
	HomePage homeObj;
	CartPage cartObj;
	ProductsPage productsObj;
	SignupLoginPage signupLoginObj;
	SignupFormPage signupFormObj;
	CreateAccountSuccessfulPage createAccObj;
	DeleteAccountSuccessfulPage deleteAccObj;
	String port;
	@Parameters({"Port"})
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException, InterruptedException {
		this.port = Port;
		driver = setup(port);
		homeObj = new HomePage(driver);
		cartObj = new CartPage(driver);
		productsObj = new ProductsPage(driver);
		signupLoginObj = new SignupLoginPage(driver);
		signupFormObj = new SignupFormPage(driver);
		ConfigProperties.initializePropertyFile();
		
		homeObj.navigateToSignupLoginPage();
		
		Thread.sleep(2000);
		closeAd();
		
		signupLoginObj.signUp(port);
		
		Thread.sleep(2000);
		closeAd();
		
		signupFormObj.fillDetails(port);
		signupFormObj.createAccount();
		createAccObj = new CreateAccountSuccessfulPage(driver);
		Thread.sleep(2000);
		closeAd();
		createAccObj.createContinue();
		Thread.sleep(2000);
		closeAd();
		homeObj.userLogOut();
	}
	
	@Test
	public void searchProductCase() throws InterruptedException {
		closeAd();
		homeObj.navigateToProductsPage();
		
		Thread.sleep(2000);
		closeAd();
		
		productsObj.verifyProductsPage();
		productsObj.searchProduct("dress");
		
		Thread.sleep(2000);
		closeAd();
		
		productsObj.verifySearchProductsLabel();
		productsObj.addAllSearchedItemsToCart();
		productsObj.navigateToCartPage();
		
		Thread.sleep(2000);
		closeAd();
		
		cartObj.navigateToSignupLoginPage();
		
		Thread.sleep(2000);
		closeAd();
		
		signupLoginObj.validLogin(port);
		
		Thread.sleep(2000);
		closeAd();
		
		homeObj.navigateToCartPage();
		closeAd();
	}
	
	@AfterMethod
	public void cleanUp() throws InterruptedException, IOException {
		homeObj.deleteAccount();
		deleteAccObj = new DeleteAccountSuccessfulPage(driver);
		
		Thread.sleep(2000);
		closeAd();
		
		deleteAccObj.deleteContinue();
		
		driver.quit();
	}
}
