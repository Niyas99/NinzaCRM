package org.ninjacrm.leads;

import org.ninjacrm.businessutility.BaseClass;
import org.ninjacrm.fileutility.ExcelFile;
import org.ninjacrm.javautility.JavaUtility;
import org.ninjacrm.objectrepository.CreateLeadPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.ninjacrm.listners.ListnerImplementation.class)
public class CreateLeadsWithMandatoryFieldTest extends BaseClass{

	@Test
	public void createLeadsWithMandatoryFieldTest() throws Throwable {
		
	    ExcelFile elib = new ExcelFile();
	    JavaUtility jlib = new JavaUtility();
	    
	    int randomNum = jlib.getRandomNumber();
	    
	    //Excel File
	    String leadName = elib.getDataFromExcel("Leads", 1, 0);
	    String company = elib.getDataFromExcel("Leads", 1, 1);
	    String leadSource = elib.getDataFromExcel("Leads", 1, 2);
	    String industry = elib.getDataFromExcel("Leads", 1, 3);
	    String leadStatus = elib.getDataFromExcel("Leads", 1, 6);
	    String campaign = elib.getDataFromExcel("Leads", 1, 14);
	    String phone = elib.getDataFromExcel("Leads", 1, 16)+randomNum;
	 
		homePage.getLeadsLink().click();
		
		//create Leads
		CreateLeadPage leadPage= new CreateLeadPage(driver);
		leadPage.createLeadsMandatoryFields(driver, leadName, company, leadSource, industry, phone, leadStatus, campaign);
		
		wlib.elementVisiblity(driver, homePage.getToastMessage());
		String actualResult = homePage.getToastMessage().getText();
		String expectedResult = "Lead "+leadName+" Successfully Added";
		Assert.assertEquals(expectedResult, actualResult);
		
		homePage.getCloseButton().click();
	}
}
