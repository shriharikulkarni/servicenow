package com.sn.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sn.Commons.TestBase;

public class LoginPage extends TestBase {

	TestBase t = new TestBase();

	@FindBy(id = "username")
	WebElement uname;

	@FindBy(id = "usernameSubmitButton")
	WebElement NextBtn;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(id = "submitButton")
	WebElement Loginbtn;

	@FindBy(id = "errorPlaceholder")
	WebElement Errormsg1;

	@FindBy(xpath="//div[@class='logo']")
	WebElement SNLogo;


	public LoginPage()
	{
		PageFactory.initElements(t.driver, this);
	}

	public String verifyLogin()

	{
		return t.driver.getTitle();
	}
	//Validate Logo
	public boolean validateImage()
	{
		return SNLogo.isDisplayed();
	}



	public HomePage LoginData(String un, String pass) throws InterruptedException

	{  

		//ImplicitlyWait
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		System.out.println("==============================================================");

		System.out.println("THIS IS LOGINPAGE CLASS LoginData METHOD");

		System.out.println("-------------------------------------------------------------"); 

		//Entered user name
		
//		boolean unameText =uname.isDisplayed();
//		System.out.println("is Username_TextField displayed  :"+  unameText);
		
		if(uname.isDisplayed() && uname.isEnabled())
		{
			
			System.out.println("UserName Field Displayed And Enabled on login Page");
			uname.sendKeys(un);
		}
		else
		{
			System.out.println("UserName Field Not Displayed And NotEnabled on login Page");
			//driver.quit();
		}
		
		System.out.println("UserName is  :" +un);
		
		//uname.sendKeys(un);
		
		
		System.out.println("Entered user name");

		System.out.println("-------------------------------------------------------------");

		//Clicked on next button
		
//		boolean nextBtn =NextBtn.isDisplayed();
//		System.out.println("Is Next Button displayed  :"+ nextBtn);	
		
		if(NextBtn.isDisplayed() && NextBtn.isEnabled())
		{
			System.out.println("Next Button Displayed And Enabled on login Page");
			NextBtn.click();
		}
		else
		{
			System.out.println("Next Button Not Displayed And Not Enabled on login Page");
		}
		
		//NextBtn.click();
		System.out.println("Clicked on next button");

		System.out.println("-------------------------------------------------------------");

		//Entered Password
//		boolean password_Field =Password.isEnabled();
//		System.out.println("Is password_Field displayed  :"+ password_Field);
		
		if(NextBtn.isDisplayed() )
		{
			System.out.println("Next Button Displayed And Enabled on login Page");
			Password.sendKeys(pass);
		}
		else
		{
			System.out.println("Next Button Not Displayed And Not Enabled on login Page");
		}
		
		System.out.println("Password is  :" +pass);
		//Password.sendKeys(pass);
		
		System.out.println("Entered Password");

		System.out.println("-------------------------------------------------------------");

		//Clicked & verified  next button
		
//		boolean loginbtn =Loginbtn.isDisplayed();
//		System.out.println("Is loginButton displayed  :"+ loginbtn);
		
		if(Loginbtn.isDisplayed() && NextBtn.isEnabled())
		{
			System.out.println("login  Button Displayed And Enabled on login Page");
			Loginbtn.click();
		}
		else
		{
			System.out.println("Next Button Not Displayed And Not Enabled on login Page");
		}
		
	//	Loginbtn.click();
		System.out.println("Clicked & verified  next button");

		System.out.println("-------------------------------------------------------------");

		//Thread.sleep(2000);
//		String actualUrl="https://developer.servicenow.com/dev.do#!/home?wu=true123";
		String expectedUrl= driver.getCurrentUrl();
//		Assert.assertEquals(expectedUrl,actualUrl);
		System.out.println("entered home page & title is :" + expectedUrl);

		System.out.println("-------------------------------------------------------------");

		//Thread.sleep(10000);

		return new HomePage();


	}

	public String Invalidlogin(String un, String pass)
	{

		uname.sendKeys(un);
		System.out.println(un);
		NextBtn.click();
		Password.sendKeys(pass);
		System.out.println(pass);
		Loginbtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(Errormsg1));

		String errormsg1 = Errormsg1.getText(); 
		System.out.println("Displayed error msg for invalid creadential  :"+errormsg1);
		return t.driver.getTitle();



	}



}
