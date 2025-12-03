package org.ninjacrm.objectrepository;

import org.ninjacrm.weddriverutility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.='Leads']")
	private WebElement leadsLink;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactsLink;
	
	@FindBy(xpath="//a[.='Campaigns']")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//a[.='Opportunities']")
	private WebElement opportunitiesLink;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement productsLink;
	
	@FindBy(xpath="//a[.='Quotes']")
	private WebElement quotesLink;
	
	@FindBy(xpath="//a[.='Purchase Order']")
	private WebElement purchaseOrderLink;
	
	@FindBy(xpath="//a[.='Sales Order']")
	private WebElement salesOrderLink;
	
	@FindBy(xpath="//a[.='Invoice']")
	private WebElement invoiceLink;
	
	@FindBy(xpath="//li[.='Admin Console']")
	private WebElement adminConsoleList;
	
	@FindBy(xpath="//*[name()='svg']")
	private WebElement profileIcon;

	@FindBy(xpath="//div[.='Logout ']")
	private WebElement logOutLink;
	
	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement closeButton;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toastMessage;
	
	
	public WebElement getToastMessage() {
		return toastMessage;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getQuotesLink() {
		return quotesLink;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getSalesOrderLink() {
		return salesOrderLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getAdminConsoleList() {
		return adminConsoleList;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}
	public WebElement getLogOutLink() {
		return logOutLink;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}
	
	public void logOut(WebDriver driver) {
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.clickableWait(driver, closeButton);
		wlib.clickableWait(driver, profileIcon);
		wlib.clickableWait(driver, logOutLink);
	}
	
	public void logOutNoAlert(WebDriver driver) {
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.clickableWait(driver, profileIcon);
		wlib.clickableWait(driver, logOutLink);
	}
	

}
