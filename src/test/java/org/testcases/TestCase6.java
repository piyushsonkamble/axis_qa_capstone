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
	String path;
	
	@Parameters({"Port"})
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException {
		this.port = Port;
		driver = setup(Port);
		homeObj = new HomePage(driver);
		productsObj = new ProductsPage(driver);
		productViewObj = new ProductDetailsPage(driver);
		ConfigProperties.initializePropertyFile();
		path = ConfigProperties.property.getProperty("Path");
	}
	
	@Test
	public void writeReviewTestCase() throws IOException, InterruptedException {
		closeAd();
		
		homeObj.navigateToProductsPage();
				
		closeAd();
		
		productsObj.navigateToProductDetailsPage();
		
	
		closeAd();
		
		productViewObj.verifyWriteReviewLabel();
		productViewObj.writeReview();
		productViewObj.verifySuccessfulReview();
		
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		if(port.equals("5555")) {
			Files.copy(screenShotFile, new File(path +"chrome "+ new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").
					format(Calendar.getInstance().getTime())+".png"));
		}else {
			Files.copy(screenShotFile, new File(path +"edge "+ new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").
					format(Calendar.getInstance().getTime())+".png"));
		}
	}
	
	@AfterMethod
	public void closeTest() {
		
		driver.quit();
	}
}
