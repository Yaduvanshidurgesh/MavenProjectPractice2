package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderString {

	@Test(dataProvider="dp1")
	public void Testlogin(String s) {
		System.out.println(s);
	}
	
	@DataProvider()
	public String[] dp1() {
		String[] data=new String[] {
		
				"abcd",
				"abc",
				"ab"
	};
	return data;
	}
}
