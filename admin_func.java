package session_timer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.lang.Object;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class admin_func extends LoadableComponent<admin_func>{

	WebDriver driver;
	

	@FindBy(how = How.XPATH, using = ".//*[@id='_58_login']")
	private WebElement username;
	@FindBy(how = How.XPATH, using = ".//*[@id='_58_password']")
	private WebElement pass;

	@FindBy(how = How.XPATH, using = "//*[@id='_58_fm']/div/div[3]/button")
	private WebElement logbutton;

	@FindBy(how = How.XPATH, using = "//*[@id='dockbarOrgSettings']")
	private WebElement settings;

	@FindBy(how = How.XPATH, using = ".//*[.='Responsible Gaming']")
	private WebElement respgaming;

	//@FindBy(how = How.XPATH, using = "//*[@name ='sessionTimeout']")
	//private WebElement sessiontimer;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='id_53']")
	private WebElement sessiontimer2;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='id_19']")
	private WebElement sessiontimer;
	
	@FindBy(how = How.XPATH, using = ".//*[.='Save']")
	private WebElement savebutton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='orgSettingsContainer']/div/div/form/div[9]/button")
	private WebElement savebutton2;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='portlet-small-icon-bar']/p/a")
	private WebElement closebutton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='orgSettingsContainer']/div/div/form/div[4]/div/fieldset[2]/a")
	private WebElement selectwebcontent;
	
	@FindBy(how = How.XPATH, using = ".//*[.='SESSION_TIMER']")
	private WebElement sessiontimerwc ;
	
	@FindBy(how = How.XPATH, using = ".//*[.='SESSION_TIMER_WITH_REDIRECT']")
	private WebElement sessiontimerredirect;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='portlet-small-icon-bar']/p/a")
	private WebElement closesettings ;
	
	@FindBy(how = How.XPATH, using = "//*[@name ='timeIsFlyingReminderFrequency']")
	private WebElement timeIsFlyingReminderFrequency;


	public admin_func() throws IOException, InterruptedException {
		super();
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
		//System.setProperty("webdriver.firefox.profile", "default");
		//driver = new FirefoxDriver();
		//Thread.sleep(1000);
		//FirefoxProfile profile = new FirefoxProfile();
		//profile.setAcceptUntrustedCertificates(true);
		//profile.setAssumeUntrustedCertificateIssuer(false);
		
		//System.setProperty("webdriver.ie.driver", "D:\\drivers\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();	
		String url = ("https://umsbg-mws-qa.bulgaria.ptec/admin");

		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void openB() throws InterruptedException {
		String url = ("https://umsbg-mws-qa.bulgaria.ptec/admin");
		this.driver.get(url);
		Thread.sleep(5000);
	}

	public void login() throws InterruptedException {
		username.click();
		username.sendKeys("test");
		pass.sendKeys("test");
		logbutton.click();
		Thread.sleep(1000);

	}
	public void rsgaming() throws InterruptedException{
		Thread.sleep(1000);
		respgaming.click();
	}
	// time is flying reminder frequency change
	public void timeisflying(String t) throws InterruptedException {
		Thread.sleep(1000);
		timeIsFlyingReminderFrequency.clear();
		timeIsFlyingReminderFrequency.sendKeys(t);
		Thread.sleep(500);
		savebutton.click();
		savebutton2.click();
		//closesettings.click();
	}
	
	//selecting web content with redirection link
	public void selectwcredirect() throws InterruptedException{
		respgaming.click();
		sessiontimer.clear();
		selectwebcontent.click();
		Thread.sleep(500);
		sessiontimerredirect.click();
		Thread.sleep(1000);
		savebutton2.click();
		closesettings.click();
	}
	// deleting Session timer WC
	public void delsessiontimer() throws InterruptedException {
		//settings.click();
		Thread.sleep(1000);
		//respgaming.click();
		//Thread.sleep(5000);
		//sessiontimer.click();
		sessiontimer.clear();
		//sessiontimer2.clear();
		Thread.sleep(1500);
		//sessiontimer.sendKeys();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='orgSettingsContainer']/div/div/form/div[9]/button")).click();
		savebutton.click();
		savebutton2.click();
		Thread.sleep(1000);
		closesettings.click();
		}

	
	// check if WC is deleted
	public void checkWC() throws InterruptedException {
		Thread.sleep(500);
		settings.click();
		Thread.sleep(1000);
		respgaming.click();
		String textInsideInputBox = sessiontimer.getAttribute("value");

		// Check whether input field is blank
		if(textInsideInputBox.isEmpty())
		{
		   System.out.println("Web content field is empty!");
		}
		else
	{
		System.out.println("\n"+"Web content exists!");
		}
		closesettings.click();
}
	
	//Choose WC
	public void selectwc() throws InterruptedException {
		settings.click();
		Thread.sleep(500);
		respgaming.click();
		selectwebcontent.click();
		Thread.sleep(500);
		sessiontimerwc.click();
		Thread.sleep(1000);
		savebutton.click();
		closesettings.click();
	}
	
	public void opensettings() throws InterruptedException {
		settings.click();
		Thread.sleep(500);}
	
	public void clearwc() {
		sessiontimer.clear();
		savebutton2.click();
		closesettings.click();
	}
	
	public void printlog () throws InterruptedException {
		LogEntries logEntries = driver.manage().logs().get("browser");
        for (LogEntry entry : logEntries)
                   System.out.println(entry.getMessage());
	    Thread.sleep(500);
	}
	
	
	public void closeB() {
		this.driver.quit();
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
	

}
