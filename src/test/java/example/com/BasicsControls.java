package example.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicsControls {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		
		
//		In HTML we have some basic controls we use often, those are:
//			Textbox
//			Radiobutton
//			Checkbox
//			Link
//			Button
//			Label
		
		driver.findElement(By.id("firstName")).sendKeys("Durgesh");
		driver.findElement(By.id("lastName")).sendKeys("Yaduvanshi");
		
		driver.findElement(By.name("gender")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("englishchbx")).click();
		
		driver.findElement(By.id("hindichbx")).click();
		driver.findElement(By.id("email")).sendKeys("durgeshyaduvanshi108@gmail.com");
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("registerbtn")).click();
		
		Thread.sleep(2000);
        driver.findElement(By.linkText("Click here to navigate to the home page")).click();
        
        
	}
}
