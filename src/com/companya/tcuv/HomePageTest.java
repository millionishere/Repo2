package com.companya.tcuv;

import java.util.Iterator;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends TCUVTestBase 
{
	@Test(priority = 1)
	public void homePageLoadTest() throws InterruptedException {
		isActive1 = false;
		isActive2 = false;
		Thread.sleep(2000);
		expectedUrl = "https://www.toyotacertified.com/";
		actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Wrong URL");
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'navbar-brand')]/img")).isDisplayed();

		} catch (Exception e) {

		}

		Assert.assertTrue(isActive1, " | Page Failed on :" + url);
		Thread.sleep(2000);
	}
	@Test(priority = 2, enabled = true)
	public void utilityNavbarTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/ul/li")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size == 3, "utility nav  bar elements aren't all displayed");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/ul/li[1]/a")).getText();
		getText2 = driver.findElement(By.xpath("//*[contains(@class,'container')]/ul/li[2]/a")).getText();
		getText3 = driver.findElement(By.xpath("//*[contains(@class,'container')]/ul/li[3]/a")).getText();
		Thread.sleep(2000);
		softAssertion.assertTrue(getText1.contains("Your Location:"), "Your Location : isn't displayed on the utility bar");
		softAssertion.assertTrue(getText2.contains("toyota.com"), "toyota.com : isn't displayed on the utility bar");
		softAssertion.assertTrue(getText3.contains("Español"), "Español : isn't displayed on the utility bar");
        softAssertion.assertAll();
	}
	@Test(priority = 3, enabled = true)
	public void zipModalTest() throws InterruptedException {
		//SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/ul/li")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size == 3, "utility nav  bar elements aren't all displayed");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/ul/li[1]/a")).getText();
		Assert.assertTrue(getText1.contains("Your Location:"), "Your Location : isn't displayed on the utility bar");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class,'container')]/ul/li[1]/a")).click();
		
		
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
		driver.findElement(By.xpath(".//*[@id='locationModalZipCode']")).sendKeys("75081");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='locationModal']/div/div/div[2]/div/div[2]/button")).click();
		
		Thread.sleep(2000);
        //softAssertion.assertAll();
	}
	@Test(priority = 4, enabled = true)
	public void toyotaUtilityTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/ul/li")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size == 3, "utility nav  bar elements aren't all displayed");
		driver.findElement(By.xpath("//*[contains(@class,'container')]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		Iterator<String> whs = driver.getWindowHandles().iterator();
		String mainWin = whs.next();
		String toyotaWin = whs.next();
		driver.switchTo().window(toyotaWin);
		Thread.sleep(4000);
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("https://www.toyota.com/"),
				"| toyota.com link redirects to wrong page");
		driver.close();
		driver.switchTo().window(mainWin);
		Thread.sleep(1000);
		softAssertion.assertAll();
	}
	@Test(priority = 5, enabled = true)
	public void espanolUtilityTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/ul/li")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size == 3, "utility nav  bar elements aren't all displayed");
		driver.findElement(By.xpath("//*[contains(@class,'container')]/ul/li[3]/a")).click();
		Thread.sleep(3000);
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[1]/a")).isDisplayed();

		} catch (Exception e) {

		}
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[1]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Vehículos"), "Español page isn't loading");
		driver.navigate().back();
		Thread.sleep(3000);
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[1]/a")).getText();
		Assert.assertTrue(getText1.contains("Vehicles"), "English page isn't loading when 'back' button is clicked from ES page");
		
		Thread.sleep(1000);
		softAssertion.assertAll();
	}
	@Test(priority = 6, enabled = true)
	public void primaryNavbarTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			size = driver.findElements(By.xpath(".//*[@id='navbar']/ul/li")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size == 5, "Primary nav  bar elements aren't all displayed");
		Thread.sleep(2000);
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[1]/a")).getText();
		getText2 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/a")).getText();
		getText3 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/a")).getText();
		getText4 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[4]/a")).getText();
		getText5 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a")).getText();
		Thread.sleep(2000);
		softAssertion.assertTrue(getText1.contains("Vehicles"), "Vehicles : isn't displayed on the primary bar");
		softAssertion.assertTrue(getText2.contains("Shopping Tools"), "Shopping Tools : isn't displayed on the primary bar");
		softAssertion.assertTrue(getText3.contains("Certified Program"), "Certified Program : isn't displayed on the primary bar");
		softAssertion.assertTrue(getText4.contains("FAQ"), "FAQ : isn't displayed on the primary bar");
		softAssertion.assertTrue(getText5.contains("Search Inventory") || getText5.contains("Find a Dealer"), "Search Inventory/Find a Dealer : isn't displayed on the primary bar");
        softAssertion.assertAll();
		

	}
	@Test(priority = 7, enabled = true)
	public void vehiclesNavbarTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[1]/a")).isDisplayed();

		} catch (Exception e) {

		}
		if(isActive1 == true) {
			getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[1]/a")).getText();
		}
		else {
			
		}
		Assert.assertTrue(getText1.contains("Vehicles"), "Vehicles on Primary nav  bar isn't displayed");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[1]/a")).click();
		Thread.sleep(3000);
		
		try {
			size = driver.findElements(By.xpath(".//*[@id='menu-carousel']/ul/li")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size==5, "Vehicles types aren't properly displayed under Vehicles nav bar");
		
		getText1 = driver.findElement(By.xpath(".//*[@id='menu-carousel']/ul/li[1]")).getAttribute("class");
		softAssertion.assertTrue(getText1.contains("active"), "Cars & Minivan isn't active when Vehicles menu is expanded");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='menu-carousel']/ul/li[2]/a")).click();
		Thread.sleep(1000);
		getText1 = driver.findElement(By.xpath(".//*[@id='menu-carousel']/ul/li[2]")).getAttribute("class");
		softAssertion.assertTrue(getText1.contains("active"), "Truks can't be active when Trucks get clicked");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='menu-carousel']/ul/li[3]/a")).click();
		Thread.sleep(1000);
		getText1 = driver.findElement(By.xpath(".//*[@id='menu-carousel']/ul/li[3]")).getAttribute("class");
		softAssertion.assertTrue(getText1.contains("active"), "Crossovers & SUVs can't be active when Crossovers & SUVs get clicked");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='menu-carousel']/ul/li[4]/a")).click();
		Thread.sleep(1000);
		getText1 = driver.findElement(By.xpath(".//*[@id='menu-carousel']/ul/li[4]")).getAttribute("class");
		softAssertion.assertTrue(getText1.contains("active"), "Hybrids & FCV can't be active when Hybrids & FCV get clicked");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='menu-carousel']/ul/li[5]/a")).click();
		Thread.sleep(1000);
		getText1 = driver.findElement(By.xpath(".//*[@id='menu-carousel']/ul/li[5]")).getAttribute("class");
		softAssertion.assertTrue(getText1.contains("active"), "Scion by Toyota can't be active when Scion by Toyota get clicked");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[1]/a")).click();
		Thread.sleep(1000);

        softAssertion.assertAll();
		

	}
	@Test(priority = 8, enabled = true)
	public void shoppingToolsNavbarTest() throws InterruptedException {
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
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[1]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Search Inventory"), "Search Inventory isn't listed under Shopping Tools");
		Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[2]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Local Specials & Deals"), "Local Specials & Deals isn't listed under Shopping Tools");
		Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[3]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Find a Dealer"), "Find a Dealer isn't listed under Shopping Tools");
		Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[4]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Model Library"), "Model Library isn't listed under Shopping Tools");
		Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[6]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Toyota Financial Services"), "Toyota Financial Services isn't listed under Shopping Tools");
		Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[7]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Apply For Credit"), "Apply For Credit isn't listed under Shopping Tools");
		Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[9]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Kelley Blue Book"), "Kelley Blue Book isn't listed under Shopping Tools");
		Thread.sleep(100);
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/a")).click();
		Thread.sleep(1000);

        softAssertion.assertAll();
		

	}
	@Test(priority = 9, enabled = true)
	public void certifiedProgramNavbarTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/a")).isDisplayed();

		} catch (Exception e) {

		}
		if(isActive1 == true) {
			getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/a")).getText();
		}
		else {
			
		}
		Assert.assertTrue(getText1.contains("Certified Program"), "Certified Program on Primary nav  bar isn't displayed");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/a")).click();
		Thread.sleep(3000);
		
		try {
			size = driver.findElements(By.xpath(".//*[@id='navbar']/ul/li[3]/ul/li")).size();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(size>=7, "Certified Program elements aren't properly listed");
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/ul/li[1]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Certification"), "Certification isn't listed under Certified Program");
		Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/ul/li[2]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Warranty"), "Warranty isn't listed under Certified Program");
		Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/ul/li[3]/a")).getText();
		softAssertion.assertTrue(getText1.contains("point Inspection"), "...point Inspection isn't listed under Certified Program");
		Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/ul/li[4]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Roadside Assistance"), "Roadside Assistance isn't listed under Certified Program");
		Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/ul/li[5]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Vehicle History Report"), "Vehicle History Report isn't listed under Certified Program");
		Thread.sleep(100);
		
		//getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/ul/li[7]/a")).getText();
		//softAssertion.assertTrue(getText1.contains("Certified Program Brochure"), "Certified Program Brochure isn't listed under Certified Program");
		//Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/ul/li[7]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Vehicle Service Agreements"), "Vehicle Service Agreements isn't listed under Certified Program");
		Thread.sleep(100);
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/ul/li[8]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Toyota Financial Services"), "Toyota Financial Services isn't listed under Certified Program");
		Thread.sleep(100);
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[3]/a")).click();
		Thread.sleep(1000);

        softAssertion.assertAll();
		

	}
	@Test(priority = 10, enabled = true)
	public void faqNavbarTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[4]/a")).isDisplayed();

		} catch (Exception e) {

		}
		if(isActive1 == true) {
			getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[4]/a")).getText();
		}
		else {
			
		}
		Assert.assertTrue(getText1.contains("FAQ"), "FAQ on Primary nav  bar isn't displayed");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[4]/a")).click();
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/faq"), "FAQ is redirected to the wrong URL");
		
		
		try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div/div/h1")).getText();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("Read FAQs About"), "FAQ is redirected to the wrong page");
		driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
        //driver.navigate().back();
		Thread.sleep(3000);
        currentUrl = driver.getCurrentUrl();
		expectedCurrentUrl = "https://www.toyotacertified.com/";
		softAssertion.assertEquals(currentUrl, expectedCurrentUrl, "It's not redirected to home from FAQ page(when navbar logo get clicked)");
		
        softAssertion.assertAll();
		

	}
	@Test(priority = 11, enabled = true)
	public void searchInventoryNavbarTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a")).isDisplayed();

		} catch (Exception e) {

		}
		if(isActive1 == true) {
			getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a")).getText();
		}
		else {
			
		}
		Assert.assertTrue(getText1.contains("Search Inventory")|| getText1.contains("Find a Dealer"), "Search Inventory/Find a Dealer on Primary nav  bar isn't displayed");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a")).click();
		Thread.sleep(3000);
		if(getText1.contains("Search Inventory")) {
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/inventory"), "Search Inventory is redirected to the wrong URL");
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='vehicleFilters']")).isDisplayed();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive1, "Search Inventory is redirected to the wrong page");
		driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
        //driver.navigate().back();
		Thread.sleep(3000);
        currentUrl = driver.getCurrentUrl();
		expectedCurrentUrl = "https://www.toyotacertified.com/";
		softAssertion.assertEquals(currentUrl, expectedCurrentUrl, "It's not redirected to home from Inventory page(when navbar logo get clicked)");
		}
		else if(getText1.contains("Find a Dealer")) {
			try {

				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='dealersModal']/div/div/div[2]")));

			} catch (Exception e) {

			}
			try {
				isActive1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[2]")).isDisplayed();
				
			} catch (Exception e) {

			}
			Assert.assertTrue(isActive1, "Dealer locator container isn't displayed");
			Thread.sleep(1000);
			try {
				isActive1 = driver.findElement(By.xpath("//*[contains(@class,'agm-map-container-inner')]/div/div/div[1]/div[3]")).isDisplayed();
				
			} catch (Exception e) {

			}
			softAssertion.assertTrue(isActive1, "The map isn't displayed on the dealer locator");
			
			Thread.sleep(1000);
			try {
				isActive1 = driver.findElement(By.xpath("//*[contains(@class,'dealer-listing-container')]/div[2]")).isDisplayed();
				
			} catch (Exception e) {

			}
			softAssertion.assertTrue(isActive1, "Dealers aren't listed on dealer locator");
			driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[1]/a")).click();
			Thread.sleep(2000);
		}
        softAssertion.assertAll();
		

	}
	@Test(priority = 12, enabled = false)
	public void findDealerNavbarTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a")).isDisplayed();

		} catch (Exception e) {

		}
		if(isActive1 == true) {
			getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a")).getText();
		}
		else {
			
		}
		Assert.assertTrue(getText1.contains("Find a Dealer"), "Find a Dealer on Primary nav  bar isn't displayed");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a")).click();
		
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='dealersModal']/div/div/div[2]")));

		} catch (Exception e) {

		}
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[2]")).isDisplayed();
			
		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Dealer locator container isn't displayed");
		Thread.sleep(1000);
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'agm-map-container-inner')]/div/div/div[1]/div[3]")).isDisplayed();
			
		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive1, "The map isn't displayed on the dealer locator");
		
		Thread.sleep(1000);
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'dealer-listing-container')]/div[2]")).isDisplayed();
			
		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive1, "Dealers aren't listed on dealer locator");
		driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[1]/a")).click();
		Thread.sleep(2000);

        softAssertion.assertAll();
		

	}
	@Test(priority = 13, enabled = true)
	public void homeCarouselTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			size = driver.findElements(By.xpath(".//*[@id='home-carousel']/ol/li")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size > 0, "Home carousel isn't displayed");
		Thread.sleep(2000);
		for(int i=1; i<=size; i++) {
			driver.findElement(By.xpath(".//*[@id='home-carousel']/ol/li[" + i + "]")).click();
			Thread.sleep(800);
			getText1 = driver.findElement(By.xpath(".//*[@id='home-carousel']/ol/li[" + i + "]")).getAttribute("class");
			softAssertion.assertTrue(getText1.contains("active"), "Slide " + i + " is not clickable on carousel");
		}
		Thread.sleep(2000);
		softAssertion.assertAll();

	}
	@Test(priority = 14, enabled = true)
	public void searchVehicleCTAOnCarouselTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'model-selector')]/div[1]/div[1]")).isDisplayed();
		} catch (Exception e) {

		}
		
		Assert.assertTrue(isActive1, "CTA isn't displayed on home carousel");
		Thread.sleep(1000);
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'model-selector')]/div/div[1]")).getText();
		softAssertion.assertTrue(getText1.contains("Find my Certified Vehicle"), "Vehicle list CTA isn't displayed on home carousel");
		
		Select sortOrder = new Select(driver.findElement(By.xpath("//*[contains(@class,'intro')]/div[2]/div[1]/div[2]/select")));
		
		
		sortOrder.selectByVisibleText("4Runner");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class,'model-selector')]/div[2]/a")).click();
		Thread.sleep(3000);
		
