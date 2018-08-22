package session_timer;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class TF_MRGC_40 {
	public static WebDriver driver;
	//String baseUrl;
	
	@Before
	public void startUp () throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//System.setProperty("webdriver.ie.driver", "D:\\drivers\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();	
		driver.get("https://umsbg-mws-autotest.bulgaria.ptec/cp/login?brand=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	
	@Test
	public void test() throws InterruptedException {
		
		WebElement username = driver.findElement(By.xpath(".//*[@name='login']"));
		username.click();
		username.sendKeys("umsbg");
		WebElement pass = driver.findElement(By.xpath(".//*[@name='password']"));
		pass.sendKeys("SEcret123@");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/form/button")).click(); 
		Thread.sleep(1000);
		//opens settings
		driver.findElement(By.xpath("/html/body")).click(); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='dockbarOrgSettings']")).click();
		//driver.findElement(By.xpath(".//*[.='Responsible Gaming']")).click();
		Thread.sleep(1000);
		//deleting Session timer WC
		//WebElement sesstimeout = driver.findElement(By.xpath(".//*[.='Mimi']"))
		WebElement sesstimeout = driver.findElement(By.xpath(".//*[@id='id_16']"));
		sesstimeout.click();
		Thread.sleep(1000);
		sesstimeout.clear();
		//sesstimeout.sendKeys("");
		Thread.sleep(2000);
		WebElement save = driver.findElement(By.xpath(".//*[.='Save']"));
		save.click();
		WebElement savebutton= driver.findElement(By.xpath("//*[@id='orgSettingsContainer']/div/div/form/div[9]/button"));
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", savebutton);
		
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click()", savebutton);
		//WebElement save = driver.findElement(By.xpath("//*[@id='orgSettingsContainer']/div/div/form/div[9]/button"));
		
		//Thread.sleep(1000);
		//new Actions(driver).moveToElement(savebutton).perform(); 
		savebutton.click();
		//savebutton.sendKeys(Keys.ENTER);
		//save1.click();
		//Thread.sleep(2000);
		//driver.findElement(By.cssSelector(".btn")).click(); 
		//driver.findElement(By.xpath("//*[@id='orgSettingsContainer']/div/div/form/div[9]/button")).sendKeys(Keys.ENTER);
		//save.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// closing settings
		driver.findElement(By.xpath("//*[@id='portlet-small-icon-bar']/p/a")).click();
		//opens settings
		driver.findElement(By.xpath("//*[@id='dockbarOrgSettings']")).click(); 
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a.orgSettingsLink:nth-child(20)")).click();
		//driver.findElement(By.xpath(".//*[.='Responsible Gaming']")).click();
		Thread.sleep(500);
		//check if WC is deleted
		WebElement sessiontimer = driver.findElement(By.xpath(".//*[@id='id_53']"));
			if (sessiontimer.getAttribute("value").equals("")){
				System.out.println("\nTF_MRGC_40");
			System.out.println("\n"+"Web contend has been deleted!");
			}
		else
		{
			System.out.println("\nTF_MRGC_40");
			System.out.println("\n"+"Not working!");
			}
		
		//Select WC
		//driver.findElement(By.xpath("//*[@id='orgSettingsContainer']/div/div/form/div[4]/div/fieldset[2]/a")).click(); 
		Thread.sleep(1000);
		//driver.findElement(By.xpath(".//*[.='SESSION_TIMER']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath(".//*[.='Save']")).click();
		//close settings 
		//driver.findElement(By.xpath("//*[@id='portlet-small-icon-bar']/p/a")).click();
		Thread.sleep(500);
		//opens settings and check if it"s saved
			//	driver.findElement(By.xpath("//*[@id='dockbarOrgSettings']")).click(); 
			//	Thread.sleep(1000);
				//driver.findElement(By.xpath(".//*[.=' Responsible Gaming ']")).click();
			//Thread.sleep(500);
				//check if WC is deleted
				//WebElement sessiontimer = driver.findElement(By.xpath(".//*[@id='id_53']"));
				//	if (sessiontimer.getText().equals("")){
			//			System.out.println("\nTF_MRGC_40");
			//		System.out.println("\n"+"Web contend is empty!");
			//		}
			//	else
			//	{
			//		System.out.println("\nTF_MRGC_40");
			//		System.out.println("\n"+"WC is selected!");
				//	}
		//driver.close();
}
}
		

			
	

