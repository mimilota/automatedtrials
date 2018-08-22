package session_timer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GridTest {
	 WebDriver driver;
	 String baseUrl;
	
	@SuppressWarnings("deprecation")
	@Before
	public void run() throws MalformedURLException, InterruptedException
	{
	 
	// We have to mention browser which we want to use for test execution
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
		//chromeCapabilities.setCapability(ChromeDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		// Create driver with hub address and capability
		driver = new RemoteWebDriver(new URL("http://192.168.200.125:4444/wd/hub"), chromeCapabilities);
		baseUrl = "https://umsbg-mws-qa.bulgaria.ptec/home";
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		//driver.get(baseUrl);
		driver.navigate().to(baseUrl);
		Thread.sleep(1000);
	}
	@Test
	public void test() throws Throwable,InterruptedException{
		 
	// get the title and print the same
	System.out.println("title is "+driver.getTitle());
	 
	
	
	//driver.close();
	}
	
}
	
	
	


