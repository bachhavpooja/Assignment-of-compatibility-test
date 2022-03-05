package base.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public static WebDriver OpenchromeBrowser()
	{
		System.setProperty( "webdriver.chrome.driver" , "C:\\Program1\\chromedriver.exe" );
		 WebDriver driver=new ChromeDriver();
		return driver;
	}
	public static WebDriver Openfirefox()
	{
		System.setProperty( "webdriver.gecko.driver", "C:\\Program1\\geckodriver.exe");
		 WebDriver driver=new FirefoxDriver();
		return driver;
	}
	

}
