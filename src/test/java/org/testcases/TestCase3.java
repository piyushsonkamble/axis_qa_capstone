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
import org.page.objects.DeleteAccountSuccessfulPage;
import org.page.objects.HomePage;
import org.page.objects.SignupLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TestCase3 extends Configuration {
	WebDriver driver;
	HomePage homeObj;
	SignupLoginPage signupLoginObj;
	DeleteAccountSuccessfulPage deleteAccObj;
	String port;
	String path;
	
	@Parameters({"Port"})
	@BeforeClass
	public void initializeWebsite(String Port) throws IOException {
		this.port = Port;
		driver = setup(Port);
		homeObj = new HomePage(driver);
		signupLoginObj = new SignupLoginPage(driver);
		ConfigProperties.initializePropertyFile();
		path = ConfigProperties.property.getProperty("Path");
	}
	
	@Test
	public void loginWrongTest() throws IOException, InterruptedException {
		homeObj.verifyHomePage();
		homeObj.navigateToSignupLoginPage();
		
		
		closeAd();
		
		signupLoginObj.verifyLoginLabel();
		signupLoginObj.invalidLogin();
		
		
		closeAd();
		
		signupLoginObj.verifyInvalidLogin();
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
	public void closeTest() throws IOException {
		
		driver.quit();
	}
}
