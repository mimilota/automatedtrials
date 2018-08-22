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
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class home_func extends LoadableComponent<home_func>{
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(@class, 'btn btn_action_login btn_size_small fn-login circular-effect')]")
	private WebElement login;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(@class, 'fn-user-name username')]")
	private WebElement username;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(@class, 'fn-input-type-password')]")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(@class, 'btn fn-login-btn')]")
	private WebElement loginbutton;
	
	@FindBy(how = How.XPATH, using = ".//*[contains(@class, 'popup-modal__button fn-close circular-effect')]")
	private WebElement confirm;
	
	
	@FindBy(how = How.XPATH, using = ".//*[.='Mimi']")
	private WebElement mypage;
	
	@FindBy(how = How.XPATH, using = "//*[@id='sessionduration']")
	private WebElement timeperiod;
	
	@FindBy(how = How.XPATH, using = "//*[@id='form_session_timer']/div[2]/button/span")
	private WebElement confirmtime;
	
	@FindBy(how = How.XPATH, using = ".//*[.='Home']")
	private WebElement homepage;
		
	
	
	public home_func() throws IOException, InterruptedException {
		super();
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = ("https://umsbg-mws-qa.bulgaria.ptec/home");

		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		}

	public void openB() throws InterruptedException {
		String url = ("https://umsbg-mws-qa.bulgaria.ptec/home");
		this.driver.get(url);
		Thread.sleep(5000);
	}

	public void login() throws InterruptedException {
		login.click();
		driver.switchTo().activeElement();
		username.click();
		username.sendKeys("MARIAPTBGEUR");
		password.click();
		password.sendKeys("Secret123");
		loginbutton.click();
		driver.switchTo().activeElement();
		Thread.sleep(1000);
		confirm.click();
		driver.switchTo().activeElement();
		Thread.sleep(1000);
		confirm.click();
		
	}
	
	public void confirmbutton() {
		confirm.click();
	
	}
	
	public void timeperiodL() throws InterruptedException{
		mypage.click();
		Thread.sleep(1000);
		Select timeperiodL = new Select(driver.findElement(By.xpath("//*[@id='sessionduration']")));
		timeperiodL.selectByVisibleText("10 minutes");
		driver.findElement(By.xpath("//*[@id='form_session_timer']/div[2]/button/span")).click(); 
		Thread.sleep(1000);
		
		if(driver.getPageSource().contains("Time per session has been activated on 10 minutes"))
		{	System.out.println("Session timer has been successfully changed!");
		}
		else {
			System.out.println("Error in changing!");
		}
		
	}
	
	
	public void redirect() throws InterruptedException {
		driver.switchTo().activeElement();
		if(driver.getPageSource().contains("Session timeout notification"))
		{	System.out.println("TC_31 passed");
		}
		else {
			System.out.println("Somethign went wrong!");
		}
		Thread.sleep(500);
		driver.findElement(By.cssSelector("a[@href='https://umsbg-mws.bulgaria.ptec/session-timer']")).click();
		//driver.findElement(By.xpath("//a[@href='https://umsbg-mws.bulgaria.ptec/session-timer']")).click(); 
		
		Thread.sleep(1000);
		
	}
	
	public void checkloadedpage(){
		String page = driver.getPageSource();
	if(driver.getPageSource().contains("Set session reminder"))
	{	System.out.println("TC_41 passed");
	}
	else {
		if(page.contains("home")){
			System.out.println("TC_32 passed");
		}
		else{
			System.out.println("You are not redirected correctly!");
		}
	}
	}
	
	public void gotohome(){
		homepage.click();
		
	}
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
	
	public void closeB() {
		this.driver.quit();
	}
	
	}
	
	

