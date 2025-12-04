package org.ninjacrm.objectrepository;

import org.ninjacrm.weddriverutility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage {
	WebDriverUtility wlib= new WebDriverUtility();
	public CreateLeadPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[.='Create Lead']")
	private WebElement createLeadButton;

	@FindBy(xpath="//input[@name='name']")
	private WebElement leadNameTextfield;
	
	@FindBy(xpath="//input[@name='company']")
	private WebElement companyTextfield;
	
	@FindBy(xpath="//input[@name='leadSource']")
	private WebElement leadSourceTextfield;
	
	@FindBy(xpath="//input[@name='industry']")
	private WebElement industryTextfield;
	
	@FindBy(xpath="//input[@name='annualRevenue']")
	private WebElement annualRevenueTextfield;
	
	@FindBy(xpath="//input[@name='noOfEmployees']")
	private WebElement noOfEmployeesTextField;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneTextfield;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTextField;
	
	@FindBy(xpath="//input[@name='secondaryEmail']")
	private WebElement secondaryEmailTextField;
	
	@FindBy(xpath="//input[@name='leadStatus']")
	private WebElement leadStatusTextfield;
	
	@FindBy(xpath="//input[@name='rating']")
	private WebElement ratingTextfield;
	
	@FindBy(xpath="//input[@name='assignedTo']")
	private WebElement assignedToTextfield;
	
	@FindBy(xpath="//textarea[@name='address']")
	private WebElement addressTextField;
	
	@FindBy(xpath="//input[@name='city']")
	private WebElement cityTextfield;
	
	@FindBy(xpath="//input[@name='country']")
	private WebElement countryTextField;
	
	@FindBy(xpath="//input[@name='postalCode']")
	private WebElement postalCodeTextField;
	
	@FindBy(xpath="//input[@name='website']")
	private WebElement websiteTextField;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement campaignSelectButton;
	
	@FindBy(id = "search-input")
	private WebElement campaignSearchTextfield;
	
	@FindBy(xpath="//button[@class='select-btn']")
	private WebElement SelectButton;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement descriptionTextfield;
	
	@FindBy(xpath="//button[.='Create Lead']")
	private WebElement createButton;

	public WebElement getCreateLeadButton() {
		return createLeadButton;
	}

	public WebElement getLeadNameTextfield() {
		return leadNameTextfield;
	}

	public WebElement getCompanyTextfield() {
		return companyTextfield;
	}

	public WebElement getLeadSourceTextfield() {
		return leadSourceTextfield;
	}

	public WebElement getIndustryTextfield() {
		return industryTextfield;
	}

	public WebElement getAnnualRevenueTextfield() {
		return annualRevenueTextfield;
	}

	public WebElement getNoOfEmployeesTextField() {
		return noOfEmployeesTextField;
	}

	public WebElement getPhoneTextfield() {
		return phoneTextfield;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getCampaignSelectButton() {
		return campaignSelectButton;
	}

	public WebElement getCampaignSearchTextfield() {
		return campaignSearchTextfield;
	}

	public WebElement getSelectButton() {
		return SelectButton;
	}

	public WebElement getDescriptionTextfield() {
		return descriptionTextfield;
	}

	public WebElement getCreateButton() {
		return createButton;
	}
	
	public WebElement getSecondaryEmailTextField() {
		return secondaryEmailTextField;
	}

	public WebElement getLeadStatusTextfield() {
		return leadStatusTextfield;
	}

	public WebElement getRatingTextfield() {
		return ratingTextfield;
	}

	public WebElement getAssignedToTextfield() {
		return assignedToTextfield;
	}

	public WebElement getAddressTextField() {
		return addressTextField;
	}

	public WebElement getCityTextfield() {
		return cityTextfield;
	}

	public WebElement getCountryTextField() {
		return countryTextField;
	}

	public WebElement getPostalCodeTextField() {
		return postalCodeTextField;
	}

	public WebElement getWebsiteTextField() {
		return websiteTextField;
	}

	public void createLeadsAllFields(WebDriver driver , String leadName , String company, String leadSource, String industry, String anualReview, String noOfEmp, String phone, String email, String secondaryEmail, String leadStatus, String rating, String assignedTo, String address, String city, String country, String postalCode, String Website, String campaign,String description) throws InterruptedException {
		
		
//		createLeadButton.click();
		wlib.safeClick(driver, createLeadButton);
		leadNameTextfield.sendKeys(leadName);
		companyTextfield.sendKeys(company);
		leadSourceTextfield.sendKeys(leadSource);
		industryTextfield.sendKeys(industry);
		annualRevenueTextfield.clear();
		annualRevenueTextfield.sendKeys(anualReview);
		noOfEmployeesTextField.clear();
		noOfEmployeesTextField.sendKeys(noOfEmp);
		phoneTextfield.sendKeys(phone);
		emailTextField.sendKeys(email);
		secondaryEmailTextField.sendKeys(secondaryEmail);
		leadStatusTextfield.sendKeys(leadStatus);
		ratingTextfield.clear();
		ratingTextfield.sendKeys(rating);
		assignedToTextfield.sendKeys(assignedTo);
		addressTextField.sendKeys(address);
		cityTextfield.sendKeys(city);
		countryTextField.sendKeys(country);
		postalCodeTextField.sendKeys(postalCode);
		websiteTextField.sendKeys(Website);
		
		wlib.safeClick(driver, campaignSelectButton);
//		campaignSelectButton.click();
		
		wlib.switchToWindow(driver);
		Thread.sleep(2000);
		campaignSearchTextfield.sendKeys(campaign);
		Thread.sleep(2000);
		wlib.safeClick(driver, SelectButton);
//		SelectButton.click();
		wlib.switchToWindow(driver);
		descriptionTextfield.sendKeys(description);
		wlib.safeClick(driver, createButton);
//		createButton.click();
		
		
	}
	public void createLeadsMandatoryFields(WebDriver driver , String leadName , String company, String leadSource, String industry,String phone,String leadStatus,String campaign) throws Throwable {
			
			
//			createLeadButton.click();
			wlib.safeClick(driver, createLeadButton);
			leadNameTextfield.sendKeys(leadName);
			companyTextfield.sendKeys(company);
			leadSourceTextfield.sendKeys(leadSource);
			industryTextfield.sendKeys(industry);
			phoneTextfield.sendKeys(phone);
			leadStatusTextfield.sendKeys(leadStatus);
			wlib.safeClick(driver, campaignSelectButton);
//			campaignSelectButton.click();
			
			wlib.switchToWindow(driver);
			Thread.sleep(2000);
			campaignSearchTextfield.sendKeys(campaign);
			Thread.sleep(2000);
			wlib.safeClick(driver, SelectButton);
//			SelectButton.click();
			wlib.switchToWindow(driver);
			wlib.safeClick(driver, createButton);
//			createButton.click();		
			
	}
	public void createLeadsNoFields(WebDriver driver) {		
		wlib.safeClick(driver, createLeadButton);
		wlib.safeClick(driver, createButton);
		
		
	}
}
