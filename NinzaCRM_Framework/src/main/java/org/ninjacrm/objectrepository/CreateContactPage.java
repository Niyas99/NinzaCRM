package org.ninjacrm.objectrepository;

import org.ninjacrm.weddriverutility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriverUtility wlib = new WebDriverUtility();
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[.='Create Contact']")
	private WebElement createContactButton;

	@FindBy(xpath="//input[@name='organizationName']")
	private WebElement organizationNameTextfield;
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement titleTextfield;
	
	@FindBy(xpath="//input[@name='department']")
	private WebElement departmentTextfield;
	
	@FindBy(xpath="//input[@name='officePhone']")
	private WebElement officePhoneTextfield;
	
	@FindBy(xpath="//input[@name='contactName']")
	private WebElement contactNameTextfield;
	
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement mobileTextField;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTextfield;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement campaignSelectButton;
	
	@FindBy(id="search-input")
	private WebElement campaignSearchTextfield;
	
	@FindBy(xpath = "//button[@class='select-btn']")
	private WebElement selectButton;
	
	@FindBy(xpath="//button[.='Create Contact']")
	private WebElement createButton;
	
	public WebElement getCreateContactButton() {
		return createContactButton;
	}

	public WebElement getOrganizationNameTextfield() {
		return organizationNameTextfield;
	}

	public WebElement getTitleTextfield() {
		return titleTextfield;
	}

	public WebElement getDepartmentTextfield() {
		return departmentTextfield;
	}

	public WebElement getOfficePhoneTextfield() {
		return officePhoneTextfield;
	}

	public WebElement getContactNameTextfield() {
		return contactNameTextfield;
	}

	public WebElement getMobileTextField() {
		return mobileTextField;
	}

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getCampaignSelectButton() {
		return campaignSelectButton;
	}

	public WebElement getCampaignSearchTextfield() {
		return campaignSearchTextfield;
	}

	public WebElement getSelectButton() {
		return selectButton;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

	
	public void createContactAllField(WebDriver driver,String organization,String title,String department,String officePhone,String contactName,String mobile,String email,String campaign) throws Throwable {
		wlib.safeClick(driver, createContactButton);
//		createContactButton.click();
		organizationNameTextfield.sendKeys(organization);
		titleTextfield.sendKeys(title);
		departmentTextfield.sendKeys(department);
		officePhoneTextfield.sendKeys(officePhone);
		contactNameTextfield.sendKeys(contactName);
		mobileTextField.sendKeys(mobile);
		emailTextfield.sendKeys(email);
		wlib.safeClick(driver, campaignSelectButton);
//		campaignSelectButton.click();
		
		
		
		wlib.switchToWindow(driver);
		Thread.sleep(2000);
		campaignSearchTextfield.sendKeys(campaign);
		Thread.sleep(2000);
		wlib.safeClick(driver, selectButton);
//		selectButton.click();
		wlib.switchToWindow(driver);
		wlib.safeClick(driver, createButton);
//		createButton.click();
		
	}
	
	
	public void createContactMandatoryField(WebDriver driver,String organization,String title,String contactName,String mobile,String campaign) throws Throwable {
		wlib.safeClick(driver, createContactButton);
//		createContactButton.click();
		organizationNameTextfield.sendKeys(organization);
		titleTextfield.sendKeys(title);
		contactNameTextfield.sendKeys(contactName);
		mobileTextField.sendKeys(mobile);
		wlib.safeClick(driver, campaignSelectButton);
//		campaignSelectButton.click();
		
		wlib.switchToWindow(driver);
		Thread.sleep(2000);
		campaignSearchTextfield.sendKeys(campaign);
		Thread.sleep(2000);
		wlib.safeClick(driver, selectButton);
//		selectButton.click();
		wlib.switchToWindow(driver);
		wlib.safeClick(driver, createButton);
//		createButton.click();
		
	}
	
	public void createContactNoField(WebDriver driver) {

		wlib.safeClick(driver, createContactButton);
		wlib.safeClick(driver, createButton);
		
		
	}

}
