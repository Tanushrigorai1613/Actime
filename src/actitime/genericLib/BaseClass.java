package actitime.genericLib;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import actitim.elementRepository.LoginLocators;

public class BaseClass { 
	public WebDriver driver;
	public DataUtility du=new DataUtility();
	public CommonUtility cu=new CommonUtility();
	public static WebDriver listenerDriver;
	
	@BeforeClass(alwaysRun=true)
	public void launchBrowser() throws IOException
	{
		driver=new EdgeDriver();
		listenerDriver=driver;
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod(alwaysRun=true)
	public void login() throws IOException
	{
		driver.get(du.getDataFromProperties("url"));
		LoginLocators ll=new LoginLocators(driver);
		ll.loginApp(du.getDataFromProperties("username"),du.getDataFromProperties("password"));
	}
	@AfterMethod(alwaysRun=true)
	public void logout()
	{
		 driver.findElement(By.id("logoutLink")).click(); 
	}
	@AfterClass(alwaysRun=true)
	public void closeBrowser()
	{
		driver.quit();
	}


}

