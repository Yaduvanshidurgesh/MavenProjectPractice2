package assertMethodImplementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion {
	public static WebDriver driver;
	SoftAssert soft_Assert = new SoftAssert();

	@BeforeMethod
	public void invokeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );

	}

	@Test
	public void testHardAssert() throws InterruptedException {

		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		String title=driver.getTitle();
		System.out.println(title);

		String expected_title="AlertsDemo - H Y R Tutorials";
		//String actual_title="AlertsDemo - H Y R Tutorial";
		String actual_title1= driver.getTitle();
		Assert.assertEquals(expected_title, actual_title1);
		System.out.println("The title are same ");
		//		if (expected_title==actual_title) {
		//			System.out.println("title matached ");
		//			
		//		} else {
		//          System.out.println("title not matched");
		//		}

		//		SoftAssert softAssert = new SoftAssert();
		//		softAssert.assertEquals(actual_title, expected_title);
		//		
		//		System.out.println("Validating images ");
		//		softAssert.assertEquals(false, false , "image not present");
		//		
		//		System.out.println("validation textbox present ");
		//		softAssert.assertEquals(false, false, "text box not present");
		//		softAssert.assertAll();
		//		
	}

	@Test
	public void testSoftAssert() throws InterruptedException {
		soft_Assert=new SoftAssert();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		String title=driver.getTitle();
		System.out.println(title);
		String currentUrl=driver.getCurrentUrl();
		String expected_title="AlertsDemo - H Y R Tutorials";
		//String actual_title="AlertsDemo - H Y R Tutorial";
		String actual_title1= driver.getTitle();
		soft_Assert.assertEquals(expected_title, actual_title1);
		soft_Assert.assertEquals(currentUrl, "https://www.hyrtutorials.com/p/alertsdemo.html");
		System.out.println("The title are same ");
		soft_Assert.assertAll();
	}

	@Test
	public void title() {
		driver.get("https://www.google.com");
		String expected_title="1Google";
		String actual_title= driver.getTitle();
		Assert.assertEquals(expected_title, actual_title);
	}	

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
