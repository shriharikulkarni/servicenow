package com.sn.Commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.sn.Testcases.ProblemcreateTest;
import com.sn.utilities.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;
//import posion.artifactId;
//import posion.dependency;
//import posion.groupId;
//import posion.io;

public class TestBase {

	static XSSFReader reader;

	public static WebDriver driver;
	public static Properties p;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public static ExtentReports extend;
	public static ExtentTest extendtest;
	
	//To read properties file
	public TestBase(){
		try {
			p=new Properties();
			FileInputStream f=new FileInputStream("C:\\Users\\hp\\Desktop\\Testing\\mavenprjt\\ServiceNow ATF Scripts\\InHouse Project\\SN-POC\\src\\main\\java\\com\\sn\\Properties\\Config.properties" );
			p.load(f);
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	//To launch driver
//	public void launch() {
//		
//		//WebDriverManager.chromedriver().setup();
//	    System.setProperty("webdriver.chrome.driver","C:/jdk and eclips/eclipse/chromedriver/chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		driver=new ChromeDriver(options);
//		driver.manage().deleteAllCookies();
//		driver.get(p.getProperty("url"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		e_driver = new EventFiringWebDriver(driver);
//		eventListener = new WebEventListener();
//		//e_driver.register(eventListener);      giving error for this line
//		driver = e_driver;
//
//	}
	
	//To launch driver
		public void launch() {
			if(p.getProperty("browser").equalsIgnoreCase("chrome"))
			{
			//WebDriverManager.chromedriver().setup();
			 System.setProperty("webdriver.chrome.driver","C:/jdk and eclips/eclipse/chromedriver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
			}
			else
			{
				//WebDriverManager.firefoxdriver().setup();
				System.setProperty("webdriver.gecko.driver","C://firefox//geckodriver.exe");
				FirefoxOptions options1 = new FirefoxOptions();
				options1.addArguments("--disable-notifications");
				driver = new FirefoxDriver(options1);
			}
			driver.manage().deleteAllCookies();
			driver.get(p.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			//e_driver.register(eventListener);      giving error for this line
			driver = e_driver;

		}

	public  boolean verify(By webEle) {
		boolean check=driver.findElement(webEle).isDisplayed();
		System.out.println(check);
		return check;

	}

	public  void clickOnElement(By webEle)
	{
		driver.findElement((webEle)).click();
	}

	public  void sendKey(By webEle,String text) {
		driver.findElement(webEle).sendKeys(text);
	}

	public  void clickoncheckbox(By webEle) {

		boolean check=driver.findElement(webEle).isSelected();
		if(!check)
		{
			driver.findElement(webEle).click();

		}
	}
	public String titleTest() {
		return driver.getTitle();
	}

	public  void pressEnter() {
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER);
	}

	public  void scrollupto(By webEle) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",webEle);

	}

	public  void clickonElementbyjs(WebElement webEle) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", webEle);
	}

	public  String getText(By webEle) {
		String gettext=driver.findElement(webEle).getText();
		return gettext;
	}

	public  boolean elementvisibletest(By webEle) {
		boolean gettext=driver.findElement(webEle).isEnabled();
		return gettext;
	}

	public  void explicitWait(By ele) {
		WebDriverWait wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver)
.executeScript("return arguments[0].shadowRoot",element);
		return ele;
	}
	
	
	public static String getScreensot(WebDriver driver,String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyymmddhhmm").format(new Date());
	
		 
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  String destination  =System.getProperty("user.dir")+"\\test-output\\"+screenshotName + dateName + ".png "; 
		  File finaldestination =new File(destination );
		  FileUtils.copyFile(scrFile, finaldestination);
		 
		return destination;
		
	}

}


