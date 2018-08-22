package session_timer;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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


public class TF_MRGC_54 {
	
	public static WebDriver driver;
	//String baseUrl;
	
	@Before
	public void startUp () throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//System.setProperty("webdriver.ie.driver", "D:\\drivers\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();	
		driver.get("https://umsbg-mws.bulgaria.ptec/admin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	
	@Test
	public void test() throws InterruptedException {
	
		WebElement login = driver.findElement(By.xpath(".//*[contains(@class, 'btn btn_action_login btn_size_small fn-login circular-effect')]"));
		login.click();
		Thread.sleep(1000);
		driver.switchTo().activeElement();
		WebElement username = driver.findElement(By.xpath(".//*[contains(@class, 'fn-user-name username')]"));
		username.click();
		username.sendKeys("MARIAPTBGEUR");
		WebElement password = driver.findElement(By.xpath(".//*[contains(@class, 'fn-input-type-password')]"));
		password.click();
		password.sendKeys("Secret123");
		WebElement log = driver.findElement(By.xpath(".//*[contains(@class, 'btn fn-login-btn')]"));
		log.click();
		Thread.sleep(1000);
		driver.switchTo().activeElement();
		WebElement confirm = driver.findElement(By.xpath(".//*[contains(@class, 'popup-modal__button fn-close circular-effect')]"));
		confirm.click();
		WebElement confirm1 = driver.findElement(By.xpath(".//*[contains(@class, 'popup-modal__button fn-close circular-effect')]"));
		confirm1.click();
		Thread.sleep(1000);
		WebElement mypage = driver.findElement(By.xpath(".//*[.='Mimi']"));
		mypage.click();
		
		Select timeperiodL = new Select(driver.findElement(By.xpath("//*[@id='sessionduration']")));
		timeperiodL.selectByVisibleText("10 minutes");
		driver.findElement(By.xpath(".//*[contains(@class, 'btn circular-effect')]")).click();;
		//driver.findElement(By.xpath("//*[@id='form_session_timer']/div[2]/button/span")).click(); 
		Thread.sleep(1000);
		
		if(driver.getPageSource().contains("Time per session has been activated on 10 minutes" )){
			System.out.println("\nTF_MRGC_54");
			System.out.println("Session timer has been successfully changed!(TF_MRGC_54)");}
			if(driver.getPageSource().contains("Please select the time you would like to be apply")){
				System.out.println("\nTF_MRGC_54");
				System.out.println("Session timer has been successfully changed!(TF_MRGC_54)");
		}
		else {
			System.out.println("Error in changing!");
		}
	}
	
}
