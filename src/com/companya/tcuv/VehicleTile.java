 package com.companya.tcuv;

import java.util.Iterator;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VehicleTile extends TCUVTestBase 
{
	@Test(priority = 61, enabled = true)
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
	@Test(priority = 62, enabled = true)
	public void inventoryPageLoadTest() throws InterruptedException {
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
		Assert.assertTrue(getText1.contains("Search Inventory"), "Search Inventory isn't listed under Shopping Tools");
		Thread.sleep(100);
		
		driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[2]/ul/li[1]/a")).click();
		Thread.sleep(4000);
		
		currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("toyotacertified.com/inventory"), "Search Inventory is redirected to the wrong URL");
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='vehicleFilters']")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Search Inventory is redirected to the wrong page");
		
		size = 0;
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/div[2]/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size>=5, "inventory page isn't loading with offer card");
		
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 63, enabled = true)
	public void inventoryDetailPageTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		getText2 = "";
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/div[2]/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size >=5, "Vehicle tile isn't displayed on inventory page"); 
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[1]/a[2]")).isDisplayed();
		}
		catch(Exception e) {
			
		}
		Assert.assertTrue(isActive1, "Check the location of the Vehicle label on the vehicle tile");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[1]/a[2]")).getText();
		driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[1]/a[2]")).click();
		Thread.sleep(4000);
		
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'inventory-details')]/div[2]/div[2]/div[1]")).isDisplayed();
		}
		catch(Exception e) {
			
		}
		Assert.assertTrue(isActive1, "Vehicle label isn't displayed on inventory detail page");
		getText2 = driver.findElement(By.xpath("//*[contains(@class,'inventory-details')]/div[2]/div[2]/div[1]")).getText();
		Assert.assertTrue(getText2.contains(getText1), "The label on inventory detail page doesn't match to the selected vehicle from the list");
		driver.findElement(By.xpath(".//*[@id='vehicleDetailsModal']/div/div/div[1]/a")).click();
		Thread.sleep(5000);
				
		softAssertion.assertAll();
	}
	@Test(priority = 64, enabled = true)
	public void inventoryVehicleTileCarFaxLogoTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[4]/div[1]/div[6]/img")).isDisplayed();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		Assert.assertTrue(isActive1, "Check the location for 'CARFAX Logo' on vehicle tile");
