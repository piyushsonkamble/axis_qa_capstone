package org.page.objects;

import java.io.IOException;

import org.base.config.ConfigProperties;
import org.base.config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;


public class SignupFormPage extends HomePage {
	
	public SignupFormPage(WebDriver driver) throws IOException {
		super(driver);
		ConfigProperties.initializePropertyFile();
	}

	@FindBy(xpath = "//*[text()='Enter Account Information']")
	WebElement enterAccountInformationLabel;

	@FindBy(xpath = "//*[@value='Mr']")
	WebElement mrRadioButton;

	@FindBy(xpath = "//*[@value='Mrs']")
	WebElement mrsRadioButton;

	@FindBy(xpath = "//*[@id='name']")
	WebElement nameField;

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(xpath = "//*[text()='Date of Birth']")
	WebElement dobLabel;

	@FindBy(id = "days")
	WebElement daysButton;

	@FindBy(id = "months")
	WebElement monthsButton;

	@FindBy(id = "years")
	WebElement yearsButton;

	@FindBy(xpath = "//*[text()='Sign up for our newsletter!']")
	WebElement newsletterCheckBox;

	@FindBy(xpath = "//*[text()='Receive special offers from our partners!']")
	WebElement offersCheckBox;

	@FindBy(xpath = "Address Information")
	WebElement addressInformationLabel;

	@FindBy(id = "first_name")
	WebElement firstNameField;

	@FindBy(id = "last_name")
	WebElement lastNameField;

	@FindBy(id = "company")
	WebElement companyField;

	@FindBy(id = "address1")
	WebElement addressLine1;

	@FindBy(id = "address2")
	WebElement addressLine2;

	@FindBy(id = "country")
	WebElement countryButton;

	@FindBy(id = "state")
	WebElement stateField;

	@FindBy(id = "city")
	WebElement cityField;

	@FindBy(id = "zipcode")
	WebElement zipcodeField;

	@FindBy(id = "mobile_number")
	WebElement mobileNumberField;

	@FindBy(xpath = "//*[text()='Create Account']")
	WebElement createAccountButton;
	

	String Gender ;
	String Name ;
	String FirstName ;
	String LastName ;
	String Email ;
	String Password ;
	String Day ;
	String Month;
	String Year;
	String Company;
	String Address;
	String City;
	String State;
	String Country;
	String Zipcode;
	String MobileNumber;
	
	@Parameters({"Port"})
	public void getDetails(String Port) {
		if(Port.equalsIgnoreCase("5555")) {
			Gender = ConfigProperties.property.getProperty("MGender");
			Name = ConfigProperties.property.getProperty("MName");
			FirstName = ConfigProperties.property.getProperty("MFirstName");
			LastName = ConfigProperties.property.getProperty("MLastName");
			Email = ConfigProperties.property.getProperty("MEmail");
			Password = ConfigProperties.property.getProperty("MPassword");
			Day = ConfigProperties.property.getProperty("MDay");
			Month = ConfigProperties.property.getProperty("MMonth");
			Year = ConfigProperties.property.getProperty("MYear");
			Company = ConfigProperties.property.getProperty("MCompany");
			Address = ConfigProperties.property.getProperty("MAddress");
			City = ConfigProperties.property.getProperty("MCity");
			State = ConfigProperties.property.getProperty("MState");
			Country = ConfigProperties.property.getProperty("MCountry");
			Zipcode = ConfigProperties.property.getProperty("MZipcode");
			MobileNumber = ConfigProperties.property.getProperty("MMobileNumber");
		}
		else{
			Gender = ConfigProperties.property.getProperty("FGender");
			Name = ConfigProperties.property.getProperty("FName");
			FirstName = ConfigProperties.property.getProperty("FFirstName");
			LastName = ConfigProperties.property.getProperty("FLastName");
			Email = ConfigProperties.property.getProperty("FEmail");
			Password = ConfigProperties.property.getProperty("FPassword");
			Day = ConfigProperties.property.getProperty("FDay");
			Month = ConfigProperties.property.getProperty("FMonth");
			Year = ConfigProperties.property.getProperty("FYear");
			Company = ConfigProperties.property.getProperty("FCompany");
			Address = ConfigProperties.property.getProperty("FAddress");
			City = ConfigProperties.property.getProperty("FCity");
			State = ConfigProperties.property.getProperty("FState");
			Country = ConfigProperties.property.getProperty("FCountry");
			Zipcode = ConfigProperties.property.getProperty("FZipcode");
			MobileNumber = ConfigProperties.property.getProperty("FMobileNumber");
		}
		
	}

//	String Gender = "Male";
//	String Name = "Walter White";
//	String FirstName = "Walter";
//	String LastName = "White";
//	String Email = "walterwhite683@gmail.com";
//	String Password = "Zgve6@Arbwy";
//	String Day = "26";
//	String Month = "September";
//	String Year = "2003";
//	String Company = "Google";
//	String Address = "24 William Street";
//	String City = "New York";
//	String State = "Ohio";
//	String Country = "United States";
//	String Zipcode = "179204";
//	String MobileNumber = "5368441367";

	@Parameters({"Port"})
	public void fillDetails(String Port) throws InterruptedException {
		getDetails(Port);
		Thread.sleep(2000);
		if (Gender.equalsIgnoreCase("Male")) {
			mrRadioButton.click();
		}
		if (Gender.equalsIgnoreCase("Female")) {
			mrsRadioButton.click();
		}	
		passwordField.sendKeys(Password);
		Configuration.scrollDown();
		
		Select daysDropDown = new Select(daysButton);
		daysDropDown.selectByValue(Day);
		
		Select monthsDropDown = new Select(monthsButton);
		monthsDropDown.selectByVisibleText(Month);
		
		Select yearsDropDown = new Select(yearsButton);
		yearsDropDown.selectByVisibleText(Year);
		
		newsletterCheckBox.click();
		offersCheckBox.click();
		Configuration.scrollDown();
		firstNameField.sendKeys(FirstName);
		lastNameField.sendKeys(LastName);
		companyField.sendKeys(Company);
		Configuration.scrollDown();
		addressLine1.sendKeys(Address);
		Configuration.scrollDown();
		
		Select countryDropDown = new Select(countryButton);
		countryDropDown.selectByVisibleText(Country);
		
		stateField.sendKeys(State);
		Configuration.scrollDown();
		cityField.sendKeys(City);
		Configuration.scrollDown();
		zipcodeField.sendKeys(Zipcode);
		mobileNumberField.sendKeys(MobileNumber);

	}

	public void createAccount() {
		createAccountButton.click();
	}

}
