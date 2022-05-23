package com.sn.Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
//import org.apache.commons.math3.stat.inference.TestUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.IncidentCreate;
import com.sn.Pages.LoginPage;
import com.sn.Pages.Problemcreate;
import com.sn.utilities.TestUtil;

public class IncidentCreateTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	IncidentCreate incidentcreate;
	Problemcreate  problemcreate ;
	static String wbsheet ="IncidentData";

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		launch();
		loginpage = new LoginPage();
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		incidentcreate=homepage.SearchIncident();
		

	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
	ArrayList<Object[]> testData=TestUtil.getDataFromExcel(wbsheet);
	return testData.iterator();
	
	}
	
	
	
  @Test
	public void verifyincidentCreatepage() throws InterruptedException {

		System.out.println("Executing verifyincidentCreatepage test case");
		String act=incidentcreate.verifyincidentCreate();
		System.out.println("incidentcreate page title is   :" + act);
		
		String exp="Incidents [Portal view] | ServiceNow";
		if(act.equalsIgnoreCase(exp)) {
			System.out.println("Opened incidents create page");  
		}else {
			System.out.println("Not opened incidents create page");
			
		}
	  
	  
	}

	@Test(dataProvider="getTestData")
	public void incidentCreate01(String Caller,String Shortdiscription) throws InterruptedException {

		System.out.println("Executing incidentCreate test case");
		problemcreate =incidentcreate.incidentCreate01(Caller,Shortdiscription);
		
		
			
	  }

	
	@AfterMethod
	public void teardown()

	{
		driver.quit();

	}
}

