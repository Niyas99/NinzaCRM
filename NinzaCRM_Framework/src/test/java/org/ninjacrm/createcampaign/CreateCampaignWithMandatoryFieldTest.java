package org.ninjacrm.createcampaign;

import org.ninjacrm.businessutility.BaseClass;
import org.ninjacrm.fileutility.ExcelFile;
import org.ninjacrm.javautility.JavaUtility;
import org.ninjacrm.objectrepository.CreateCampaignPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.ninjacrm.listners.ListnerImplementation.class)

public class CreateCampaignWithMandatoryFieldTest extends BaseClass{

	@Test
	public void createCampaignWithMandatoryFieldTest() throws Throwable {
		
	    ExcelFile elib = new ExcelFile();
	    JavaUtility jlib = new JavaUtility();
	    
	  //Random name
	    String campaignName = jlib.getRandomChar();
	    
	    //Excel File
	    String tagetSize = elib.getDataFromExcel("Campaign", 1, 2);
	    String date = elib.getDataFromExcel("Campaign", 1, 3);
	    
		homePage.getCampaignsLink().click();
		
		//Create Campaign
		CreateCampaignPage campaign= new CreateCampaignPage(driver);
		campaign.createCampaignMandotoryFeild(driver,campaignName, tagetSize, date);

		wlib.elementVisiblity(driver, homePage.getToastMessage());
		String actualResult = homePage.getToastMessage().getText();
		String expectedResult = "Campaign "+campaignName+" Successfully Added";
		Assert.assertEquals(expectedResult, actualResult);
		
		homePage.getCloseButton().click();
	}

}
