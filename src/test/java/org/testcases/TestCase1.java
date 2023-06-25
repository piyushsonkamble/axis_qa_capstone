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
import org.page.objects.CreateAccountSuccessfulPage;
import org.page.objects.DeleteAccountSuccessfulPage;
import org.page.objects.HomePage;
import org.page.objects.ProductsPage;
import org.page.objects.SignupFormPage;
import org.page.objects.SignupLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TestCase1 extends Configuration{
	WebDriver driver;
	HomePage homeObj;
	ProductsPage productsObj;
	SignupLoginPage signupLoginObj;
	SignupFormPage signupFormObj;
	CreateAccountSuccessfulPage createAccObj;
	DeleteAccountSuccessfulPage deleteAccObj;
	String port;
	String path;
	File screenShotFile;
	
	@Parameters({"Port"})
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException {
		this.port = Port;
		driver = setup(port);
		homeObj = new HomePage(driver);
		productsObj = new ProductsPage(driver);
		signupLoginObj = new SignupLoginPage(driver);
		signupFormObj = new SignupFormPage(driver);
		ConfigProperties.initializePropertyFile();
		path = ConfigProperties.property.getProperty("Path");
	}
	
	@Test
	public void RegisterUserCase() throws IOException, InterruptedException {
		closeAd();
		
		homeObj.verifyHomePage();
		
		closeAd();
		
		homeObj.navigateToSignupLoginPage();
		
		closeAd();
		signupLoginObj.signUp(port);
		
	
		closeAd();
		
		signupFormObj.fillDetails(port);
		signupFormObj.createAccount();
		createAccObj = new CreateAccountSuccessfulPage(driver);
		
		
		closeAd();
		
		createAccObj.verifyAccountCreation();
		createAccObj.createContinue();
		
		
		closeAd();
		
		homeObj.verifyUserLogin();
		homeObj.deleteAccount();
		deleteAccObj = new DeleteAccountSuccessfulPage(driver);
		
		
		closeAd();
		
		deleteAccObj.verifyAccountDelete();
		deleteAccObj.deleteContinue();
		
		screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		driver.quit();
		
		if(port.equals("5555")) {
			Files.copy(screenShotFile, new File(path +"chrome "+ new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").
					format(Calendar.getInstance().getTime())+".png"));
		}else {
			Files.copy(screenShotFile, new File(path +"edge "+ new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").
					format(Calendar.getInstance().getTime())+".png"));
		}
	}
}
