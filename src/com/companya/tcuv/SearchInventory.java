package com.companya.tcuv;

//import java.util.Iterator;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchInventory extends TCUVTestBase
{
	@Test(priority = 41, enabled = true)
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
	@Test(priority = 42, enabled = true)
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
	@Test(priority = 43, enabled = true)
	public void inventoryPageHeaderTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		isActive2 = false;
		isActive3 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'inventory-results')]/div/div[2]/div[1]/div[1]/div")).isDisplayed();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive1, "Vehicles found ...isn't displayed on the title of the inventory page");
		Thread.sleep(1000);
		
		
		
		try {
			isActive2 = driver.findElement(By.xpath("//*[contains(@class,'inventory-results')]/div/div[2]/div[1]/div[2]/div/select")).isDisplayed();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive2, "Distance - Nearest drop down list box isn't displayed on the title of the inventory page");
		Thread.sleep(1000);
		
		
		isActive1 = false;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'inventory-results')]/div/div[2]/div[1]/div[3]/div[1]")).isDisplayed();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive1, "Favs heart icon isn't displayed on the title of the inventory page");
		Thread.sleep(1000);
		
		
		
		try {
			isActive3 = driver.findElement(By.xpath("//*[contains(@class,'inventory-results')]/div/div[2]/div[1]/div[3]/div[2]")).isDisplayed();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(isActive3, "List view icon isn't displayed on the title of the inventory page");
		Thread.sleep(1000);
		
		
		if(isActive2 == true) {
			
			Select listTypes = new Select(driver.findElement(By.xpath("//*[contains(@class,'inventory-results')]/div/div[2]/div[1]/div[2]/div/select")));
			
			Thread.sleep(2000);
			getText1 = listTypes.getFirstSelectedOption().getText();
			softAssertion.assertTrue(getText1.contains("Distance - Nearest"), "Distance - Nearest isn't the default option selected from the list");
			
			listTypes.selectByVisibleText("Price - Highest");
			Thread.sleep(4000);
			
			getText1 = listTypes.getFirstSelectedOption().getText();
			softAssertion.assertTrue(getText1.contains("Price - Highest"), "Price - Highest can't be selected from the list");
			
			listTypes.selectByVisibleText("Year - Highest");
			Thread.sleep(4000);
			
			getText1 = listTypes.getFirstSelectedOption().getText();
			softAssertion.assertTrue(getText1.contains("Year - Highest"), "Year - Highest can't be selected from the list");
			
			listTypes.selectByVisibleText("Distance - Nearest");
			Thread.sleep(4000);
			
			getText1 = listTypes.getFirstSelectedOption().getText();
			softAssertion.assertTrue(getText1.contains("Distance - Nearest"), "Distance - Nearest can't reverted back to the default from the list");
			

		}
		else {
			
		}
		
		if(isActive3 == true) {
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'inventory-results')]"
				+ "/div/div[2]/div[1]/div[3]/div[2]/a[1]/i")).getAttribute("class");
		softAssertion.assertTrue(getText1.contains("active"), "Check the view of inventory results");
		
		driver.findElement(By.xpath("//*[contains(@class,'inventory-results')]"
				+ "/div/div[2]/div[1]/div[3]/div[2]/a[2]")).click();
		Thread.sleep(3000);
		
		getText1 = "";
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'inventory-results')]"
				+ "/div/div[2]/div[1]/div[3]/div[2]/a[2]/i")).getAttribute("class");
		softAssertion.assertTrue(getText1.contains("active"), "Headline view isn't displayed when the icon get clicked");
		driver.findElement(By.xpath("//*[contains(@class,'inventory-results')]"
				+ "/div/div[2]/div[1]/div[3]/div[2]/a[1]")).click();
		Thread.sleep(3000);
		}
		else {
			
		}
		
		isActive2 = false;
		if(isActive1 == true) {
			try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[4]/div/div[1]/div[1]/a[2]")).getText();
			}
			catch(Exception e) {
				
			}
			driver.findElement(By.xpath("//*[contains(@class,'container')]/div[2]/div[4]/div/div[1]/div[1]/a[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(@class,'inventory-results')]/div/div[2]/div[1]/div[3]/div[1]")).click();
			Thread.sleep(3000);
			
			try {
				isActive2 = driver.findElement(By.xpath(".//*[@id='favoritesModal']/div/div/div[2]")).isDisplayed();
				}
				catch(Exception e) {
					
				}
			Assert.assertTrue(isActive2, "FavoriteModal isn't displayed");
			try {
				getText2 = driver.findElement(By.xpath(".//*[contains(@class,'table-striped')]/tbody/tr[1]/td/div")).getText();
				}
				catch(Exception e) {
					
				}
			softAssertion.assertTrue(getText2.equalsIgnoreCase(getText1), "Fav offers doesn't match with the selected vehicle");
			driver.findElement(By.xpath(".//*[@id='favoritesModal']/div/div/div[1]/a")).click();
			Thread.sleep(4000);
		}
		
		softAssertion.assertAll();
	}
	@Test(priority = 44, enabled = true)
	public void inventoryFilterResultsLabelTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='location']")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Location field isn't displayed on Vehicle filters section");
		getText1 = driver.findElement(By.xpath(".//*[@id='location']")).getText();
		//Assert.assertTrue(getText1.contains("75081"), "Zip isn't displayed on Location");
		Thread.sleep(300);
		
		isActive1 = false;
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='distance']")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Distance field isn't displayed on Vehicle filters section");
		Select listMiles = new Select(driver.findElement(By.xpath(".//*[@id='distance']")));
		getText1 = listMiles.getFirstSelectedOption().getText();
		softAssertion.assertTrue(getText1.contains("miles"), "Distance in milage isn't selected under 'Distance'");
		Thread.sleep(300);
		
		isActive1 = false;
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[1]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[1]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Model"), "Model label isn't displayed on Filter list or may be the location is changed");
		Thread.sleep(300);
		
		isActive1 = false;
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[1]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[1]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Model"), "Model label isn't displayed on Filter list or may be the location is changed");
		Thread.sleep(300);
		
		isActive1 = false;
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[1]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[1]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Model"), "Model label isn't displayed on Filter list or may be the location is changed");
		Thread.sleep(300);
		
		isActive1 = false;
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[1]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[1]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Model"), "Model label isn't displayed on Filter list or may be the location is changed");
		Thread.sleep(300);
		
		
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 45, enabled = true)
	public void inventoryFilterResultsModelTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[1]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[1]/a")).getText();
		Assert.assertTrue(getText1.contains("Model"), "Model label isn't displayed on Filter list or may be the location is changed");
		int j=1;
		for(int i=1; i<=10; i++) {
			try {
				isActive1 = driver.findElement(By.xpath(".//*[@id='segment-list']/div[" + i + "]/a")).isDisplayed();

			} catch (Exception e) {

			}
			Assert.assertTrue(isActive1, "Vehicle category is missing under 'Model' - Link : " + j );
			getText1 = driver.findElement(By.xpath(".//*[@id='segment-list']/div[" + i + "]/a")).getText();
			if(i == 1) {
				Assert.assertTrue(getText1.contains("Cars & Minivan"), "Cars & Minivan isn't displayed on Filter list under 'Model'");
			}
			else if(i == 3) {
				Assert.assertTrue(getText1.contains("Trucks"), "Trucks isn't displayed on Filter list under 'Model'");
			}
			else if(i == 5) {
				Assert.assertTrue(getText1.contains("Crossovers & SUVs"), "Crossovers & SUVs isn't displayed on Filter list under 'Model'");
			}
			else if(i == 7) {
				Assert.assertTrue(getText1.contains("Hybrids & FCV"), "Hybrids & FCV isn't displayed on Filter list under 'Model'");
			}
			else if(i == 9) {
				Assert.assertTrue(getText1.contains("Scion by Toyota"), "Scion by Toyota isn't displayed on Filter list under 'Model'");
			}
			
			i++;
			j++;
		}
		
		Thread.sleep(300);
		
		driver.findElement(By.xpath(".//*[@id='segment-list']/div[1]/a")).click();
		Thread.sleep(1000);
		try {
			size = driver.findElements(By.xpath(".//*[@id='invSeg_cars']/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size >=10 , "Vehicle list is missing under Cars & Minivan ");
		driver.findElement(By.xpath(".//*[@id='invSeg_cars']/div[4]/div/label/span/span")).click();
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("Camry"), "Wrong url when Camry's check box get clicked");
		driver.findElement(By.xpath(".//*[@id='invSeg_cars']/div[4]/div/label/span/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='segment-list']/div[1]/a")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(".//*[@id='segment-list']/div[3]/a")).click();
		Thread.sleep(1000);
		try {
			size = driver.findElements(By.xpath(".//*[@id='.//*[@id='invSeg_trucks']/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size >=2 , "Vehicle list is missing under Trucks ");
		driver.findElement(By.xpath(".//*[@id='invSeg_trucks']/div[2]/div/label/span/span")).click();
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("Tacoma"), "Wrong url when Tacoma's check box get clicked");
		driver.findElement(By.xpath(".//*[@id='invSeg_trucks']/div[2]/div/label/span/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='segment-list']/div[3]/a")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(".//*[@id='segment-list']/div[5]/a")).click();
		Thread.sleep(1000);
		try {
			size = driver.findElements(By.xpath(".//*[@id='invSeg_suvs']/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size >=8 , "Vehicle list is missing under Crossovers & SUVs ");
		driver.findElement(By.xpath(".//*[@id='invSeg_suvs']/div[2]/div/label/span/span")).click();
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("4Runner"), "Wrong url when 4Runner's check box get clicked");
		driver.findElement(By.xpath(".//*[@id='invSeg_suvs']/div[2]/div/label/span/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='segment-list']/div[5]/a")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(".//*[@id='segment-list']/div[7]/a")).click();
		Thread.sleep(1000);
		try {
			size = driver.findElements(By.xpath(".//*[@id='invSeg_hybrids']/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size >=10 , "Vehicle list is missing under Hybrids & FCV ");
		driver.findElement(By.xpath(".//*[@id='invSeg_hybrids']/div[2]/div/label/span/span")).click();
		Thread.sleep(3000);  
		currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		softAssertion.assertTrue((currentUrl.contains("Avalon") && currentUrl.contains("Hybrid")), "Wrong url when Avalon Hybrid check box get clicked");
		driver.findElement(By.xpath(".//*[@id='invSeg_hybrids']/div[2]/div/label/span/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='segment-list']/div[7]/a")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(".//*[@id='segment-list']/div[9]/a")).click();
		Thread.sleep(1000);
		try {
			size = driver.findElements(By.xpath(".//*[@id='invSeg_scion']/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size >=7 , "Vehicle list is missing under Scion by Toyota ");
		driver.findElement(By.xpath(".//*[@id='invSeg_scion']/div[2]/div/label/span/span")).click();
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		softAssertion.assertTrue(currentUrl.contains("FR-S"), "Wrong url when FR-S check box get clicked");
		driver.findElement(By.xpath(".//*[@id='invSeg_scion']/div[2]/div/label/span/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='segment-list']/div[9]/a")).click();
		Thread.sleep(3000);
		
		
		
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 46, enabled = true)
	public void inventoryFilterResultsPriceRangeTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[3]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[3]/a")).getText();
		Assert.assertTrue(getText1.contains("Price Range"), "Price Range label isn't displayed on Filter list or may be the location is changed");
		driver.findElement(By.xpath(".//*[@id='filter-list']/div[3]/a")).click();
		Thread.sleep(1000);
		Select priceMin = new Select(driver.findElement(By.xpath(".//*[@id='price-range']/div/div[1]/select")));
		getText1 = priceMin.getFirstSelectedOption().getText();
		softAssertion.assertTrue(getText1.contains("$05,000"), "Check the Minimum price");
		Thread.sleep(300);
		Select priceMax = new Select(driver.findElement(By.xpath(".//*[@id='price-range']/div/div[3]/select")));
		getText1 = priceMax.getFirstSelectedOption().getText();
		softAssertion.assertTrue(getText1.contains("$75,000"), "Check the Maximum price");
		driver.findElement(By.xpath(".//*[@id='filter-list']/div[3]/a")).click();
		Thread.sleep(1000);
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 47, enabled = true)
	public void inventoryFilterResultsModelYearTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[5]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[5]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Model Year"), "Model Year label isn't displayed on Filter list or may be the location is changed");
		driver.findElement(By.xpath(".//*[@id='filter-list']/div[5]/a")).click();
		Thread.sleep(1000);
		Select yearMin = new Select(driver.findElement(By.xpath(".//*[@id='model-year']/div/div[1]/select")));
		getText1 = yearMin.getFirstSelectedOption().getText();
		softAssertion.assertTrue(getText1.contains("2013"), "Check the Minimum year");
		Thread.sleep(300);
		Select yearMax = new Select(driver.findElement(By.xpath(".//*[@id='model-year']/div/div[3]/select")));
		getText1 = yearMax.getFirstSelectedOption().getText();
		softAssertion.assertTrue(getText1.contains("2020"), "Check the Maximum year");
		driver.findElement(By.xpath(".//*[@id='filter-list']/div[5]/a")).click();
		Thread.sleep(1000);
		
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 48, enabled = true)
	public void inventoryFilterResultsMileageTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[7]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[7]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Mileage"), "Mileage label isn't displayed on Filter list or may be the location is changed");
		driver.findElement(By.xpath(".//*[@id='filter-list']/div[7]/a")).click();
		Thread.sleep(1000);
		Select minMileage = new Select(driver.findElement(By.xpath(".//*[@id='mileage']/div/div[1]/select")));
		getText1 = minMileage.getFirstSelectedOption().getText();
		softAssertion.assertTrue(getText1.contains("0"), "Check the Minimum mileage");
		Thread.sleep(300);
		Select maxMileage = new Select(driver.findElement(By.xpath(".//*[@id='mileage']/div/div[3]/select")));
		getText1 = maxMileage.getFirstSelectedOption().getText();
		softAssertion.assertTrue(getText1.contains("85,000"), "Check the Maximum mileage");
		driver.findElement(By.xpath(".//*[@id='filter-list']/div[7]/a")).click();
		Thread.sleep(1000);
		
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 49, enabled = true)
	public void inventoryFilterResultsUpdateCTATest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[5]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list']/div[5]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Model Year"), "Model Year label isn't displayed on Filter list or may be the location is changed");
		driver.findElement(By.xpath(".//*[@id='filter-list']/div[5]/a")).click();
		Thread.sleep(1000);
		Select yearMin = new Select(driver.findElement(By.xpath(".//*[@id='model-year']/div/div[1]/select")));
		yearMin.selectByVisibleText("2018");
		Thread.sleep(1000);

		isActive1 = false;
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='vehicleFilters']/div[2]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the location for SEARCH/UPDATE CTA");
		getText1 = driver.findElement(By.xpath(".//*[@id='vehicleFilters']/div[2]/a")).getText();
		Assert.assertTrue(getText1.contains("SEARCH/UPDATE"), "Check the location for SEARCH/UPDATE CTA");
		driver.findElement(By.xpath(".//*[@id='vehicleFilters']/div[2]/a")).click();
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("Min=2018"), "SEARCH/UPDATE CTA isn't updating the min year selection");
		
		yearMin.selectByVisibleText("2013");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='vehicleFilters']/div[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='filter-list']/div[5]/a")).click();
		Thread.sleep(3000);
		softAssertion.assertAll();
	}
	@Test(priority = 50, enabled = true)
	public void inventoryFilterListMoreDealerTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[1]")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the (More)Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[1]/a")).getText();
		Assert.assertTrue(getText1.contains("Dealer"), "Dealer label isn't displayed on (More)Filter list or may be the location is changed");
		driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[1]")).click();
		Thread.sleep(1000);
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/div[1]/div[3]/div/div[2]/div/div/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size > 0 , "Dealers aren't listed under 'Dealer' on Filter list");
		driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[1]")).click();
		Thread.sleep(2000);
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 51, enabled = true)
	public void inventoryFilterListMoreTrimTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[3]")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the (More)Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[3]/a")).getText();
		Assert.assertTrue(getText1.contains("Trim"), "Trim label isn't displayed on (More)Filter list or may be the location is changed");
		driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[3]")).click();
		Thread.sleep(1000);
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/div[1]/div[3]/div/div[4]/div/div/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size > 0 , "Trim isn't listed under 'Trim' on Filter list");
		driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[3]")).click();
		Thread.sleep(2000);
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 52, enabled = true)
	public void inventoryFilterListMoreExteriorColorTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[5]")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the (More)Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[5]/a")).getText();
		Assert.assertTrue(getText1.contains("Exterior Color"), "Exterior Color label isn't displayed on (More)Filter list or may be the location is changed");
		driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[5]")).click();
		Thread.sleep(1000);
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/div[1]/div[3]/div/div[6]/div/div/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size > 0 , "color isn't listed under 'Exterior Color' on Filter list");
		driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[5]")).click();
		Thread.sleep(2000);
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 53, enabled = true)
	public void inventoryFilterListMoreInteriorColorTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[7]")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the (More)Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[7]/a")).getText();
		Assert.assertTrue(getText1.contains("Interior Color"), "Interior Color label isn't displayed on (More)Filter list or may be the location is changed");
		driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[7]")).click();
		Thread.sleep(1000);
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/div[1]/div[3]/div/div[8]/div/div/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size > 0 , "color isn't listed under 'Interior Color' on Filter list");
		driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[7]")).click();
		Thread.sleep(2000);
		
		
		softAssertion.assertAll();
	}
	@Test(priority = 54, enabled = true)
	public void inventoryFilterListMoreDrivetrainTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		
		getText1 = "";
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[9]")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Check the (More)Filter list");
		getText1 = driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[9]/a")).getText();
		Assert.assertTrue(getText1.contains("Drivetrain"), "Drivetrain label isn't displayed on (More)Filter list or may be the location is changed");
		driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[9]")).click();
		Thread.sleep(1000);
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/div[1]/div[3]/div/div[10]/div/div/div")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size > 0 , "There is no option under 'Drivetrain ' on Filter list");
		driver.findElement(By.xpath(".//*[@id='filter-list-more']/div[9]")).click();
		Thread.sleep(5000);
		
		
		softAssertion.assertAll();
	}
	
}
