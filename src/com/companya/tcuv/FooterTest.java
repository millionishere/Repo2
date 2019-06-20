package com.companya.tcuv;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FooterTest extends TCUVTestBase 
{
	@Test(priority = 31, enabled = true)
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
	@Test(priority = 32, enabled = true)
	public void footerVehiclesTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			getText1 = driver.findElement(By.xpath(".//*[@id='col1Toggle']/div/h4")).getText();

		} catch (Exception e) {

		}
		Assert.assertTrue(getText1.contains("Vehicles"), "Vehicles on Footer isn't displayed");
		
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/div[1]/div/div/div/div/ul/li")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size == 7, "Links are missing on Footer Vehicles");
		Thread.sleep(1000);
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[1]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The first link element is missing under 'All Vehicles'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[1]/a")).getText();
		softAssertion.assertTrue(getText1.contains("All Vehicles"), "All Vehicles on Footer Vehicles isn't displayed");
		if(getText1.contains("All Vehicles")) {
			driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[1]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/models"), "All Vehicles is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'content-area')]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Cars, Trucks, Hybrids & SUVS"), "All Vehicles is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[2]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The second link element is missing under 'All Vehicles'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[2]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Cars & Minivan"), "Cars & Minivan on Footer Vehicles isn't displayed");
		if(getText1.contains("Cars & Minivan")) {
			driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[2]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/cars"), "Cars & Minivan is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Used Toyota Cars for Sale"), "Cars & Minivan is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[3]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The third link element is missing under 'All Vehicles'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[3]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Trucks"), "Trucks on Footer Vehicles isn't displayed");
		if(getText1.contains("Trucks")) {
			driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[3]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/trucks"), "Trucks is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Used Toyota Trucks"), "Trucks is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[4]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The fourth link element is missing under 'All Vehicles'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[4]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Crossovers"), "Crossovers on Footer Vehicles isn't displayed");
		if(getText1.contains("Crossovers")) {
			driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[4]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/suvs"), "Crossovers is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Used Toyota Suvs"), "Crossovers is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[5]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The fifth link element is missing under 'All Vehicles'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[5]/a")).getText();
		softAssertion.assertTrue(getText1.contains("SUVs"), "SUVs on Footer Vehicles isn't displayed");
		if(getText1.contains("SUVs")) {
			driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[5]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/suvs"), "SUVs is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Used Toyota Suvs"), "SUVs is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[6]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The sixth link element is missing under 'All Vehicles'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[6]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Hybrids"), "Hybrids on Footer Vehicles isn't displayed");
		if(getText1.contains("Hybrids")) {
			driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[6]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/hybrids"), "Hybrids is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Browse Used Hybrids"), "Hybrids is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[7]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The seventh link element is missing under 'All Vehicles'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[7]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Scion By Toyota"), "Scion By Toyota on Footer Vehicles isn't displayed");
		if(getText1.contains("Scion By Toyota")) {
			driver.findElement(By.xpath(".//*[@id='col1']/div/ul/li[7]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/scion"), "Scion By Toyota is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Used Scion For Sale"), "Scion By Toyota is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		
        softAssertion.assertAll();
	}
	@Test(priority = 33, enabled = true)
	public void footerResourcesTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			getText1 = driver.findElement(By.xpath(".//*[@id='col2Toggle']/div/h4")).getText();

		} catch (Exception e) {

		}
		Assert.assertTrue(getText1.contains("Resources"), "Resources on Footer isn't displayed");
		
		try {
			size = driver.findElements(By.xpath(".//*[@id='col2'][contains(@class,'panel-collapse')]/div/ul/li")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size == 7, "Links are missing on Footer Resources");
		Thread.sleep(1000);
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[1]/b/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The first link element is missing under 'Resources'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[1]/b/a")).getText();
		softAssertion.assertTrue(getText1.contains("Search Inventory"), "Search Inventory on Footer Resources isn't displayed");
		if(getText1.contains("Search Inventory")) {
			driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[1]/b/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/inventory"), "Search Inventory is redirected to wrong url");
		    try {
		    	isActive1 = driver.findElement(By.xpath(".//*[@id='vehicleFilters']")).isDisplayed();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(isActive1, "Search Inventory is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[2]/b/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The second link element is missing under 'Resources'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[2]/b/a")).getText();
		softAssertion.assertTrue(getText1.contains("Find Local Specials"), "Find Local Specials on Footer Resources isn't displayed");
		if(getText1.contains("Find Local Specials")) {
			driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[2]/b/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/local-specials"), "Find Local Specials is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'local-specials')]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Used Car Offers Near You"), "Find Local Specials is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[3]/b/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The third link element is missing under 'Resources'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[3]/b/a")).getText();
		softAssertion.assertTrue(getText1.contains("Find a Dealer"), "Find a Dealer on Footer Resources isn't displayed");
		if(getText1.contains("Find a Dealer")) {
			driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[3]/b/a")).click();
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
			Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[4]/b/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The fourth link element is missing under 'Resources'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[4]/b/a")).getText();
		softAssertion.assertTrue(getText1.contains("Financial Tools"), "Financial Tools on Footer Resources isn't displayed");
		if(getText1.contains("Financial Tools")) {
			driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[4]/b/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/toyota-financial-services"), "Financial Tools is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'roadside')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Toyota Financial Services"), "Financial Tools is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[5]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The fifth link element is missing under 'Resources'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[5]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Entune"), "Entune on Footer Resources isn't displayed");
		if(getText1.contains("Entune")) {
			driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[5]/a")).click();
		    Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(4000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("toyota.com/audio-multimedia"),
					"| Entune redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[6]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The sixth link element is missing under 'Resources'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[6]/a")).getText();
		softAssertion.assertTrue(getText1.contains("FAQs"), "FAQs on Footer Resources isn't displayed");
		if(getText1.contains("FAQs")) {
			driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[6]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/faq"), "FAQs is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Read FAQs About"), "FAQs is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[7]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The seventh link element is missing under 'Resources'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[7]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Car Tips"), "Car Tips on Footer Resources isn't displayed");
		if(getText1.contains("Car Tips")) {
			driver.findElement(By.xpath(".//*[@id='col2']/div/ul/li[7]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/car-tips"), "Car Tips is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Things You Should Know Before"), "Car Tips is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		
		
		
        softAssertion.assertAll();
	}	
	@Test(priority = 34, enabled = true)
	public void footerCertifiedProgramTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			getText1 = driver.findElement(By.xpath(".//*[@id='col3Toggle']/div/h4")).getText();

		} catch (Exception e) {

		}
		Assert.assertTrue(getText1.contains("Certified Program"), "Certified Program on Footer isn't displayed");
		
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/div[1]/div/div/div/div/ul/li")).size();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(size >= 5, "Links are missing on Footer Certified Program");
		Thread.sleep(1000);
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[1]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The first link element is missing under 'Certified Program'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[1]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Certification"), "Certification on Footer Certified Program isn't displayed");
		if(getText1.contains("Certification")) {
			driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[1]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/certification"), "Certification is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Toyota Used Car Certification"), "Certification is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[2]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The second link element is missing under 'Certified Program'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[2]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Warranty"), "Warranty on Footer Certified Program isn't displayed");
		if(getText1.contains("Warranty")) {
			driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[2]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/warranty"), "Warranty is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Warranty"), "Warranty is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[3]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The third link element is missing under 'Certified Program'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[3]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Point Inspection"), "...Point Inspection on Footer Certified Program isn't displayed");
		if(getText1.contains("Point Inspection")) {
			driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[3]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/160-point-inspection"), "...Point Inspection is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Point Inspection"), "...Point Inspection is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[4]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The fourth link element is missing under 'Certified Program'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[4]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Roadside Assistance"), "Roadside Assistance on Footer Certified Program isn't displayed");
		if(getText1.contains("Roadside Assistance")) {
			driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[4]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/roadside-assistance"), "Roadside Assistance is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Roadside Assistance"), "Roadside Assistance is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[5]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The fifth link element is missing under 'Certified Program'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[5]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Vehicle History Report"), "Vehicle History Report on Footer Certified Program isn't displayed");
		if(getText1.contains("Vehicle History Report")) {
			driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[5]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/vehicle-history-report"), "Vehicle History Report is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Vehicle History Report"), "Vehicle History Report is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		/*try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[6]/a")).isDisplayed();

		} catch (Exception e) {

		}
		
		getText1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[6]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Certified Program Brochure"), "Certified Program Brochure on Footer Certified Program isn't displayed");
		if(getText1.contains("Certified Program Brochure")) {
			driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[6]/a")).click();
			Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.toyotacertified.com"),
					"| Certified Program Brochure redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}*/
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[6]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The sixth link element is missing under 'Certified Program'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[6]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Vehicle Service Agreements"), "Vehicle Service Agreements on Footer Certified Program isn't displayed");
		if(getText1.contains("Vehicle Service Agreements")) {
			driver.findElement(By.xpath(".//*[@id='col3']/div/ul/li[6]/a")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("toyotacertified.com/vehicle-service-agreements"), "Vehicle Service Agreements is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Vehicle Service Agreements"), "Vehicle Service Agreements is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(2000);
		}
		else {
			
		}
		
		
		
        softAssertion.assertAll();
	}
	@Test(priority = 35, enabled = true)
	public void footerAboutToyotaTest() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			getText1 = driver.findElement(By.xpath(".//*[@id='col4Toggle']/div/h4")).getText();

		} catch (Exception e) {

		}
		Assert.assertTrue(getText1.contains("About Toyota"), "About Toyota on Footer isn't displayed");
		
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'container')]/div[4]/div/div/div/div/ul/li")).size();

		} catch (Exception e) {

		}
		
		Assert.assertTrue(size >= 8, "Links are missing on Footer About Toyota");
		Thread.sleep(1000);
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[1]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The first link element is missing under 'About Toyota'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[1]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Our Company"), "Our Company on Footer About Toyota isn't displayed");
		if(getText1.contains("Our Company")) {
			driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[1]/a")).click();
		    Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.toyota.com/usa/"),
					"| Our Company redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[2]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The second link element is missing under 'About Toyota'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[2]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Toyota Rent a Car"), "Toyota Rent a Car on Footer Certified Program isn't displayed");
		if(getText1.contains("Toyota Rent a Car")) {
			driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[2]/a")).click();
			Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.toyota.com/rental"),
					"| Toyota Rent a Car redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[3]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The third link element is missing under 'About Toyota'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[3]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Toyota Mobility"), "Toyota Mobility on Footer Certified Program isn't displayed");
		if(getText1.contains("Toyota Mobility")) {
			driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[3]/a")).click();
			Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.toyotamobility.com"),
					"| Toyota Mobility redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[4]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The fourth link element is missing under 'About Toyota'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[4]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Toyota Financial Services"), "Toyota Financial Services on Footer Certified Program isn't displayed");
		if(getText1.contains("Toyota Financial Services")) {
			driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[4]/a")).click();
			Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.toyotafinancial.com/us"),
					"| Toyota Financial Services redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[5]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The fifth link element is missing under 'About Toyota'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[5]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Toyota Certified Canada"), "Toyota Certified Canada on Footer Certified Program isn't displayed");
		if(getText1.contains("Toyota Certified Canada")) {
			driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[5]/a")).click();
			Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.toyotacertified.ca/"),
					"| Toyota Certified Canada redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[6]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The sixth link element is missing under 'About Toyota'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[6]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Toyota Worldwide"), "Toyota Worldwide on Footer Certified Program isn't displayed");
		if(getText1.contains("Toyota Worldwide")) {
			driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[6]/a")).click();
			Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("global.toyota/en"),
					"| Toyota Worldwide redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[7]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The seventh link element is missing under 'About Toyota'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[7]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Toyota.com"), "Toyota.com on Footer Certified Program isn't displayed");
		if(getText1.contains("Toyota.com")) {
			driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[7]/a")).click();
			Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.toyota.com"),
					"| Toyota.com redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[8]/a")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "The 8th link element is missing under 'About Toyota'");
		getText1 = driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[8]/a")).getText();
		softAssertion.assertTrue(getText1.contains("Safety Recalls & Service Campaigns"), "Safety Recalls & Service Campaigns on Footer Certified Program isn't displayed");
		if(getText1.contains("Safety Recalls & Service Campaigns")) {
			driver.findElement(By.xpath(".//*[@id='col4']/div/ul/li[8]/a")).click();
			Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("toyota.com/recall"),
					"| Safety Recalls & Service Campaigns redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		
		
        softAssertion.assertAll();
	}
	@Test(priority = 36, enabled = true)
	public void appFooter() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'social')]")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Social section isn't displayed on Footer");
		
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'social')]/ul/li")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size == 5, "social icons are missing on Footer");
		Thread.sleep(1000);
		
		
		try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'social')]/ul/li[1]/a/div")).getAttribute("class");

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("facebook"), "Facebook on social section isn't displayed");
		if(getText1.contains("facebook")) {
			driver.findElement(By.xpath("//*[contains(@class,'social')]/ul/li[1]/a/div")).click();
		    Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.facebook.com/toyota"),
					"| Facebook redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'social')]/ul/li[2]/a/div")).getAttribute("class");

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("youtube"), "YouTube on social section isn't displayed");
		if(getText1.contains("youtube")) {
			driver.findElement(By.xpath("//*[contains(@class,'social')]/ul/li[2]/a/div")).click();
		    Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.youtube.com"),
					"| YouTube redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'social')]/ul/li[3]/a/div")).getAttribute("class");

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("twitter"), "Twitter on social section isn't displayed");
		if(getText1.contains("twitter")) {
			driver.findElement(By.xpath("//*[contains(@class,'social')]/ul/li[3]/a/div")).click();
		    Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("twitter.com/toyota"),
					"| Twitter redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'social')]/ul/li[4]/a/div")).getAttribute("class");

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("googleplus"), "GooglePlus on social section isn't displayed");
		if(getText1.contains("googleplus")) {
			driver.findElement(By.xpath("//*[contains(@class,'social')]/ul/li[4]/a/div")).click();
		    Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("accounts.google.com"),
					"| GooglePlus redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'social')]/ul/li[5]/a/div")).getAttribute("class");

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("instagram"), "Instagram on social section isn't displayed");
		if(getText1.contains("instagram")) {
			driver.findElement(By.xpath("//*[contains(@class,'social')]/ul/li[5]/a/div")).click();
		    Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.instagram.com"),
					"| Instagram redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		
		
		
		
        softAssertion.assertAll();
	}
	@Test(priority = 37, enabled = true)
	public void secondaryFooter() throws InterruptedException {
		SoftAssert softAssertion = new SoftAssert();
		isActive1 = false;
		size = 0;
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'disclaimer')]/div")).isDisplayed();

		} catch (Exception e) {

		}
		Assert.assertTrue(isActive1, "Secondary footer section isn't displayed on the page");
		
		try {
			size = driver.findElements(By.xpath("//*[contains(@class,'disclaimer')]/div/div[1]/a")).size();

		} catch (Exception e) {

		}
		Assert.assertTrue(size == 3, "Links under secondary footer section is missing on Footer");
		Thread.sleep(1000);
		
		
		try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'disclaimer')]/div/div[1]/a[1]")).getText();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("Privacy Policy"), "Privacy Policy on secondary footer isn't displayed");
		if(getText1.contains("Privacy Policy")) {
			driver.findElement(By.xpath("//*[contains(@class,'disclaimer')]/div/div[1]/a[1]")).click();
		    Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.toyota.com/support/privacy"),
					"| Privacy Policy redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			getText1 = driver.findElement(By.xpath("//*[contains(@class,'disclaimer')]/div/div[1]/a[2]")).getText();

		} catch (Exception e) {

		}
		softAssertion.assertTrue(getText1.contains("Legal Terms"), "Legal Terms on secondary footer isn't displayed");
		if(getText1.contains("Legal Terms")) {
			driver.findElement(By.xpath("//*[contains(@class,'disclaimer')]/div/div[1]/a[2]")).click();
		    Thread.sleep(3000);
		    Iterator<String> whs = driver.getWindowHandles().iterator();
			String mainWin = whs.next();
			String otherWin = whs.next();
			driver.switchTo().window(otherWin);
			Thread.sleep(3000);
			currentUrl = driver.getCurrentUrl();
			softAssertion.assertTrue(currentUrl.contains("www.toyota.com/support/legal"),
					"| Legal Terms redirects to wrong page");
			driver.close();
			driver.switchTo().window(mainWin);
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		try {
			isActive1 = driver.findElement(By.xpath("//*[contains(@class,'disclaimer')]/div/div[1]/a[3]")).isDisplayed();

		} catch (Exception e) {

		}
		getText1 = driver.findElement(By.xpath("//*[contains(@class,'disclaimer')]/div/div[1]/a[3]")).getText();
		softAssertion.assertTrue(getText1.contains("Site Map"), "Site Map on secondary isn't displayed");
		if(getText1.contains("Site Map")) {
			driver.findElement(By.xpath("//*[contains(@class,'disclaimer')]/div/div[1]/a[3]")).click();
		    Thread.sleep(3000);
		    currentUrl = driver.getCurrentUrl();
		    softAssertion.assertTrue(currentUrl.contains("www.toyotacertified.com/sitemap"), "Site Map is redirected to wrong url");
		    try {
		    	getText1 = driver.findElement(By.xpath("//*[contains(@class,'container')]/div[1]/div[1]/h1")).getText();
		    }
		    catch(Exception e) {
		    	
		    }
		    softAssertion.assertTrue(getText1.contains("Site Map"), "Site Map is redirected to wrong page");
		    driver.findElement(By.xpath("//*[contains(@class,'navbar-brand navbar-logo')]/img")).click();
		    Thread.sleep(3000);
		}
		else {
			
		}
		
		
		
		
		
		
		
        softAssertion.assertAll();
	}


}
