package org.testcases;

import java.io.IOException;

import org.base.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.page.objects.CartPage;
import org.page.objects.DeleteAccountSuccessfulPage;
import org.page.objects.HomePage;
import org.page.objects.ProductsPage;
import org.page.objects.SignupLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase3 extends Configuration {
	WebDriver driver;
	HomePage homeObj;
	ProductsPage productsObj;
	CartPage cartObj;
	SignupLoginPage signupLoginObj;
	DeleteAccountSuccessfulPage deleteAccObj;
	@Parameters({"Port"})
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException {
		driver = setup(Port);
		homeObj = new HomePage(driver);
		productsObj = new ProductsPage(driver);
		cartObj = new CartPage(driver);
		signupLoginObj = new SignupLoginPage(driver);
	}
	
	@Test
	public void loginWrongTest() throws InterruptedException {
		homeObj.verifyHomePage();
		homeObj.navigateToSignupLoginPage();
		
		Thread.sleep(2000);
		closeAd();
		
		signupLoginObj.verifyLoginLabel();
		signupLoginObj.invalidLogin();
		
		Thread.sleep(2000);
		closeAd();
		
		signupLoginObj.verifyInvalidLogin();
	}
	
	@AfterMethod
	public void closeTest() {
		driver.quit();
	}
}
