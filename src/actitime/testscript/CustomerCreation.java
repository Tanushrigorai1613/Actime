package actitime.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import actitime.genericLib.BaseClass;
import actitime.genericLib.CommonUtility;
import actitime.genericLib.DataUtility;
@Listeners(actitime.genericLib.ListernerImplementation.class)
public class CustomerCreation extends BaseClass {
	@Parameters({"customername"})
	@Test(groups= {"system","smoke"})
	public void createCustomer(String customername) throws EncryptedDocumentException, IOException {
		int num=cu.getRandomNum(1000);
		//String customername=du.getDataFromExcelSheet("Sheet1", 3, 1);
		customername=customername+num;
	
		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
	    driver.findElement(By.xpath("//div[text()='Add New']")).click();
	    driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
	    driver.findElement(By.className("newNameFiel")).sendKeys(customername);
        driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys("testing");
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        cu.gettextToBePresentedInElementLocated(driver,By.cssSelector(".titleEditButtonContainer>.title"),customername);
        String actualcustomername=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
        SoftAssert sa=new SoftAssert();
        sa.assertTrue(customername.contains(actualcustomername));
        Reporter.log(actualcustomername, true);
        System.out.println("pass");
        sa.assertAll();
	}

}


