package com.companya.tcuv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class TCUVTestBase 
{
    protected WebDriver driver;
    boolean isActive1 = false;
    boolean isActive2 = false;
    boolean isActive3 = false;
    int size = 0;
    String getText1, getText2, getText3, getText4, getText5, getText6, getText7, currentUrl, expectedCurrentUrl;
    String url = "https://www.toyotacertified.com";
	String expectedUrl, actualUrl;
	@BeforeSuite
	public void beforeStart() throws InterruptedException, FileNotFoundException, IOException {

	

	}
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.toyotacertified.com");
	}
	@AfterClass
	public void afterClass() throws InterruptedException {
		// driver.findElement(By.xpath(".//*[@id='toyota-dealers']")).click();
		// Thread.sleep(3000);
		driver.close();
	}
	@AfterSuite
	public void afterSuite() throws InterruptedException, FileNotFoundException, IOException {

		 //driver.close();

	}
}
