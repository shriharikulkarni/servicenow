package com.sn.Pages;

import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sn.Commons.TestBase;

public class Problemcreate extends TestBase{


	TestBase t = new TestBase();


	@FindBy( xpath ="//input[@id=\"problem.short_description\"]")
	WebElement problemstatement_text;

	@FindBy( xpath ="//button[@id=\"sysverb_insert\"]")
	WebElement clicksubmit;

	@FindBy( xpath ="//input[@class=\"form-control element_reference_input\"]")
	WebElement filereportedby;

	//	@FindBy( xpath ="//button[@class=\"form_action_button header  action_context btn btn-default\"][1]")
	//	WebElement incidentsubmitbutton;

	@FindBy(xpath ="//a[@class='list_action list_top_title']")
	WebElement IncidentCreate1;


	@FindBy(xpath ="//input[@id=\"sys_readonly.problem.number\"]")
	WebElement problecreateNo;


	//@FindBy(id = "filter")
	@FindBy(xpath ="//input[@name=\"filter\"]")
	WebElement TypeIncident;



	@FindBy(xpath = "//a[@id='4fed4395c0a8016400fcf06c27b1e6c6']//div[@class='sn-widget-list-title'][normalize-space()='Incidents']")
	WebElement ClickSearch;



	@FindBy(xpath ="//*[@id=\"b55f73f8c0a800090175ace6ae472053\"]/div/div")

	WebElement ClickProblemALL;


	@FindBy(xpath ="//input[@class=\"form-control disabled \"]")
	WebElement ProblemNo;


	@FindBy(xpath ="//input[@id=\"c917f74b1bd38110c527ed74604bcb0e_text\"]")
	WebElement ProblemNoSearc;



	@FindBy(xpath ="//a[@id='b56200fbc0a8000900ae7b77db247697']//div[@class='sn-widget-list-title'][normalize-space()='Open']")
	WebElement clickprobOpen;


	@FindBy(xpath ="//button[@class=\"form_action_button header  action_context btn btn-default\"][1]")
	WebElement updatePrb;

	@FindBy(xpath ="/html/body/div[1]/div[1]/span/div/div[1]/div/span/div/div/input")
	WebElement SearchButton;

	public Problemcreate() 
	{
		PageFactory.initElements(t.driver, this);
	}

//	public String verifyproblemCreate()
//
//	{
//
//		return t.driver.getTitle();
//	}





	public Submittestcase problemcreate(String Caller,String Shortdiscription,String problemShortdiscription) throws InterruptedException 

	{
		System.out.println("==============================================================");

		System.out.println("THIS IS PROBLEMCREATE CLASS problemcreate METHOD");
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		System.out.println("==============================================================");
		
		String actual=driver.getCurrentUrl();
		System.out.println( actual);
		String expected ="https://dev116187.service-now.com/problem.do?sys_id=-1&sys_is_list=true&sys_target=problem&sysparm_checked_items=&sysparm_fixed_query=&sysparm_group_sort=&sysparm_list_css=&sysparm_nameofstack=reflist&sysparm_query=&sysparm_referring_url=problem_list.do%3fsysparm_form_view%3dportal%4099%40sysparm_target%3dincident.problem_id%4099%40sysparm_reference%3dproblem%4099%40sysparm_view%3dsys_ref_list%4099%40sysparm_domain_restore%3dfalse%4099%40sysparm_nameofstack%3dreflist%4099%40sysparm_element%3dproblem_id%4099%40&sysparm_target=incident.problem_id&sysparm_view=portal&sysparm_nameofstack=reflist";
		if(actual.equalsIgnoreCase( expected)) {
			System.out.println("successfully opened problem create page ");
		}else {
			System.out.println(" Not opened problem create page ");

		}

		System.out.println("-------------------------------------------------------------");

		//maximize window
		driver.manage().window().maximize();
		System.out.println("window get maximized");

		System.out.println("-------------------------------------------------------------");
		
		//print problem number
		String ProblecreateNo =	problecreateNo.getAttribute("value");
		System.out.println("ProbleM Number  :" +ProblecreateNo);

		System.out.println("-------------------------------------------------------------");

		//Entered input in ShortdiscriptionS field
		boolean problemstatement_text01 =problemstatement_text.isEnabled();
		System.out.println("Is problemstatement_text field Enabled  :"+ problemstatement_text01);
		problemstatement_text.clear();
		problemstatement_text.sendKeys(problemShortdiscription);
		System.out.println("Problem_Shortdiscription is entered");

		System.out.println("-------------------------------------------------------------");

		//click Submit button
		boolean Clicksubmit =clicksubmit.isEnabled();
		System.out.println("Is Clicksubmit Button Enabled  :"+ Clicksubmit);
		clicksubmit.click();
		System.out.println("Clicked on Submit button");

		System.out.println("-------------------------------------------------------------");

		//Switch to new tab and click update button
		Set<String>handles=driver.getWindowHandles();
		System.out.println(handles);
		Iterator<String>it01=handles.iterator();
		it01.next();
		String wn3= it01.next();
		driver.switchTo().window(wn3);
		driver.switchTo().frame(0);
		updatePrb.click();
		System.out.println("Clicked on problem update button");

		System.out.println("-------------------------------------------------------------");

		//send problem keyword in navigator field
		Set<String>handles01=driver.getWindowHandles();
		System.out.println(handles01);
		Iterator<String>it02=handles.iterator();
		it02.next();
		String wn4= it02.next();
		driver.switchTo().window(wn4);
		TypeIncident.clear();
		TypeIncident.sendKeys("problem");
		//TypeIncident.sendKeys("1123");
		
		System.out.println("entered problem keyword in navigator");

		System.out.println("-------------------------------------------------------------");

		//click first Problem AND Next All field
		ClickProblemALL.click();
		System.out.println("Clicked FRIST Problem AND Next All field");

		System.out.println("-------------------------------------------------------------");

		//Send Already Created problem number to search
		driver.switchTo().frame(0);
		SearchButton.sendKeys(ProblecreateNo);
		//SearchButton.sendKeys("12345678");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		System.out.println("Enterd Already Created problem number to search");

		System.out.println("-------------------------------------------------------------");

		//verify problem created or not
		String t = ProblecreateNo;
		if ( driver.getPageSource().contains( t)){
			System.out.println( t + ":  this number problem created succesfully");

		} else {
			System.out.println("problem not created ");
		}

		System.out.println("-------------------------------------------------------------");


		return new Submittestcase();


	}

}
