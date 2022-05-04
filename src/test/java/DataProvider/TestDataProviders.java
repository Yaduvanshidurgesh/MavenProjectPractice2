package DataProvider;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDataProviders {

	WebDriver driver;

	@BeforeMethod
	public void invokeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "dataProvider")
	public void goToFacebook(String scenario , String emailId, String password) throws InterruptedException {
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(emailId);
	    driver.findElement(By.id("pass")).sendKeys(password);
	    driver.findElement(By.cssSelector("button[name='login']")).click();
	  //  Assert.assertTrue(driver.findElement(By.linkText("Durgesh")).isDisplayed(),"Login successfull");
		
//		WebElement PassFail =driver.findElement(By.cssSelector("button[name='login']"));
//		PassFail.click();
//		if (PassFail.isSelected()) {
//			System.out.println("login suceessfull");
//		} else {
//           System.out.println("Login not sucessfull");
//		}
	    
	    
		
		if (scenario.equals("correctusernameandpassword")) {
			//WebElement account=driver.findElement(By.linkText("Durgesh"));
			//Assert.assertTrue(account.isDisplayed(),"Login not success");
			//or
			Assert.assertTrue(driver.findElement(By.linkText("Durgesh")).isDisplayed(),"Login successfull");
			System.err.println("login successfull");
			
		}else if(scenario.equals("Wrongusernameandpassword")){
			String errormessage=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/form/div[1]/div[2]")).getText();
			Thread.sleep(5000);
			Assert.assertEquals(errormessage,  "It looks like you entered a slight misspelling of your email or username.");
			Thread.sleep(5000);
			
		} 
		else if (scenario.equals("currectusername")) {
			String errormessage=driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
			Thread.sleep(5000);
			Assert.assertEquals(errormessage, "The password that you've entered is incorrect.");
			Thread.sleep(5000);
		}else {
			String errormessage=driver.findElement(By.xpath("//div[@id='error_box']")).getText();
			Assert.assertEquals(errormessage, "It looks like you entered a slight misspelling of your email or username.");
		}
		
		
		
//		try {
//			SoftAssert softAssert = new SoftAssert();
//			driver.get("https://www.facebook.com/");
//			//driver.findElement(By.id("email")).clear();
//			driver.findElement(By.id("email")).sendKeys(emailId);
//			//driver.findElement(By.id("pass")).clear();
//			driver.findElement(By.id("pass")).sendKeys(password);
//			WebElement element = driver.findElement(By.cssSelector("button[name='login']"));
//			element.submit();
//			softAssert.assertEquals(false, element.isSelected());
//			System.out.println("submit button is not clicked");
//			Thread.sleep(20000);
//			softAssert.assertAll();
//
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
	}

	@DataProvider(name = "dataProvider")
	public Object[][] getData() {
		Object[][] values = null;
		values = new Object[][] {
			                      
			                     {"correctusernameandpassword","durgeshyaduvanshi96@gmail.com", "@durgesh21TE@WB" },
				                 {"Wrongusernameandpassword", "durgeshyaduvanshi@gmail.com", "@durgesh21TE@W" } ,
				                 {"currectusername","durgeshyaduvanshi96@gmail.com", "@durgesh21TE@W"}
				                 
		                          };
		     return values;
	}

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}
