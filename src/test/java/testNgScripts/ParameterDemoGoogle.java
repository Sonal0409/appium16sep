package testNgScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ParameterDemoGoogle {
	
	@Parameters({"Input","clickInput"})
	@Test
	public void webappGoogle(String Input, String clickInput) throws MalformedURLException, InterruptedException
	{

		
		  DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability("deviceName", "96352732140005T");
			cap.setCapability("platformName", "ANDROID");
			cap.setCapability("platformVersion", "11");
		    cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		    cap.setCapability("chromedriverExecutable","C:\\Users\\sonal\\Downloads\\chromedriver_win32\\chromedriver.exe");

			AppiumDriver <MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			
		
		driver.get("https://www.google.com/");	
			
		Thread.sleep(2000);
		
		driver.findElementByXPath("//*[@id=\"tsf\"]/div[1]/div[1]/div[1]/div/div[1]/input").click();
		
		Thread.sleep(1500);
		
		
		driver.findElementByXPath("//*[@id=\"tsf\"]/div[1]/div[1]/div[1]/div/div[1]/input").sendKeys(Input);
		
		Thread.sleep(5000);
		
		List<MobileElement> result	=driver.findElementsByXPath("//ul[@role='listbox']/child::*");
		
		// start a loop on results list items and match a string with each item, click on it if item matches

	for(MobileElement temp: result)
	{
		
		if(temp.getText().contains(clickInput))
		{
			System.out.println(temp.getText());
			temp.click();
			break;
		}
	}
		
		
			
	}

}
