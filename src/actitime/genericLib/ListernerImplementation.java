package actitime.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListernerImplementation implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String tcname=result.getName();
		TakesScreenshot ts=(TakesScreenshot)BaseClass.listenerDriver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./failedTC/"+tcname+".png");
		try {
			FileUtils.copyFile(scr, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}







//TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
