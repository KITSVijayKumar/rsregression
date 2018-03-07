package com.kingfisher.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.kingfisher.coreFramework.AbstractWebPage;

public class RSperfLoginPage extends AbstractWebPage {

	@FindBy(how = How.CSS, using = "#login") 
	private WebElement userNameField;
	
	@FindBy(how = How.CSS, using = "#password")
	private WebElement userPasswordField;
	
	@FindBy(how = How.CSS, using = "#btnlogin")
	private WebElement loginBtn;
	
	
	public RSperfLoginPage(WebDriver driver){
		super(driver);
	}
	
	
	public void enterUserName(String userName){
		userNameField.sendKeys(userName);
	}
	public void enterPassword(String password){
		 userPasswordField.sendKeys(password);
	}
	public RSperfLandingPage clickLogin(){
		loginBtn.click();
		return new RSperfLandingPage(driver);
	}
}
