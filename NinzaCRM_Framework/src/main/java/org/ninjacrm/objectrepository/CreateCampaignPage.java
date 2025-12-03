package org.ninjacrm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[.='Create Campaign']")
	private WebElement createCampaignButton;

	@FindBy(xpath="//input[@name='campaignName']")
	private WebElement campaignNameTextfield;
	
	@FindBy(xpath="//input[@name='targetSize']")
	private WebElement targetSizeTextfield;
	
	@FindBy(xpath="//input[@name='expectedCloseDate']")
	private WebElement expectedCloseDateTextfield;
	
	@FindBy(xpath="//input[@name='campaignStatus']")
	private WebElement campaignStatusTextfield;
	
	@FindBy(xpath="//input[@name='targetAudience']")
	private WebElement targetAudienceTextfield;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement descriptionTextField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement createButton;
	
	public WebElement getCreateCampaignButton() {
		return createCampaignButton;
	}
	public WebElement getCampaignNameTextfield() {
		return campaignNameTextfield;
	}
	public WebElement getTargetSizeTextfield() {
		return targetSizeTextfield;
	}
	public WebElement getExpectedCloseDateTextfield() {
		return expectedCloseDateTextfield;
	}
	public WebElement getCampaignStatusTextfield() {
		return campaignStatusTextfield;
	}
	public WebElement getTargetAudienceTextfield() {
		return targetAudienceTextfield;
	}
	public WebElement getDescriptionTextField() {
		return descriptionTextField;
	}
	public WebElement getCreateButton() {
		return createButton;
	}
	
	public void createCampaignAllFeild(String campaignName,String tagetSize,String dateActual,String campaignStatus,String targetAudience,String description) {
		createCampaignButton.click();
		campaignNameTextfield.sendKeys(campaignName);
		
		targetSizeTextfield.clear();
		targetSizeTextfield.sendKeys(tagetSize);
		
		expectedCloseDateTextfield.sendKeys(dateActual);
		campaignStatusTextfield.sendKeys(campaignStatus);
		targetAudienceTextfield.sendKeys(targetAudience);
		descriptionTextField.sendKeys(description);
		createButton.click();
		
	}
	public void createCampaignMandotoryFeild(String campaignName,String tagetSize,String dateActual) {
		createCampaignButton.click();
		campaignNameTextfield.sendKeys(campaignName);
		
		targetSizeTextfield.clear();
		targetSizeTextfield.sendKeys(tagetSize);
		
		expectedCloseDateTextfield.sendKeys(dateActual);
		createButton.click();
		
	}
	
	public void createCampaignWithNoFeild() {
		createCampaignButton.click();
		createButton.click();
		
	}
	
	
}
