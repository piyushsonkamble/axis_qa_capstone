package org.page.objects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends NavigationBar{
	public TestCasesPage(WebDriver driver) throws IOException {
		super(driver);
	}
	
	@FindBy(partialLinkText="Test Case 1")
	WebElement testCase1Link;
	
	@FindBy(partialLinkText="Test Case 2")
	WebElement testCase2Link;
	
	@FindBy(partialLinkText="Test Case 3")
	WebElement testCase3Link;
	
	@FindBy(partialLinkText="Test Case 4")
	WebElement testCase4Link;
	
	@FindBy(partialLinkText="Test Case 5")
	WebElement testCase5Link;
	
	@FindBy(partialLinkText="Test Case 6")
	WebElement testCase6Link;

	@FindBy(partialLinkText="Test Case 7")
	WebElement testCase7Link;
	
	@FindBy(partialLinkText="Test Case 8")
	WebElement testCase8Link;
	
	@FindBy(partialLinkText="Test Case 9")
	WebElement testCase9Link;
	
	@FindBy(partialLinkText="Test Case 10")
	WebElement testCase10Link;
	
	@FindBy(partialLinkText="Test Case 11")
	WebElement testCase11Link;
	
	@FindBy(partialLinkText="Test Case 12")
	WebElement testCase12Link;
	
	public void openTest1() {
		testCase1Link.click();
	}
	
	public void openTest2() {
		testCase2Link.click();
	}
	
	public void openTest3() {
		testCase3Link.click();
	}
	
	public void openTest4() {
		testCase4Link.click();
	}
	
	public void openTest5() {
		testCase5Link.click();
	}
	
	public void openTest6() {
		testCase6Link.click();
	}
	
	public void openTest7() {
		testCase7Link.click();
	}
	
	public void openTest8() {
		testCase8Link.click();
	}
	
	public void openTest9() {
		testCase9Link.click();
	}
	
	public void openTest10() {
		testCase10Link.click();
	}
	
	public void openTest11() {
		testCase11Link.click();
	}
	
	public void openTest12() {
		testCase12Link.click();
	}
}
