package org.ninjacrm.createcampaign;

import org.ninjacrm.businessutility.BaseClass;
import org.ninjacrm.objectrepository.CreateCampaignPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.ninjacrm.listners.ListnerImplementation.class)

public class CreateCampaignWithoutDataTest extends BaseClass{
	
	@Test
	public  void createCampaignWithoutDataTest() throws Throwable {

		homePage.getCampaignsLink().click();
		
		//create Campaign
		CreateCampaignPage campaign = new CreateCampaignPage(driver);
		campaign.createCampaignWithNoFeild(driver);
		

	}

}
