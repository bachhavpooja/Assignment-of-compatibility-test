package Test.pack;




import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pom.pack.Homepage;
import Utility.pack.utility;
import base.pack.base;







public class testclass extends base	 {
		
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	int testID;
	

		 WebDriver driver;
		 Homepage Homepage;
		 
		 @BeforeTest
			@Parameters("browser")
			public void LaunchBrowser(String browser)
			{
			 
			 reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
				ExtentReports extend= new ExtentReports();
				extend.attachReporter(reporter);

				System.out.println("Launching Browser");
				if(browser.equals("chrome"))
				{
				System.out.println("LaunchingBrowser");
				
					driver=OpenchromeBrowser();
				}
				if(browser.equals("firefox"))
				{
					System.out.println("LaunchingBrowser");
				
					driver=Openfirefox();
				}
				driver.manage().window().maximize();
			}
		@BeforeClass
		public void Createobject()
			{
			 System.out.println("Before class");
			
				Homepage=new Homepage(driver);
				
			}
			
		@BeforeMethod
		public void CreateNewAccount() 
			{
				System.out.println("Before Method");
				driver.get("https://jt-dev.azurewebsites.net/#/SignUp");
				Homepage.VerifyClickOnChooselangaugebutton();
				Homepage.VerifyEnterFullname("Pooja Chandrakant Bachhav");
				Homepage.VerifyOrganizationName("Shortclick Infotech");
				Homepage.VerifyEnterEmail("poojabachhav95@gamil.com");
				
			}

			@Test
			public void HomepageUrl()
			{
				testID = 100;
				System.out.println("Test");
				System.out.println("To verify Home page");
				Homepage.VerifyClickOnChooselangaugebutton();
				String url=driver.getCurrentUrl();
				if(url.equals("https://jt-dev.azurewebsites.net/#/SignUp"))
				{
					System.out.println("Found");
				}
				else
				{
					System.out.println("Not found");
				}
				
				
				//Assert.assertEquals(url,"http://localhost/administration/userlist.do" );
			}
			

			@AfterMethod
			public void logoutAccount(ITestResult result) throws IOException 
			{
				if(ITestResult.FAILURE == result.getStatus())
				{
					utility.takeScreenshot(driver, testID);
				}
				System.out.println("After Method");
			}
				
				
			
			
			@AfterClass
			public void clearObjects() {
				System.out.println("After Class");
				
			}
			
			@AfterTest
			public void closedBrowser() {
				System.out.println("After Test");
				driver.quit();
				driver = null;
				System.gc();
			}
}
