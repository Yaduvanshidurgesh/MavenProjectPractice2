package com.pdf.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PDFReader {

	@Test
	public void ReadPDFFile() throws Exception {
	WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		File file=new File("C:\\Project2\\Asset_Pdf\\PID11406 - Copy (2).pdf");
		FileInputStream fis=new FileInputStream(file);
		
		
//		
//		String urlString=driver.getCurrentUrl();
//		URL url =new URL(urlString);
//		
		PDDocument pdfDocument= PDDocument.load(fis);
		System.out.println("Total number in pdf page is : " +pdfDocument.getPages().getCount());
		PDFTextStripper pdfTextStripper=new PDFTextStripper();
		pdfTextStripper.endText();
		String pdfdocread=pdfTextStripper.getText(pdfDocument);
		System.out.println(pdfdocread);
		
		Assert.assertTrue(pdfdocread.contains("AI-STD-DR-PID-016\r\n"
				+ ""));
		String actual="AI-STD-DR-PID-016";
		String expected="AI-STD-DR-PID-016";
		Assert.assertEquals(actual.equalsIgnoreCase(expected), true);
		
		System.out.println();
		pdfDocument.close();
		fis.close();
		
	}
}
