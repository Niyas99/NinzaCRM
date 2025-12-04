package org.ninjacrm.leads;

import org.ninjacrm.businessutility.BaseClass;
import org.ninjacrm.objectrepository.CreateLeadPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.ninjacrm.listners.ListnerImplementation.class)
public class CreateLeadsWithoutFieldTest extends BaseClass {

	@Test
	public void createLeadsWithoutFieldTest() throws Throwable {

		homePage.getLeadsLink().click();
		
		//create Leads
		CreateLeadPage leadPage= new CreateLeadPage(driver);
		leadPage.createLeadsNoFields(driver);
		

	}

}
