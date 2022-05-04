package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderObject {

	@Test(dataProvider="dp1")
	public void Testlogin(Integer i) {
		System.out.println(i);
	}
	
	@DataProvider()
	public Integer[] dp1() {
		Integer[] data=new Integer[] {
		
				1,
				2,
				3
	};
	return data;
	}
}
