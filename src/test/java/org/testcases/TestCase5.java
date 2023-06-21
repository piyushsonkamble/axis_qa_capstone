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
	File screenShotFile;
	
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
	public void searchProductCase() throws InterruptedException, IOException {
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
		screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		homeObj.deleteAccount();
		deleteAccObj = new DeleteAccountSuccessfulPage(driver);
		
		Thread.sleep(2000);
		closeAd();
		
		deleteAccObj.deleteContinue();
		
	}
	
	@AfterMethod
	public void cleanUp() throws InterruptedException, IOException{
		
		
		if(port.equals("5555")) {
			Files.copy(screenShotFile, new File("C:\\Users\\maXx\\ProjectScreenshots\\testcase5chrome.png"));
		}else {
			Files.copy(screenShotFile, new File("C:\\Users\\maXx\\ProjectScreenshots\\testcase5edge.png"));
		}
		
		driver.quit();
	}
}
