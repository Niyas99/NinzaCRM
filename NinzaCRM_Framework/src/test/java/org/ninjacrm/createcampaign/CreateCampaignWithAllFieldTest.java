package org.ninjacrm.createcampaign;

import org.ninjacrm.businessutility.BaseClass;
import org.ninjacrm.fileutility.ExcelFile;
import org.ninjacrm.javautility.JavaUtility;
import org.ninjacrm.objectrepository.CreateCampaignPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.ninjacrm.listners.ListnerImplementation.class)

public class CreateCampaignWithAllFieldTest extends BaseClass{
	
	@Test
	public  void createCampaignWithAllFieldTest() throws Throwable {
		
	    ExcelFile elib = new ExcelFile();
	    JavaUtility jlib = new JavaUtility();
	    
	    //Random name
	    String campaignName = jlib.getRandomChar();

	    //Excel File
	    String campaignStatus = elib.getDataFromExcel("Campaign", 1, 1);
	    String tagetSize = elib.getDataFromExcel("Campaign", 1, 2);
	    String targetAudience = elib.getDataFromExcel("Campaign", 1, 4);
	    String description = elib.getDataFromExcel("Campaign", 1, 5);
	    
	    //date
	    String dateActual = jlib.getRequiredDate();
	    
		homePage.getCampaignsLink().click();
		
		
		//Click Campaign
		CreateCampaignPage campaign = new CreateCampaignPage(driver);
		campaign.createCampaignAllFeild(campaignName, tagetSize, dateActual, campaignStatus, targetAudience, description);
		
		wlib.elementVisiblity(driver, homePage.getToastMessage());
		String actualResult = homePage.getToastMessage().getText();
		String expectedResult = "Campaign "+campaignName+" Successfully Added";
		Assert.assertEquals(expectedResult, actualResult);
		
		homePage.getCloseButton().click();

	}
}
