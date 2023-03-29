package practice;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtillities.BaseClass;
import vtiger.GenericUtillities.ExcelFileUtility;

public class CreateMultipleOrgwithIndustryTest extends BaseClass {
	
	@Test
	public void createMultipleOrg()	{
		
	}
	
	@DataProvider
	public void getData() throws IOException   {
		
		Object[][] data = eUtil.readMultipleData("MultipleOrg");
		
		
	}

}
