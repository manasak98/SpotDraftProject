package com.spotDraft.testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.spotDraft.generic.BaseClass;

public class goodReadsAutomation extends BaseClass {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./data/signInDataOne.xlsx");
		//creating a workbook
		Workbook wb=WorkbookFactory.create(fis);
		String url = wb.getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();
     	//Enter the url
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//click on sign in 
		driver.findElement(By.xpath("//a[text()='Sign In']")).click();
		//click on singin with email
		driver.findElement(By.xpath("//a[2]/button")).click();
		//getting the email and password from the excel sheet
		String email = wb.getSheet("sheet1").getRow(1).getCell(1).getStringCellValue();
		String password = wb.getSheet("sheet1").getRow(1).getCell(2).getStringCellValue();
		//Enter the email,password and click on signin button
		driver.findElement(By.id("ap_email")).sendKeys(email);
		Thread.sleep(3000);
		driver.findElement(By.id("ap_password")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(10000);
//		driver.findElement(By.id("ap_password")).sendKeys(password);
//		String str = JOptionPane.showInputDialog("Enter the captcha");
//		WebElement ele=driver.findElement(By.xpath("//input[@id='auth-captcha-guess']"));
//		ele.sendKeys(str);
//		driver.findElement(By.xpath("//span[@id='a-autoid-0']")).click();
		//searching the book in search box
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("The Alchemist");
		//selecting the first option
		driver.findElement(By.xpath("//div[text()='The Alchemist']")).click();
		Thread.sleep(5000);
		//click on want to read button
		driver.findElement(By.xpath("//span[text()='Want to read']")).click();
		Thread.sleep(5000);
		//click on My Book list button
		driver.findElement(By.xpath("//a[text()='My Books']")).click();
		//Removing the book from My Book list
		driver.findElement(By.xpath("//img[@title='Remove from my books']")).click();
		Thread.sleep(5000);
		//Handling Notification pop-up
		driver.switchTo().alert().accept();
		//click on profile icon
		driver.findElement(By.xpath(".//div[@class='dropdown dropdown--profileMenu']")).click();
        //click on sign out
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		//closing the browser
		BaseClass bs=new BaseClass();
        bs.openBrowser();
		bs.closeBrowser();
	}

}
