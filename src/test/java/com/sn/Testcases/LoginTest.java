package com.sn.Testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;


	@BeforeMethod
	public void setup() throws Exception {
		launch();
		loginpage = new LoginPage();
		homepage = new HomePage();

	}

	@Test(priority=1)
	public void verifyLoginPage() {
		String act ="ServiceNow SignOn";
		String exp = loginpage.verifyLogin();

		System.out.println("homepage title is   :" +  exp);

		if(act.equalsIgnoreCase( exp)) {
			System.out.println("successfully opened loging page ");
		}else {
			System.out.println(" Not opened loging page ");

		}


	}

	@Test(priority=2)
	public void SNLogoTest()
	{
		boolean flag=loginpage.validateImage();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		//homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		if(p.getProperty("isvalidcredential").equals("false"))
		{
			loginpage.Invalidlogin(p.getProperty("un"), p.getProperty("pass"));
		}
		else
		{
			homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		}

	}
	




	@AfterMethod 
	public void teardown()
	{ 
		driver.quit();
	}

}
