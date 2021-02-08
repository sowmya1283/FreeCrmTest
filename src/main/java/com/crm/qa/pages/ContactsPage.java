package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="(//BUTTON[@class='ui linkedin button'])[3]")
	WebElement newbutton;
	
	//initializing page object
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
}
