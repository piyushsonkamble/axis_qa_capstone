package org.testcases;

import java.io.File;
import java.io.IOException;

import org.base.config.Configuration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.page.objects.HomePage;
import org.page.objects.ProductDetailsPage;
import org.page.objects.ProductsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TestCase6 extends Configuration{
	WebDriver driver;
	HomePage homeObj;
	ProductsPage productsObj;
	ProductDetailsPage productViewObj;
	String port;
	@Parameters({"Port"})
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException {
		this.port = Port;
		driver = setup(Port);
		homeObj = new HomePage(driver);
		productsObj = new ProductsPage(driver);
		productViewObj = new ProductDetailsPage(driver);
	}
	
	@Test
	public void writeReviewTestCase() throws InterruptedException, IOException {
		homeObj.navigateToProductsPage();
		
		Thread.sleep(2000);
		closeAd();
		
		productsObj.navigateToProductDetailsPage();
		
		Thread.sleep(2000);
		closeAd();
		
		productViewObj.verifyWriteReviewLabel();
		productViewObj.writeReview();
		productViewObj.verifySuccessfulReview();
		
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		if(port.equals("5555")) {
			Files.copy(screenShotFile, new File("C:\\Users\\maXx\\ProjectScreenshots\\testcase6chrome.png"));
		}else {
			Files.copy(screenShotFile, new File("C:\\Users\\maXx\\ProjectScreenshots\\testcase6edge.png"));
		}
	}
	
	@AfterMethod
	public void closeTest() {
		
		driver.quit();
	}
}
