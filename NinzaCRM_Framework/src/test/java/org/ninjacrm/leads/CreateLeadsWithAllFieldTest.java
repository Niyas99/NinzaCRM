package org.ninjacrm.leads;

import org.ninjacrm.businessutility.BaseClass;
import org.ninjacrm.fileutility.ExcelFile;
import org.ninjacrm.javautility.JavaUtility;
import org.ninjacrm.objectrepository.CreateLeadPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.ninjacrm.listners.ListnerImplementation.class)
public class CreateLeadsWithAllFieldTest extends BaseClass {

	@Test
	public void createLeadsWithAllFieldTest() throws Throwable {
	    
	    ExcelFile elib = new ExcelFile();
	    JavaUtility jlib = new JavaUtility();
	    
	    //Random Number by using JavaUtility
	    int randomNum = jlib.getRandomNumber();	    
	    
	    //fetching Data From Excel
	    String leadName = elib.getDataFromExcel("Leads", 1, 0);
	    String company = elib.getDataFromExcel("Leads", 1, 1);
	    String leadSource = elib.getDataFromExcel("Leads", 1, 2);
	    String industry = elib.getDataFromExcel("Leads", 1, 3);
	    String anualReview = elib.getDataFromExcel("Leads", 1, 4);
	    String noOfEmp = elib.getDataFromExcel("Leads", 1, 5);
	    String leadStatus = elib.getDataFromExcel("Leads", 1, 6);
	    String rating = elib.getDataFromExcel("Leads", 1, 7);
	    String address = elib.getDataFromExcel("Leads", 1, 8);
	    String assignedTo = elib.getDataFromExcel("Leads", 1, 9);
	    String city = elib.getDataFromExcel("Leads", 1, 10);
	    String country =elib.getDataFromExcel("Leads", 1, 11);
	    String postalCode = elib.getDataFromExcel("Leads", 1, 12);
	    String Website = elib.getDataFromExcel("Leads", 1, 13);
	    String campaign = elib.getDataFromExcel("Leads", 1, 14);
	    String description = elib.getDataFromExcel("Leads", 1, 15);
	    String phone = elib.getDataFromExcel("Leads", 1, 16)+randomNum;
	    String email = jlib.getRandomChar()+"@gmail.com";
	    String secondaryEmail = jlib.getRandomChar()+"@gmail.com";
	    
		homePage.getLeadsLink().click();
		
		//create Leads
		CreateLeadPage leadPage = new CreateLeadPage(driver);
		leadPage.createLeadsAllFields(driver, leadName, company, leadSource, industry, anualReview, noOfEmp, phone, email, secondaryEmail, leadStatus, rating, assignedTo, address, city, country, postalCode, Website, campaign, description);
		
//		SoftAssert softAssert = new SoftAssert();
		wlib.elementVisiblity(driver, homePage.getToastMessage());
		String actualResult = homePage.getToastMessage().getText();
		String expectedResult = "Lead "+leadName+" Successfully Added";
		Assert.assertEquals(expectedResult, actualResult);
	
		
		homePage.getCloseButton().click();
	}

}
