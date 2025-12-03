package org.ninjacrm.contacts;

import org.ninjacrm.businessutility.BaseClass;
import org.ninjacrm.objectrepository.CreateContactPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.ninjacrm.listners.ListnerImplementation.class)
public class CreateContactWithoutFieldTest extends BaseClass{
	
	@Test
	public  void createContactWithoutFieldTest() throws Throwable {

		homePage.getContactsLink().click();
		
		//create contact
		CreateContactPage contactPage=new CreateContactPage(driver);
		contactPage.createContactNoField();

	}

}
