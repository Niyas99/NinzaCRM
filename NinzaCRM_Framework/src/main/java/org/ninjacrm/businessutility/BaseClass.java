package org.ninjacrm.businessutility;

import java.util.HashMap;
import java.util.Map;

import org.ninjacrm.fileutility.PropertyFile;
import org.ninjacrm.javautility.JavaUtility;
import org.ninjacrm.objectrepository.HomePage;
import org.ninjacrm.objectrepository.LoginPage;
import org.ninjacrm.weddriverutility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
public class BaseClass {
	
    public PropertyFile plib = new PropertyFile();
    public WebDriverUtility wlib = new WebDriverUtility();
    public JavaUtility jlib= new JavaUtility();
    public WebDriver driver = null;
    public static WebDriver sDriver;
    public LoginPage loginPage;
    public HomePage homePage;

    @BeforeSuite
    public void beforeSuite() {
        Reporter.log("Connection Established", true);
    }

    @BeforeClass
    public void beforeClass() throws Throwable {
    	ChromeOptions settings = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        settings.setExperimentalOption("prefs", prefs);

//        // Jenkins-compatible headless flags
//        settings.addArguments("--headless=new");   // required for Jenkins
//        settings.addArguments("--disable-gpu");
//        settings.addArguments("--no-sandbox");
//        settings.addArguments("--disable-dev-shm-usage");
//        settings.addArguments("--window-size=1920,1080");
//        settings.addArguments("--disable-notifications");
//        settings.addArguments("--disable-extensions");


        String browser = plib.getPropertyData("Browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(settings);

        } else if (browser.equalsIgnoreCase("edge")) {
            // Edge also needs headless mode
//            EdgeOptions edgeOptions = new EdgeOptions();
//            edgeOptions.addArguments("--headless=new");
//            edgeOptions.addArguments("--disable-gpu");
//            edgeOptions.addArguments("--no-sandbox");
//            edgeOptions.addArguments("--disable-dev-shm-usage");
//            edgeOptions.addArguments("--window-size=1920,1080");

            driver = new EdgeDriver();

        } else {
            driver = new ChromeDriver(settings);
        }

        sDriver = driver;

        wlib.pageMaximize(driver);   // This is ignored in headless but safe
        wlib.waitForPageLoad(driver);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);    }

    @BeforeMethod
    public void beforeMethod() throws Throwable {
        String url = plib.getPropertyData("Url");
        String userName = plib.getPropertyData("Username");
        String password = plib.getPropertyData("Password");

        driver.get(url);
        Thread.sleep(500);

        loginPage.getUserNameTextfield().sendKeys(userName);
        loginPage.getPasswordTextfield().sendKeys(password);
        loginPage.getSignInButton().click();
    }

    @AfterMethod
    public void afterMethod() {
        wlib.clickableWait(driver, homePage.getProfileIcon());
        wlib.clickableWait(driver, homePage.getLogOutLink());
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(500);
        driver.quit();
    }
}