//		Actions action = new Actions(driver);
//		WebElement element = driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img"));
//		
//		action.moveToElement(element).perform();
//		
//		Thread.sleep(4000);
//		try {
//			getText1 = driver.findElement(By.xpath(".//*[@id='carfax-snapshot-popup']/div/div[1]")).getText();
//
//		} catch (Exception e) {
//
//		}
//		Assert.assertTrue(getText1.contains("Snapshot"), "CARFAX Snapshot isn't properly displayed");
//		
//		try {
//			getText1 = driver.findElement(By.xpath(".//*[@id='carfax-snapshot-popup']/div/div[4]/a")).getText();
//
//		} catch (Exception e) {
//
//		}
//		Assert.assertTrue(getText1.contains("FREE CARFAX Report"), "FREE CARFAX Report CTA isn't displayed");
//		driver.findElement(By.xpath(".//*[@id='carfax-snapshot-popup']/div/div[4]/a")).click();
//		Iterator<String> whs = driver.getWindowHandles().iterator();
//		String mainWin = whs.next();
//		String otherWin = whs.next();
//		driver.switchTo().window(otherWin);
//		Thread.sleep(4000);
//		currentUrl = driver.getCurrentUrl();
//		softAssertion.assertTrue(currentUrl.contains("carfax.com"),
//				"| FREE CARFAX Report CTA redirects to wrong page");
//		driver.close();
//		driver.switchTo().window(mainWin);
//		Thread.sleep(3000);
		softAssertion.assertAll();
	}	
	@Test(priority = 65, enabled = true)
	public void inventoryVehicleTileDropdownToggleTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Drop down toggle isn't displayed on vehicle tile");
		driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/a")).click();
		
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[1]/div")).isDisplayed();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		Assert.assertTrue(isActive1, "Check the links under the toggle on vehicle tile");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[1]/div")).getText();
		Assert.assertTrue(getText1.contains("Brochure"), "... Brochure link isn't displayed");
		driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[1]/div")).click();
		Thread.sleep(3000);
		Iterator<String> whs = driver.getWindowHandles().iterator();
		String mainWin = whs.next();
		String otherWin = whs.next();
		driver.switchTo().window(otherWin);
		Thread.sleep(4000);
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("www.toyotacertified.com/assets/ebrochures"),
				"| ... Brochure link redirects to wrong page");
		driver.close();
		driver.switchTo().window(mainWin);
		Thread.sleep(3000);
		
        driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/a")).click();
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[2]/div")).isDisplayed();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		Assert.assertTrue(isActive1, "Check the links under the toggle on vehicle tile");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[2]/div")).getText();
		Assert.assertTrue(getText1.contains("CARFAX"), "CARFAX Report link isn't displayed");
		driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[2]/div")).click();
		Thread.sleep(3000);
		Iterator<String> whs2 = driver.getWindowHandles().iterator();
		String main2Win = whs2.next();
		String other2Win = whs2.next();
		driver.switchTo().window(other2Win);
		Thread.sleep(4000);
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("www.carfax.com"),
				"| CARFAX Report link redirects to wrong page");
		driver.close();
		driver.switchTo().window(main2Win);
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/a")).click();
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[3]/div")).isDisplayed();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		Assert.assertTrue(isActive1, "Check the links under the toggle on vehicle tile");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[3]/div")).getText();
		Assert.assertTrue(getText1.contains("Payment Estimator"), "Payment Estimator link isn't displayed");
		driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[3]/div")).click();
		try {

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(".//*[@id='paymentCalculatorModal']/div/div/div[2]")));
		} catch (Exception e) {

		}
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='paymentCalculatorModal']/div/div/div[2]")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Modal isn't displayed when Payment Estimator link get clicked");
		getText1 = driver.findElement(By.xpath(".//*[@id='paymentCalculatorModal']/div/div/div[2]")).getText();
		Assert.assertTrue(getText1.contains("Payment Estimator"), "Payment Estimator modal isn't properly displayed");
		driver.findElement(By.xpath(".//*[@id='paymentCalculatorModal']/div/div/div[1]/a")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/a")).click();
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[4]/div")).isDisplayed();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		Assert.assertTrue(isActive1, "Check the links under the toggle on vehicle tile");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[4]/div")).getText();
		Assert.assertTrue(getText1.contains("Apply for Credit"), "Apply for Credit link isn't displayed");
		driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[1]/div[2]/div/div/a[4]/div")).click();
		Thread.sleep(3000);
		Iterator<String> whs3 = driver.getWindowHandles().iterator();
		String main3Win = whs3.next();
		String other3Win = whs3.next();
		driver.switchTo().window(other3Win);
		Thread.sleep(4000);
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("www.toyotafinancial.com"),
				"| Apply for Credit link redirects to wrong page");
		driver.close();
		driver.switchTo().window(main3Win);
		Thread.sleep(3000);
		
		
		softAssertion.assertAll();
	}	
	@Test(priority = 66, enabled = false)
	public void inventoryVehicleTileContactDealerTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[5]/div/div[4]/div[2]/div[5]/div/div[2]/a/span[2]")).isDisplayed();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		Assert.assertTrue(isActive1, "Check the location for 'Contact Dealer' on vehicle tile");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[5]/div/div[4]/div[2]/div[5]/div/div[2]/a/span[2]]")).getText();
		Assert.assertTrue(getText1.contains("CONTACT DEALER"), "CONTACT DEALER link isn't displayed");
		driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[5]/div/div[4]/div[2]/div[5]/div/div[2]/a/span[2]")).click();
		try {

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(".//*[@id='dealerContactModal']/div/div/div[2]")));
		} catch (Exception e) {

		}
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='dealerContactModal']/div/div/div[2]")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Modal isn't displayed when Contact Dealer link get clicked");
		getText1 = driver.findElement(By.xpath(".//*[@id='dealerContactModal']/div/div/div[2]")).getText();
		Assert.assertTrue(getText1.contains("Dealer Contact Form"), "Dealer Contact Form  isn't properly displayed");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='dealerContactModal']/div/div/div[1]/a")).click();
		Thread.sleep(4000);
		
		
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 67, enabled = false)
	public void inventoryVehicleTileChatWithDealerTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[4]/div[2]/div[4]/div/div[3]/a/span[2]")).isDisplayed();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		Assert.assertTrue(isActive1, "Check the location for 'CHAT WITH DEALER' on vehicle tile");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[4]/div[2]/div[4]/div/div[3]/a/span[2]")).getText();
		Assert.assertTrue(getText1.contains("CHAT WITH DEALER"), "CHAT WITH DEALER link isn't displayed");
		driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[4]/div[2]/div[4]/div/div[3]/a/span[2]")).click();
		Thread.sleep(3000);
		Iterator<String> whs = driver.getWindowHandles().iterator();
		String mainWin = whs.next();
		String otherWin = whs.next();
		driver.switchTo().window(otherWin);
		Thread.sleep(4000);
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("contactatonce.com"),
				"| CHAT WITH DEALER redirects to wrong page");
		driver.close();
		driver.switchTo().window(mainWin);
		Thread.sleep(4000);
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 68, enabled = false)
	public void inventoryVehicleTileViewDealerInventoryTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[4]/div[2]/div[4]/div/div[5]/a/span[2]")).isDisplayed();

		} catch (Exception e) {

		}
		Thread.sleep(2000);
		Assert.assertTrue(isActive1, "Check the location for 'VIEW DEALER INVENTORY' on vehicle tile");
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[4]/div[2]/div[4]/div/div[5]/a/span[2]")).getText();
		Assert.assertTrue(getText1.contains("VIEW DEALER INVENTORY"), "VIEW DEALER INVENTORY link isn't displayed");
		driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[3]/div/div[4]/div[2]/div[4]/div/div[5]/a/span[2]")).click();
		Thread.sleep(4000);
		currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("dealerCode"), "VIEW DEALER INVENTORY redirected to wrong url");
		
		driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		
		Thread.sleep(3000);
		
		
		softAssertion.assertAll();
	}	
	
	
	
}
