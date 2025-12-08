package extentreports;

import org.ninjacrm.businessutility.BaseClass;
import org.ninjacrm.fileutility.ExcelFile;
import org.ninjacrm.javautility.JavaUtility;
import org.ninjacrm.objectrepository.CreateContactPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.ninjacrm.listners.ListnerImplementation.class)
public class CreateContactWithAllFieldTest extends BaseClass {

	@Test
	public void createContactWithAllFieldTest() throws Throwable{
		// TODO Auto-generated method stub

	    ExcelFile elib = new ExcelFile();
	    JavaUtility jlib = new JavaUtility();
	    int randomNumber = jlib.getRandomNumber();
	    
	    //Excel File
	    String organization = elib.getDataFromExcel("Contact", 1, 0);
	    String title = elib.getDataFromExcel("Contact", 1, 1);
	    String department = elib.getDataFromExcel("Contact", 1, 2);
	    String officePhone = elib.getDataFromExcel("Contact", 1, 3);
	    String contactName = elib.getDataFromExcel("Contact", 1, 4);
	    String campaign = elib.getDataFromExcel("Contact", 1, 5);
	    String phone = elib.getDataFromExcel("Contact", 1, 6)+randomNumber;
	    String email=jlib.getRandomChar()+"@gmail.com";
	
		//click on contacts
	    homePage.getContactsLink().click();
		
		//click on create contact
		CreateContactPage contact=new CreateContactPage(driver);
		contact.createContactAllField(driver, organization, title, department, officePhone, contactName, phone, email, campaign);
		
		wlib.elementVisiblity(driver, homePage.getToastMessage());
		String actualResult = homePage.getToastMessage().getText();
		String expectedResult = "Contact "+contactName+" Successfully Added";
		Assert.assertEquals(expectedResult, actualResult);
		
		homePage.getCloseButton().click();
		
		///aalllll done
	}

}
