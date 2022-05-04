package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderObjectNewFormat {

	@Test(dataProvider="Create")
	public void Testlogin(String userName,String password, String areaname, String plantname) {
		System.out.println(userName+"===="+password+"===="+areaname+"==="+plantname);
	}
	
	@DataProvider(name = "Create")
	public Object[][] datasets() 
	{
		return new Object[][]
		{
		  {"username","password","AREA","UNIT"},
		  {"username1","password","AREA1","UNIT1"},
		  {"username2","password","AREA2","UNIT2"},
		  {"username3","password","AREA3","UNIT3"},
     	};
	}
}
