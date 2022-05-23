

package com.sn.utilities;

import java.util.ArrayList;

public class TestUtil
{
	
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel(String Sheetname)
	{
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		try 
		{
			reader=new Xls_Reader("C:\\Users\\hp\\Desktop\\Testing\\mavenprjt\\ServiceNow ATF Scripts\\InHouse Project\\SN-POC\\src\\main\\java\\com\\testdata\\SN_Data.xlsx");
			reader.addColumn("IncidentData","status");
			reader.addColumn("ProblemData","Status");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int rowNum=2;rowNum<=reader.getRowCount("IncidentData");rowNum++)
		{
//			String Caller=reader.getCellData("IncidentData","Caller",rowNum);
//			System.out.println(Caller);
//			String Shortdiscription=reader.getCellData("IncidentData","Shortdiscription",rowNum);
//			System.out.println(Shortdiscription);
//			
//			reader.setCellData("IncidentData","status", rowNum, "Pass");
//			Object ob[]= {Caller, Shortdiscription,};
//			myData.add(ob);
			
			if(Sheetname.equals("IncidentData") )
			{
			String Caller=reader.getCellData("IncidentData","Caller",rowNum);
			System.out.println(Caller);
			String Shortdiscription=reader.getCellData("IncidentData","Shortdiscription",rowNum);
			System.out.println(Shortdiscription);
			reader.setCellData("IncidentData","status", rowNum, "Pass");
			Object ob[]= {Caller, Shortdiscription};
			myData.add(ob);
			}
			else
			{
			String Caller=reader.getCellData("ProblemData","Caller",rowNum);
			String Shortdiscription=reader.getCellData("ProblemData","Shortdiscription",rowNum);
			String problemShortdiscription=reader.getCellData("ProblemData","problemShortdiscription",rowNum);

			System.out.println(problemShortdiscription);
			reader.setCellData("ProblemData","Status", rowNum, "Pass");
			//String ChildShortdescription=reader.getCellData("IncidentData","childshortdescr",rowNum);
			//System.out.println(ChildShortdescription);
			Object ob2[]= {Caller,Shortdiscription,problemShortdiscription};
			myData.add(ob2);
			}
		}
		return myData;
		
	}
	

}