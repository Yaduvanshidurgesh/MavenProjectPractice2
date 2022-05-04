package example.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	@Test
	public void AlertBox() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
//		String title=driver.getTitle();
//		org.openqa.selenium.Alert simpleAlert = new org.openqa.selenium.Alert();
//	    simpleAlert.getText();
		
		
		
			
//		 Thread.sleep(2000);
//		 simpleAlert.dismiss();
//		
}
}
