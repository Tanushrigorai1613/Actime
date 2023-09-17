package actitime.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import actitime.genericLib.BaseClass;

public class DropdownHandling extends BaseClass {
	@Test(groups= {"system"})
	public void handleDropdown()
	{
		String expmsg="MODIFICATIONS NOT SAVED";
		driver.findElement(By.xpath("//div[@class='menuTable']/div[2]")).click(); 
		driver.findElement(By.xpath("//div[contains(text(),'configure actiTIME')]")).click();
		WebElement usergroups = driver.findElement(By.id("userGroupNamingCodeSelect"));
		cu.getSelectByVsibleText(usergroups,"Location");
		String msg=driver.findElement(By.id("FormModifiedTextCell")).getText();
		 //System.out.println(msg);
		Reporter.log(msg, true); 
		Assert.assertEquals(expmsg, msg);
		System.out.println("dropdown TC is pass");
	}

}