//		try {
//
//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			wait.until(
//					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='locationModal']/div/div/div[2]/div/h3")));
//
//		} catch (Exception e) {
//
//		}
//		try {
//			isActive1 = driver.findElement(By.xpath(".//*[@id='locationModal']/div/div/div[2]/div/h3")).isDisplayed();
//		} catch (Exception e) {
//
//		}
//		Assert.assertTrue(isActive1, "Zip modal isn't displayed");
//		driver.findElement(By.xpath(".//*[@id='locationModalZipCode']")).sendKeys("75081");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(".//*[@id='locationModal']/div/div/div[2]/div/div[2]/button")).click();
		//Thread.sleep(3000);
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'results')]/div[4]/div/div[1]/div[1]/a[2]")).isDisplayed();
		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive1, "Vehicle offer isn't displayed on the page");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'results')]/div[4]/div/div[1]/div[1]/a[2]")).getText();
		softAssertion.assertTrue(getText1.contains("4Runner"), "4Runner vehicle isn't displayed on the page");
		driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
        //driver.navigate().back();
		Thread.sleep(3000);
        currentUrl = driver.getCurrentUrl();
		expectedCurrentUrl = "https://www.toyotacertified.com/";
		softAssertion.assertEquals(currentUrl, expectedCurrentUrl, "It's not redirected to home from Inventory page(when navbar logo get clicked)");
		softAssertion.assertAll();

	}	
	@Test(priority = 15, enabled = true)
	public void homeCard1Test() throws InterruptedException {
		
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'home-section')]/div[2]/div[1]/div")).isDisplayed();

		} catch (Exception e) {

		}
		if(isActive1 == true) {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'home-section')]/div[2]/div[1]/div/div/div/h2")).getText();
		}
		else {  
			
		}
		Assert.assertTrue(getText1.contains("The Toyota Certified Advantage"), "...Certified home card isn't displayed on home page");
		driver.findElement(By.xpath("//*[contains(@class,'home-section')]/div[2]/div[1]/div/div[2]")).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[4]/a")).click();
		//Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/certification"), "...Certified button is redirected to the wrong URL");
		
		
		try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div/div/h1")).getText();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("Toyota Used Car Certification"), "...Certified button is redirected to the wrong page");
		driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
        //driver.navigate().back();
		Thread.sleep(3000);
        currentUrl = driver.getCurrentUrl();
		expectedCurrentUrl = "https://www.toyotacertified.com/";
		softAssertion.assertEquals(currentUrl, expectedCurrentUrl, "It's not redirected to home from ...Certified page(when navbar logo get clicked)");
		
        softAssertion.assertAll();
		

		

	}
	@Test(priority = 16)
	public void disclaimerOnHomeCardTest() throws InterruptedException {
		
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		isActive2 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'home-section')]/div[2]/div[1]/div")).isDisplayed();

		} catch (Exception e) {

		}
		if(isActive1 == true) {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'home-section')]/div[2]/div[1]/div/div/div/h2")).getText();
		}
		else {  
			
		}
		Assert.assertTrue(getText1.contains("The Toyota Certified Advantage"), "...Certified home card isn't displayed on home page");
		
		
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div/div[1]/div[2]/h4/a/sup")).isDisplayed();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive1, "Disclaimer link 1 isn't displayed on home card");
		if(isActive1 == true) {
			driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div/div[1]/div[2]/h4/a/sup")).click();
			Thread.sleep(1000);
			try {
				isActive2 = driver.findElement(By.xpath(".//*[@id='disclaimerText']")).isDisplayed();
				

			} catch (Exception e) {

			}
			softAssertion.assertTrue(isActive2, "Disclaimer text isn't displayed for link 1");
			if(isActive2 == true) {
				driver.findElement(By.xpath("//*[@id='disclaimerModal']/div/div/div[1]/button")).click();;
			}
			else {
				
			}
			
		}
		else {  
			
		}
		Thread.sleep(2000);
		
		isActive1 = false;
		isActive2 = false;
		
		
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div/div[1]/div[4]/h4/a/sup")).isDisplayed();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive1, "Disclaimer link 2 isn't displayed on home card");
		if(isActive1 == true) {
			driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div/div[1]/div[4]/h4/a/sup")).click();
			Thread.sleep(1000);
			try {
				isActive2 = driver.findElement(By.xpath(".//*[@id='disclaimerText']")).isDisplayed();
				

			} catch (Exception e) {

			}
			softAssertion.assertTrue(isActive2, "Disclaimer text isn't displayed for link 1");
			if(isActive2 == true) {
				driver.findElement(By.xpath("//*[@id='disclaimerModal']/div/div/div[1]/button")).click();;
			}
			else {
				
			}
			
		}
		else {  
			
		}
		Thread.sleep(2000);
		
		isActive1 = false;
		isActive2 = false;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div/div[1]/div[5]/h4/a/sup")).isDisplayed();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive1, "Disclaimer link 3 isn't displayed on home card");
		if(isActive1 == true) {
			driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div/div[1]/div[5]/h4/a/sup")).click();
			Thread.sleep(1000);
			try {
				isActive2 = driver.findElement(By.xpath(".//*[@id='disclaimerText']")).isDisplayed();
				

			} catch (Exception e) {

			}
			softAssertion.assertTrue(isActive2, "Disclaimer text isn't displayed for link 1");
			if(isActive2 == true) {
				driver.findElement(By.xpath("//*[@id='disclaimerModal']/div/div/div[1]/button")).click();;
			}
			else {
				
			}
		}
		else {  
			
		}
		Thread.sleep(2000);
		
		isActive1 = false;
		isActive2 = false;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div/div[1]/div[6]/h4/a/sup")).isDisplayed();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive1, "Disclaimer link 4 isn't displayed on home card");
		if(isActive1 == true) {
			driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div/div[1]/div[6]/h4/a/sup")).click();
			Thread.sleep(1000);
			try {
				isActive2 = driver.findElement(By.xpath(".//*[@id='disclaimerText']")).isDisplayed();
				

			} catch (Exception e) {

			}
			softAssertion.assertTrue(isActive2, "Disclaimer text isn't displayed for link 1");
			if(isActive2 == true) {
				driver.findElement(By.xpath("//*[@id='disclaimerModal']/div/div/div[1]/button")).click();;
			}
			else {
				
			}
			
		}
		else {  
			
		}
		Thread.sleep(2000);
		
		isActive1 = false;
		isActive2 = false;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div/div[1]/div[7]/h4/a/sup")).isDisplayed();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive1, "Disclaimer link 5 isn't displayed on home card");
		if(isActive1 == true) {
			driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div/div[1]/div[7]/h4/a/sup")).click();
			Thread.sleep(1000);
			try {
				isActive2 = driver.findElement(By.xpath(".//*[@id='disclaimerText']")).isDisplayed();
				

			} catch (Exception e) {

			}
			softAssertion.assertTrue(isActive2, "Disclaimer text isn't displayed for link 1");
			if(isActive2 == true) {
				driver.findElement(By.xpath("//*[@id='disclaimerModal']/div/div/div[1]/button")).click();;
			}
			else {
				
			}
			
		}
		else {  
			
		}
		Thread.sleep(2000);
		
		
		
		
        softAssertion.assertAll();
		

	}
	@Test(priority = 17, enabled = true)
	public void localSpecialsHomeCardTest() throws InterruptedException {
		
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		isActive2 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'home-section')]/div[2]/div[2]/*/div")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Home section is missing on the home page");
		try {
			isActive2 = driver.findElement(By.xpath(".//*[@id='desktop-banner']/div/div[1]/h3")).isDisplayed();

		} catch (Exception e) {

		}
		
		if(isActive2 == true) {
			getText1 = driver.findElement(By.xpath(".//*[@id='desktop-banner']/div/div[1]/h3")).getText();
			Assert.assertTrue(getText1.contains("Local Specials"), "Local Specials home card isn't displayed on home page");
		}
		else {  
			
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='desktop-banner']/div/div[3]")).click();
		Thread.sleep(3000);
		
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/local-specials"), "Local Specials is redirected to the wrong URL");
		
		
		try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'local-specials')]/div/h1")).getText();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("Used Car Offers Near You"), "Local Specials is redirected to the wrong page");
		driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
        //driver.navigate().back();
		Thread.sleep(3000);
        currentUrl = driver.getCurrentUrl();
		expectedCurrentUrl = "https://www.toyotacertified.com/";
		softAssertion.assertEquals(currentUrl, expectedCurrentUrl, "It's not redirected to home from Local Specials page(when navbar logo get clicked)");
		
        softAssertion.assertAll();
		

		

	}
	@Test(priority = 18, enabled = true)
	public void certifiedVideoHomeCardTest() throws InterruptedException {
		
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		isActive2 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'home-section')]/div[2]/div[3]/div")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Home section is missing on the home page");
		try {
			isActive2 = driver.findElement(By.xpath("//*[contains(@class,'home-section')]/div[2]/div[3]/div/div/h3")).isDisplayed();

		} catch (Exception e) {

		}
		
		if(isActive2 == true) {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'home-section')]/div[2]/div[3]/div/div/h3")).getText();
			Assert.assertTrue(getText1.contains("Certified Video"), "Certified Video home card isn't displayed on home page");
		}
		else {  
			
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='modelVideo']")).click();
		Thread.sleep(6000);
		try {
			isActive2 = driver.findElement(By.xpath(".//*[@id='videoModal']/div/div/div[1]/button")).isDisplayed();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive2, "Video Modal isn't properly displayed");
		driver.findElement(By.xpath(".//*[@id='videoModal']/div/div/div[1]/button")).click();
		
		Thread.sleep(1000);
		
        softAssertion.assertAll();
		

		

	}
	
	
	
}
