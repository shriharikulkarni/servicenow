package com.sn.Testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.IncidentCreate;
import com.sn.Pages.LoginPage;



public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	IncidentCreate incidentcreate;


	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		loginpage = new LoginPage();
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		
	}


	//@Test(priority=1)
	public void verify() throws InterruptedException
	{
		String act = homepage.VerifyTitle();
		//Thread.sleep(5000);
		System.out.println("homepage title is   :" + act);
		
		Assert.assertEquals(act, "ServiceNow SignOn", "Title not matched");
		
		String exp ="ServiceNow SignOn";
		if(act.equalsIgnoreCase( exp)) {
			System.out.println("successfully loged in & opened home page");  
		}else {
			System.out.println("successfully loged in but Not opened home page ");
			
		}
	}

	@Test(priority=2)
	public void SearchIncident() throws InterruptedException, FileNotFoundException
	{
		System.out.println("Executing SearchIncident test case");
		incidentcreate = homepage.SearchIncident();
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}