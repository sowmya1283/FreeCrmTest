package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String browser;
	
	public TestBase() {
		
		try {
			prop= new Properties();
			FileInputStream fis=new FileInputStream("F:\\Ireland\\Java_Programs\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void initialization() {
		browser= prop.getProperty("browser");
	
		if(browser.contentEquals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if(browser.contentEquals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();
		}
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	driver.get(prop.getProperty("url"));
	
	}
}

