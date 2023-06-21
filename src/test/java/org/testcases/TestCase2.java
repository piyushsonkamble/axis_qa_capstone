package org.testcases;

import java.io.File;
import java.io.IOException;

import org.base.config.ConfigProperties;
import org.base.config.Configuration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

import com.google.common.io.Files;

public class TestCase2 extends Configuration{
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
	public void initializeWebsite(String Port) throws IOException, InterruptedException {
		ConfigProperties.initializePropertyFile();
		this.port = Port;
		driver = setup(port);
		homeObj = new HomePage(driver);
		productsObj = new ProductsPage(driver);
		cartObj = new CartPage(driver);
		signupLoginObj = new SignupLoginPage(driver);
		signupFormObj = new SignupFormPage(driver); 
		
		Thread.sleep(2000);
		closeAd();
		
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
		homeObj.userLogOut();
		closeAd();
	}
	
	@Test
	public void loginCorrectTest() throws IOException, InterruptedException {
		homeObj.navigateToHomePage();
		
		Thread.sleep(2000);
		closeAd();
		homeObj.verifyHomePage();
		homeObj.navigateToSignupLoginPage();
		
		Thread.sleep(2000);
		closeAd();
		
		signupLoginObj.verifyLoginLabel();
		signupLoginObj.validLogin(port); 
		
		Thread.sleep(2000);
		closeAd();
		
		homeObj.verifyUserLogin();
		homeObj.deleteAccount();
		deleteAccObj = new DeleteAccountSuccessfulPage(driver);
		
		Thread.sleep(2000);
		closeAd();
		
		deleteAccObj.verifyAccountDelete();
		
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		driver.quit();
		if(port.equals("5555")) {
			Files.copy(screenShotFile, new File("C:\\Users\\maXx\\ProjectScreenshots\\testcase2chrome.png"));
		}else {
			Files.copy(screenShotFile, new File("C:\\Users\\maXx\\ProjectScreenshots\\testcase2edge.png"));
		}
	}
}
