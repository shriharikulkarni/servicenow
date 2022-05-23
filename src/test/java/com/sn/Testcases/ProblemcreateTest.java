package com.sn.Testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sn.Commons.TestBase;
import com.sn.Pages.HomePage;
import com.sn.Pages.IncidentCreate;
import com.sn.Pages.LoginPage;
import com.sn.Pages.Problemcreate;
import com.sn.Pages.Submittestcase;
import com.sn.utilities.TestUtil;



public class ProblemcreateTest  extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	IncidentCreate incidentcreate;
	Problemcreate  problemcreate ;
	Submittestcase submittestcase;
	String wbsheet =" ProblemData";

	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		launch();
		loginpage = new LoginPage();
		homepage = loginpage.LoginData(p.getProperty("un"), p.getProperty("pass"));
		incidentcreate=homepage.SearchIncident();


	}

	@DataProvider
	public Iterator<Object[]> getTestData01()
	{
		ArrayList<Object[]> testData=TestUtil.getDataFromExcel(wbsheet);
		return testData.iterator();
	}


//	@Test
//	public void verifyproblecreatepage() {
//
//
//
//		String act= problemcreate. verifyproblemCreate();
//		System.out.println("problemcreate page title is   :"+act); 
//
//		String exp ="ServiceNow";
//		if(act.equalsIgnoreCase( exp)) {
//			System.out.println("successfully opened problem create page ");
//		}else {
//			System.out.println(" Not opened problem create page ");
//
//		}
//
//	}


	@Test(dataProvider="getTestData01")
	public void problemcreate(String Caller,String Shortdiscription,String problemShortdiscription) throws InterruptedException {

		

		System.out.println("Executing problemcreate test case");
		problemcreate=incidentcreate.incidentCreate01(Caller,Shortdiscription);
		submittestcase =problemcreate.problemcreate(Caller,Shortdiscription, problemShortdiscription);

	}


	@AfterMethod
	public void teardown(ITestResult result) throws IOException{


		driver.quit();
	}


}
