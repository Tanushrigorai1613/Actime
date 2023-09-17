package actitime.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import actitime.genericLib.BaseClass;
import actitime.genericLib.CommonUtility;
import actitime.genericLib.DataUtility;

public class AlertPopupHandling extends BaseClass{
	@Test(groups= {"smoke"})
	public void alertHandling() throws EncryptedDocumentException,IOException {
		 String expectedmsg= "Are you sure you want to cancel the Type of Work creation?";
		 driver.findElement(By.xpath("//div[2][@class='topMenuButton preventPanelsHiding']")).click();
		 driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
		 driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
	        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(du.getDataFromExcelsheet("Sheet3", 2, 1));
	        driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")).click();
	        String actualmsg= cu.getAlertMsg(driver);
	        Reporter.log(actualmsg,true);
	        cu.alertOk(driver);
	        SoftAssert sa = new SoftAssert();
	        sa.assertEquals(expectedmsg,actualmsg);
	        System.out.println("alert TC is pass");
	        sa.assertAll();
		} 


}
