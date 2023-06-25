package org.page.objects;

import java.io.IOException;

import org.base.config.ConfigProperties;
import org.base.config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HomePage extends NavigationBar{
	WebDriver driver;
	
	public HomePage(WebDriver driver) throws IOException{
		super(driver);
		this.driver=driver;
		ConfigProperties.initializePropertyFile();

	}
	
	
	public void verifyHomePage() {
		Assert.assertTrue(homeButton.getAttribute("style").equals("color: orange;"));
	}
	
	
	
	public void addItemsToCart(int i) {
		Configuration.scrollDown();
		Actions act = new Actions(driver);
		
		for(int a = 1 ; a < 2 * i ; a++) {
			act.moveToElement(driver.findElement(By.xpath("(//*[text()='Add to cart'])["+ a +"]"))).build().perform();
			driver.findElement(By.xpath("(//*[text()='Add to cart'])["+ a++ +"]")).click();
			driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
		}
		
	}
}
