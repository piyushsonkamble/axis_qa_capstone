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
import org.page.objects.SignupFormPage;
import org.page.objects.SignupLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TestCase2 extends Configuration{
	WebDriver driver;
	HomePage homeObj;
	SignupLoginPage signupLoginObj;
	SignupFormPage signupFormObj;
	CreateAccountSuccessfulPage createAccObj;
	DeleteAccountSuccessfulPage deleteAccObj;
	String port;
	String path;
	
	@Parameters({"Port"})
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException, InterruptedException {
		ConfigProperties.initializePropertyFile();
		this.port = Port;
		driver = setup(port);
		homeObj = new HomePage(driver);
		signupLoginObj = new SignupLoginPage(driver);
		signupFormObj = new SignupFormPage(driver); 
		path = ConfigProperties.property.getProperty("Path");
		
		
		closeAd();
		
		homeObj.navigateToSignupLoginPage();
		
		
		closeAd();
		
		signupLoginObj.signUp(port);
		
		
		closeAd();
		
		signupFormObj.fillDetails(port);
		signupFormObj.createAccount();
		
		createAccObj = new CreateAccountSuccessfulPage(driver);
		
		
		closeAd();
		
		createAccObj.createContinue();
		closeAd();
		homeObj.userLogOut();
		closeAd();
	}
	
	@Test
	public void loginCorrectTest() throws IOException, InterruptedException {
		homeObj.navigateToHomePage();
		
		
		closeAd();
		homeObj.verifyHomePage();
		homeObj.navigateToSignupLoginPage();
		
		
		closeAd();
		
		signupLoginObj.verifyLoginLabel();
		signupLoginObj.validLogin(port); 
		
		
		closeAd();
		
		homeObj.verifyUserLogin();
		homeObj.deleteAccount();
		deleteAccObj = new DeleteAccountSuccessfulPage(driver);
		
		
		closeAd();
		
		deleteAccObj.verifyAccountDelete();
		
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
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
