package org.testcases;

import java.io.File;
import java.io.IOException;

import org.base.config.Configuration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.page.objects.CartPage;
import org.page.objects.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TestCase4 extends Configuration{
	WebDriver driver;
	HomePage homeObj;
	CartPage cartObj;
	String port;
	@Parameters({"Port"})
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException {
		this.port = Port;
		driver = setup(Port);
		homeObj = new HomePage(driver);
		cartObj = new CartPage(driver);
	}
	
	@Test
	public void removeItemsTestCase() throws InterruptedException, IOException {
		closeAd();
		homeObj.verifyHomePage();
		homeObj.addItemsToCart(5);
		homeObj.navigateToCartPage();
		
		Thread.sleep(2000);
		closeAd();
		
		cartObj.verifyCartPage();
		cartObj.emptyCart();
		cartObj.verifyEmptyCart();
		
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		driver.quit();
		if(port.equals("5555")) {
			Files.copy(screenShotFile, new File("C:\\Users\\maXx\\ProjectScreenshots\\testcase4chrome.png"));
		}else {
			Files.copy(screenShotFile, new File("C:\\Users\\maXx\\ProjectScreenshots\\testcase4edge.png"));
		}
	}
}
