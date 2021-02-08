package com.crm.qa.testcases;


import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
LoginPage loginpage;
HomePage homepage;

	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage=new LoginPage();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTilte=homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTilte, "Cogmento CRM", "HomePageTitleNotmatched");
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		boolean username=homepage.verifyUserName();
		Assert.assertTrue(username);
	}
	
	@Test(priority=3)
	public void clickOnContactsPageTest() {
		ContactsPage cp=homepage.clickOnContatsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
