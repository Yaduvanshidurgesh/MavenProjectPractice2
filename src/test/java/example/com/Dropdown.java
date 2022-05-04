package example.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown  {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		
		
//		In HTML we have dropdown controls we use very often, There are two types of dropdown available.
//		Single-Selection Dropdown
//		Muli-Selection Dropdown
//		This page can be used for practicing the above controls using selenium.
		
		
		
		
		//For Single-Selection Dropdown
//		WebElement element = driver.findElement(By.id("course"));
//		Select select=new Select(element);
//		select.selectByIndex(1);
//		select.selectByVisibleText("Dot Net");
//		select.selectByValue("python");
//		Thread.sleep(3000);
		
		//For Muli-Selection Dropdown
		WebElement web=driver.findElement(By.id("ide"));
		Select multielement = new Select(web);
		multielement.selectByIndex(0);
		Thread.sleep(3000);
		multielement.selectByValue("ij");
		Thread.sleep(3000);
		multielement.selectByVisibleText("NetBeans");
		Thread.sleep(3000);
	}
}
