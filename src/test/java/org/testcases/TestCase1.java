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

public class TestCase1 extends Configuration{
	WebDriver driver;
	HomePage homeObj;
	ProductsPage productsObj;
	CartPage cartObj;
	SignupLoginPage signupLoginObj;
	SignupFormPage signupFormObj;
	CreateAccountSuccessfulPage createAccObj;
	DeleteAccountSuccessfulPage deleteAccObj;
	String port;
	@Parameters({"Port"})
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException {
		this.port = Port;
		driver = setup(port);
		homeObj = new HomePage(driver);
		productsObj = new ProductsPage(driver);
		cartObj = new CartPage(driver);
		signupLoginObj = new SignupLoginPage(driver);
		signupFormObj = new SignupFormPage(driver);
		ConfigProperties.initializePropertyFile();
	}
	
	@Test
	public void RegisterUserCase() throws InterruptedException, IOException {
		Thread.sleep(2000);
		closeAd();
		
		homeObj.verifyHomePage();
		homeObj.navigateToSignupLoginPage();
		closeAd();
		signupLoginObj.signUp(port);
		
		Thread.sleep(2000);
		closeAd();
		
		signupFormObj.fillDetails(port);
		signupFormObj.createAccount();
		createAccObj = new CreateAccountSuccessfulPage(driver);
		
		Thread.sleep(2000);
		closeAd();
		
		createAccObj.verifyAccountCreation();
		createAccObj.createContinue();
		
		Thread.sleep(2000);
		closeAd();
		
		homeObj.verifyUserLogin();
		homeObj.deleteAccount();
		deleteAccObj = new DeleteAccountSuccessfulPage(driver);
		
		Thread.sleep(2000);
		closeAd();
		
		deleteAccObj.verifyAccountDelete();
		deleteAccObj.deleteContinue();
	}
	
	@AfterMethod
	public void closeTest() {
		driver.quit();
	}
}
