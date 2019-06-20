package com.companya.tcuv;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LocalSpecials extends TCUVTestBase 
{
	@Test(priority = 71, enabled = true)
	public void localSpecialsPageLoadTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/a")).isDisplayed();

		} catch (Exception e) {

		}
		if(isActive1 == true) {
			getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/a")).getText();
		}
		else {
			
		}
		Assert.assertTrue(getText1.contains("Shopping Tools"), "Shopping Tools on Primary nav  bar isn't displayed");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/a")).click();
		Thread.sleep(3000);
		
		try {
			size = driver.findElements(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size==9, "Shopping Tools elements aren't properly listed");
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[2]/a")).getText();
		Assert.assertTrue(getText1.contains("Local Specials & Deals"), "Local Specials & Deals isn't listed under Shopping Tools");
		Thread.sleep(100);
		
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[2]/a")).click();
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='locationModal']/div/div/div[2]/div/h3")));

		} catch (Exception e) {

		}
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='locationModal']/div/div/div[2]/div/h3")).isDisplayed();
		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Zip modal isn't displayed when 'Your Location' get clicked");
		driver.findElement(By.xpath(".//*[@id='locationModalZipCode']")).sendKeys("02021");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='locationModal']/div/div/div[2]/div/div[2]/button")).click();
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("toyotacertified.com/local-specials"), "Local Specials & Deals is redirected to the wrong URL");
		
		try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'local-specials')]/div[1]/h1")).getText();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("Used Car Offers Near You"), "Local Specials & Deals is redirected to the wrong page");
		try {
			
			size = driver.findElements(By.xpath("//*[contains(@class,'local-specials')]/div")).size();
		}
		catch(Exception e) {
			
		}
		softAssertion.assertTrue(size > 1, "There is no offer displayed on the page");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'local-specials')]/div[3]/div/div[1]/div[2]/div[3]")).getText();
		softAssertion.assertTrue(getText1.contains("Offer ends"), "Check 'offer end' date on the Offer card");
		
		int k = 1;
		if(size >=3) {
		for(int i=3; i<=size; i++) {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'local-specials')]/div[" + i + "]/div/div[1]/div[2]/div[2]")).getText();
			if(getText1.endsWith("Camry")) {
				k = i;
				
			}
		}
		
		}
		driver.findElement(By.xpath("//*[contains(@class,'local-specials')]/div[" + k + "]/div/a")).click();
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.endsWith("Camry"), "Camry offer is redirecting to wrong url");
		driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}

}
