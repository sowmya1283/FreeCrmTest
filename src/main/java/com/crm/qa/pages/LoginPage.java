package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page Factory= OR;  @FindBy(id = "foobar") WebElement foobar;
	@FindBy(name="email") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//A[@href='https://ui.cogmento.com']") WebElement loginlink;
	@FindBy(xpath="//span[contains(@class 'brand-slogan')]") WebElement crmlogo;	
	@FindBy(xpath="//DIV[@class='ui fluid large blue submit button'][text()='Login']") WebElement loginButton;
	
	//Initializing thepage factory
	public LoginPage() {
		PageFactory.initElements(driver, this);//It will initialize the pageFactory elements, How to initialize page factory?
		
	}
	
	//Different functionality of Login page, Actions
		public String validateLoginPageTitle() {
				return driver.getTitle();
		}
	
		public boolean validateCRMImage() {
			return crmlogo.isDisplayed();
		}
	
		public HomePage login(String un, String pw) {
			loginlink.click();
			username.sendKeys(un);
			password.sendKeys(pw);
			loginButton.click();
			return new HomePage();
		}

}
