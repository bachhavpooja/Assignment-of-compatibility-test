package Pom.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Homepage {
	WebDriver driver;
			@FindBy(xpath="(//div[@id='language']//span//span[2])")
			private  WebElement chooselanguage;
			@FindBy(xpath="//div[text()='English']")
			private  WebElement lang;
			@FindBy(xpath="//input[@placeholder='Full Name']")
			private WebElement Enterfullname;
			@FindBy(xpath="//input[@placeholder='Organization Name']")
			private WebElement OrganizationName;
			@FindBy(xpath="//input[@name='email']")
			private WebElement Email;
			
			@FindBy(xpath="//span[@class='black-color ng-binding']")
			private  WebElement CheckBox;
			@FindBy(xpath="//button[text()='Get Started']")
			private  WebElement GettingStarted;
			
			

			
			public  Homepage(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements( driver,this);
			
			}
			
			public void VerifyClickOnChooselangaugebutton()
			{
				
				
			
				chooselanguage.click();
				Actions act=new Actions(driver);
			       act.moveToElement(lang).build().perform();
			       lang.click();
				
				
				
			}
			public  void VerifyEnterFullname(String fullname )
			{
				 Enterfullname.sendKeys(fullname);
				 
			}
			public   void VerifyOrganizationName(String orgname)
			{
				OrganizationName .sendKeys(orgname);
			}
			public  void VerifyEnterEmail(String mail)
			{
				Email.sendKeys(mail);
			}
			
}
