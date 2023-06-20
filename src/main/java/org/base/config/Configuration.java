package org.base.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Configuration {
	static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	String nodeURL;
	static JavascriptExecutor js;
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void setDriver(WebDriver driver) {
		Configuration.driver.set(driver);
	}
	
	public WebDriver setup(String Port) throws MalformedURLException {
		
		
		
		if (Port.equalsIgnoreCase("5555")) {
			nodeURL = "http://192.168.31.206:4444/wd/hub";
			System.out.println("Chrome Browser Initiated");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WINDOWS);
			chromeOptions.merge(capabilities);

			setDriver(new RemoteWebDriver(new URL(nodeURL), capabilities));

			getDriver().get("https://automationexercise.com/");
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

		else if (Port.equalsIgnoreCase("6666")) {
			nodeURL = "http://192.168.31.206:4444/wd/hub";
			System.out.println("Microsoft Edge Browser Initiated");
			DesiredCapabilities capabilities1 = DesiredCapabilities.edge();
			capabilities1.setBrowserName("MicrosoftEdge");
			capabilities1.setPlatform(Platform.WINDOWS);

			setDriver(new RemoteWebDriver(new URL(nodeURL), capabilities1));

			getDriver().get("https://automationexercise.com/");
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		return getDriver();
	}
	
	public static void closeAd() {
		js = (JavascriptExecutor) driver.get();
		js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
	}
	
	public static void scrollDown() {
		js = (JavascriptExecutor) driver.get();
		js.executeScript("window.scroll(0,500)");
	}
}
