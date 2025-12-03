package org.ninjacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Declaration
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Initialization
	@FindBy(id="username")
	private WebElement userNameTextfield;
	
	@FindBy(id="inputPassword")
	private WebElement passwordTextfield;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signInButton;

	public WebElement getUserNameTextfield() {
		return userNameTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}
	
	
	
	
}
