package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderInteger {

	@Test(dataProvider="dp1")
	public void Testlogin(Object i) {
		System.out.println(i);
	}
	
	@DataProvider()
	public Object[] dp1() {
		Object[] data=new Object[] {
		
				1,
				"Durgesh",
				"@Durgesh12",
				2
	};
	return data;
	}
}
