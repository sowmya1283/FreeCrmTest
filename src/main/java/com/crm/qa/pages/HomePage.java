package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//PageFactorye
	@FindBy(xpath="//SPAN[@class='user-display'][text()='Sowmya Ankamahadeva']") 
	WebElement name;
	
	@FindBy(xpath="//SPAN[@class='item-text'][text()='Contacts']")
	WebElement contacts;
	
	@FindBy(xpath="//SPAN[@class='item-text'][text()='Tasks']")
	WebElement tasks;
	
	@FindBy(xpath="//SPAN[@class='item-text'][text()='Deals']")
	WebElement deals;
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}
	
	//actions
	//verify homepage title
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		boolean verifyname=name.isDisplayed();
		return verifyname;
	}
	public ContactsPage clickOnContatsLink() {
		contacts.click();	
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		deals.click();
		return new DealsPage();
	}
	
	
}
