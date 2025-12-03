package org.ninjacrm.contacts;


import org.ninjacrm.businessutility.BaseClass;
import org.ninjacrm.fileutility.ExcelFile;
import org.ninjacrm.javautility.JavaUtility;
import org.ninjacrm.objectrepository.CreateContactPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateContactWithMandatoryTest extends BaseClass{

//	@Test (retryAnalyzer = org.ninjacrm.listners.RetryAnalyzerImplementation.class)
	@Test
	public  void createContactWithMandatoryTest() throws Throwable {
	

	    ExcelFile elib = new ExcelFile();
	    JavaUtility jlib = new JavaUtility();
	    
	    //Random Number
	    int randomNum = jlib.getRandomNumber();

	    //Excel File
	    String organization = elib.getDataFromExcel("Contact", 1, 0);
	    String title = elib.getDataFromExcel("Contact", 1, 1);
	    String contactName = elib.getDataFromExcel("Contact", 1, 4);
	    String campaign = elib.getDataFromExcel("Contact", 1, 5);
	    String phone = elib.getDataFromExcel("Contact", 1, 6)+randomNum;
	    
		
		homePage.getContactsLink().click();

		CreateContactPage contactPage= new CreateContactPage(driver);
		contactPage.createContactMandatoryField(driver, organization, title, contactName, phone, campaign);
		
		wlib.elementVisiblity(driver, homePage.getToastMessage());
		String actualResult = homePage.getToastMessage().getText();
		String expectedResult = "Contact "+contactName+" Successfully Added";
		Assert.assertEquals(expectedResult, actualResult);
		
		homePage.getCloseButton().click();
		
	}
}
