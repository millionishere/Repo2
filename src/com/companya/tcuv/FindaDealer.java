package com.companya.tcuv;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FindaDealer extends TCUVTestBase 
{
	@Test(priority = 81, enabled = true)
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
		driver.findElement(By.xpath(".//*[@id='locationModalZipCode']")).sendKeys("02026");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='locationModal']/div/div/div[2]/div/div[2]/button")).click();
		
		Thread.sleep(2000);
        //softAssertion.assertAll();
	}
	@Test(priority = 82, enabled = true)
	public void dealerPageLoadTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 30);
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
		Assert.assertTrue(size>=9, "Shopping Tools elements aren't properly listed");
		
		getText1 = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[3]/a")).getText();
		Assert.assertTrue(getText1.contains("Find a Dealer"), "Find a Dealer isn't listed under Shopping Tools");
		Thread.sleep(100);
		
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[3]/a")).click();
		try {

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(".//*[@id='dealersModal']/div/div/div[2]")));
		} catch (Exception e) {

		}
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[2]")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Modal isn't displayed when Find a Dealer link get clicked");
		getText1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[2]")).getText();
		Assert.assertTrue(getText1.contains("Dealer Locator"), "Find a Dealer modal  isn't properly displayed");
		Thread.sleep(3000);
		try {
			getText1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[2]/div/a")).getText();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("Back to previous page"), "Unable to find the element 'Back to previous page'");
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[1]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Unable to find close 'X' button");
		//driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[1]/a")).click();
		//Thread.sleep(4000);
		
	
		softAssertion.assertAll();
	}
	@Test(priority = 83, enabled = true)
	public void zipChangeOnDealersListTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		
		isActive1 = false;
		size = 0;
		try {
			size = driver.findElements(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div")).size();

		} catch (Exception e) {
			
		}
		softAssertion.assertTrue(size >= 2, "Dealers aren't listed");
		if(size > 1) {
			try {
				isActive1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[1]/a/div[2]")).isDisplayed();

			} catch (Exception e) {

			}
			Assert.assertTrue(isActive1, "Check the dealer's list on Dealer Locator modal");
			getText1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[1]/a/div[2]")).getText();
		}
		else {
			getText1 = " ";
		}
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[1]/ng2-completer/div/input")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Zip field isn't displayed");
		driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[1]/ng2-completer/div/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[1]/ng2-completer/div/input")).sendKeys("75081");
		Thread.sleep(3000);
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[1]/button")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Search button next to zip field isn't displayed");
		driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[1]/button")).click();
		Thread.sleep(3000);
		
		size = 0;
		try {
			size = driver.findElements(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div")).size();

		} catch (Exception e) {
			
		}
		softAssertion.assertTrue(size >= 2, "Dealers aren't listed");
		if(size > 1) {
			try {
				isActive1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[1]/a/div[2]")).isDisplayed();

			} catch (Exception e) {

			}
			Assert.assertTrue(isActive1, "Check the dealer's list on Dealer Locator modal");
			getText2 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[1]/a/div[2]")).getText();
		}
		else {
			getText2 = " ";
		}
		Assert.assertTrue(getText1 != getText2, "Same dealers list for two different zips");
		softAssertion.assertAll();
	}
	@Test(priority = 84, enabled = true)
	public void dealersDetailTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		
		isActive1 = false;
		size = 0;
		try {
			size = driver.findElements(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div")).size();

		} catch (Exception e) {
			
		}
		Assert.assertTrue(size >= 2, "Dealers aren't listed");
			try {
				isActive1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[1]/a/div[2]")).isDisplayed();

			} catch (Exception e) {

			}
			Assert.assertTrue(isActive1, "Check the dealer's list on Dealer Locator modal");
			getText1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[1]/a/div[2]")).getText();
			driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[1]/a/div[2]")).click();
			Thread.sleep(2000);
	        
			try {
				isActive1 = driver.findElement(By.xpath(".//*[@id='collapseDealer0']/div/div[2]")).isDisplayed();

			} catch (Exception e) {

			}
			Assert.assertTrue(isActive1, "Dealer's detail isn't displayed");
			try {
				getText1 = driver.findElement(By.xpath(".//*[contains(@class,'dealer-listing-container')]/div[2]"
						+ "/div[2]/div/div[2]/div[3]/div[1]/a/div[2]")).getText();

			} catch (Exception e) {

			}
			Assert.assertTrue(getText1.contains("WEBSITE"), "WEBSITE isn't displayed on dealer's list");
				driver.findElement(By.xpath(".//*[contains(@class,'dealer-listing-container')]/div[2]/div[2]"
						+ "/div/div[2]/div[3]/div[1]/a/div[2]")).click();
				Thread.sleep(3000);
				Iterator<String> whs = driver.getWindowHandles().iterator();
				String mainWin = whs.next();
				String otherWin = whs.next();
				driver.switchTo().window(otherWin);
				Thread.sleep(4000);
				currentUrl = driver.getCurrentUrl();
				softAssertion.assertTrue(currentUrl.contains("toyotaofrichardson"),
						"WEBSITE redirects to wrong page");
				driver.close();
				driver.switchTo().window(mainWin);
				Thread.sleep(2000);
				
				try {
					getText1 = driver.findElement(By.xpath(".//*[contains(@class,'dealer-listing-container')]/div[2]"
							+ "/div[2]/div/div[2]/div[3]/div[2]/a/div[2]")).getText();

				} catch (Exception e) {

				}
				Assert.assertTrue(getText1.contains("DIRECTIONS"), "DIRECTIONS isn't displayed on dealer's list");
					driver.findElement(By.xpath(".//*[contains(@class,'dealer-listing-container')]/div[2]/div[2]"
							+ "/div/div[2]/div[3]/div[2]/a/div[2]")).click();
					Thread.sleep(3000);
					Iterator<String> whs2 = driver.getWindowHandles().iterator();
					String mainWin2 = whs2.next();
					String otherWin2 = whs2.next();
					driver.switchTo().window(otherWin2);
					Thread.sleep(4000);
					currentUrl = driver.getCurrentUrl();
					softAssertion.assertTrue(currentUrl.contains("google.com/maps"),
							"DIRECTIONS redirects to wrong page");
					driver.close();
					driver.switchTo().window(mainWin2);
					Thread.sleep(2000);
		
				try {
					isActive1 = driver.findElement(By.xpath(".//*[contains(@class,'dealer-listing-container')]/div[2]/div[2]/div/div[1]/a")).isDisplayed();

				} catch (Exception e) {

				}
				Assert.assertTrue(isActive1, "Dealers detail can't be collapsed with Close 'X' button");
				driver.findElement(By.xpath(".//*[contains(@class,'dealer-listing-container')]/div[2]/div[2]/div/div[1]/a")).click();
				Thread.sleep(2000);

		
		
		    softAssertion.assertAll();
	}
	@Test(priority = 85, enabled = true)
	public void dealersListContactTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		
		isActive1 = false;
		size = 0;
		
			try {
				getText1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[3]/div[2]/a/div[2]")).getText();

			} catch (Exception e) {

			}
			Assert.assertTrue(getText1.contains("CONTACT"), "CONTACT isn't displayed on dealer's list");
			driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[3]/div[2]/a/div[2]")).click();
				Thread.sleep(3000);
	
			try {
				getText1 = driver.findElement(By.xpath(".//*[@id='dealerContactSmallModal']/div/div/div[2]")).getText();

			} catch (Exception e) {

			}
			Assert.assertTrue(getText1.contains("Dealer Contact Form"), "CONTACT is redirecting to wrong page");
			Thread.sleep(1000);
			try {
				isActive1 = driver.findElement(By.xpath(".//*[@id='dealerContactSmallModal']/div/div/div[1]/a")).isDisplayed();

			} catch (Exception e) {

			}
			softAssertion.assertTrue(isActive1, "Modal has no close 'X' button");
			Thread.sleep(1000);
			try {
				getText1 = driver.findElement(By.xpath(".//*[@id='dealerContactSmallModal']/div/div/div[2]/div/a")).getText();

			} catch (Exception e) {

			}
			Assert.assertTrue(getText1.contains("Back to previous page"), "Back to previous page link isn't displayed on the Modal");
			driver.findElement(By.xpath(".//*[@id='dealerContactSmallModal']/div/div/div[2]/div/a")).click();
			Thread.sleep(2000);
		    softAssertion.assertAll();
	}
	@Test(priority = 86, enabled = true)
	public void dealersListChatTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		
		isActive1 = false;
		size = 0;
		
			try {
				getText1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[3]/div[3]/a/div[2]")).getText();

			} catch (Exception e) {

			}
			Assert.assertTrue(getText1.contains("CHAT"), "CHAT isn't displayed on dealer's list");
			driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[3]/div[3]/a/div[2]")).click();
				Thread.sleep(3000);
				Iterator<String> whs = driver.getWindowHandles().iterator();
				String mainWin = whs.next();
				String otherWin = whs.next();
				driver.switchTo().window(otherWin);
				Thread.sleep(4000);
				currentUrl = driver.getCurrentUrl();
				softAssertion.assertTrue(currentUrl.contains("contactatonce"),
						"CHAT redirects to wrong page");
				driver.close();
				driver.switchTo().window(mainWin);
				Thread.sleep(2000);
	
			
		    softAssertion.assertAll();
	}
	@Test(priority = 87, enabled = true)
	public void dealersMapLocatorTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		int size2 = 0;
		isActive1 = false;
		size = 0;
		try {
			size = driver.findElements(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div")).size();

		} catch (Exception e) {
			
		}
		Assert.assertTrue(size >= 2, "Dealers aren't listed");
		
		try {
			size2 = driver.findElements(By.xpath("//*[contains(@class,'map-container-inner')]/div/div/div[1]/div[3]/div/div[3]/div")).size();

		} catch (Exception e) {
			
		}
		Assert.assertTrue(size2 > 0, "Locators on map aren't displayed");
		softAssertion.assertTrue((size - 1) == size2, "Dealers listed isn't match to the locators on map");
		
		driver.findElement(By.xpath("//*[contains(@class,'map-container-inner')]/div/div/div[1]/div[3]/div/div[3]/div[1]/img")).click();
		Thread.sleep(3000);
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'map-container-inner')]/div/div/div[1]/"
					+ "div[3]/div/div[4]/div/div/div/div/button")).isDisplayed();
		}
		catch(Exception e) {
			
		}
		Assert.assertTrue(isActive1, "Check the pop up for the dealer route on the map");
		driver.findElement(By.xpath("//*[contains(@class,'map-container-inner')]/div/div/div[1]/div[3]/div/div[4]/div/div/div/div/button")).click();
		Thread.sleep(3000);
		    softAssertion.assertAll();
	}
	@Test(priority = 88, enabled = true)
	public void dealersListInventoryTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		
		isActive1 = false;
		size = 0;
		
			try {
				getText1 = driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/a/div[2]")).getText();

			} catch (Exception e) {

			}
			Assert.assertTrue(getText1.contains("INVENTORY"), "INVENTORY isn't displayed on dealer's list");
			driver.findElement(By.xpath(".//*[@id='dealersModal']/div/div/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/a/div[2]")).click();
				Thread.sleep(3000);
	
				currentUrl = driver.getCurrentUrl();
				Assert.assertTrue(currentUrl.contains("toyotacertified.com/inventory"), "Search Inventory is redirected to the wrong URL");
				
				
				try {
					isActive1 = driver.findElement(By.xpath(".//*[@id='vehicleFilters']")).isDisplayed();

				} catch (Exception e) {

				}
				Assert.assertTrue(isActive1, "Search Inventory is redirected to the wrong page");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
			    Thread.sleep(2000);
			    
		    softAssertion.assertAll();
	}
}
