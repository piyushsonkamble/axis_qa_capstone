package org.page.objects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApiTestingPage extends HomePage {
	public ApiTestingPage(WebDriver driver) throws IOException {
		super(driver);
	}
	@FindBy(partialLinkText="API 1")
	WebElement api1Link;
	
	@FindBy(partialLinkText="API 2")
	WebElement api2Link;
	
	@FindBy(partialLinkText="API 3")
	WebElement api3Link;
	
	@FindBy(partialLinkText="API 4")
	WebElement api4Link;
	
	@FindBy(partialLinkText="API 5")
	WebElement api5Link;
	
	@FindBy(partialLinkText="API 6")
	WebElement api6Link;

	@FindBy(partialLinkText="API 7")
	WebElement api7Link;
	
	@FindBy(partialLinkText="API 8")
	WebElement api8Link;
	
	@FindBy(partialLinkText="API 9")
	WebElement api9Link;
	
	@FindBy(partialLinkText="API 10")
	WebElement api10Link;
	
	@FindBy(partialLinkText="API 11")
	WebElement api11Link;
	
	@FindBy(partialLinkText="API 12")
	WebElement api12Link;
	
	@FindBy(partialLinkText="API 13")
	WebElement api13Link;
	
	@FindBy(partialLinkText="API 14")
	WebElement api14Link;
	
	public void openApiTest1() {
		api1Link.click();
	}
	
	public void openApiTest2() {
		api2Link.click();
	}
	
	public void openApiTest3() {
		api3Link.click();
	}
	
	public void openApiTest4() {
		api4Link.click();
	}
	
	public void openApiTest5() {
		api5Link.click();
	}
	
	public void openApiTest6() {
		api6Link.click();
	}
	
	public void openApiTest7() {
		api7Link.click();
	}
	
	public void openApiTest8() {
		api8Link.click();
	}
	
	public void openApiTest9() {
		api9Link.click();
	}
	
	public void openApiTest10() {
		api10Link.click();
	}
	
	public void openApiTest11() {
		api11Link.click();
	}
	
	public void openApiTest12() {
		api12Link.click();
	}
	
	public void openApiTest13() {
		api13Link.click();
	}
	
	public void openApiTest14() {
		api14Link.click();
	}
}
