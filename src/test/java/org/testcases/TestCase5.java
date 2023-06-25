package org.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

public class TestCase5 extends Configuration {
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
	String path;

	@Parameters({ "Port" })
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException, InterruptedException {
		this.port = Port;
		driver = setup(port);
		homeObj = new HomePage(driver);
		cartObj = new CartPage(driver);
		productsObj = new ProductsPage(driver);
		signupLoginObj = new SignupLoginPage(driver);
		signupFormObj = new SignupFormPage(driver);
		createAccObj = new CreateAccountSuccessfulPage(driver);
		ConfigProperties.initializePropertyFile();
		deleteAccObj = new DeleteAccountSuccessfulPage(driver);

		path = ConfigProperties.property.getProperty("Path");

		homeObj.navigateToSignupLoginPage();

		closeAd();

		signupLoginObj.signUp(port);

		closeAd();

		signupFormObj.fillDetails(port);
		signupFormObj.createAccount();

		closeAd();
		createAccObj.createContinue();

		closeAd();
		homeObj.userLogOut();
	}

	@Test
	public void searchProductCase() throws InterruptedException, IOException {
		closeAd();
		homeObj.navigateToProductsPage();

		closeAd();

		productsObj.verifyProductsPage();
		productsObj.searchProduct("dress");

		closeAd();

		productsObj.verifySearchProductsLabel();
		productsObj.addAllSearchedItemsToCart();
		productsObj.navigateToCartPage();

		closeAd();

		cartObj.navigateToSignupLoginPage();

		closeAd();

		signupLoginObj.validLogin(port);

		closeAd();

		homeObj.navigateToCartPage();
		closeAd();
		screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		homeObj.deleteAccount();

		closeAd();

		deleteAccObj.deleteContinue();

	}

	@AfterMethod
	public void cleanUp() throws InterruptedException, IOException {

		if (port.equals("5555")) {
			Files.copy(screenShotFile, new File(path + "chrome "
					+ new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(Calendar.getInstance().getTime()) + ".png"));
		} else {
			Files.copy(screenShotFile, new File(path + "edge "
					+ new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(Calendar.getInstance().getTime()) + ".png"));
		}

		driver.quit();
	}
}
