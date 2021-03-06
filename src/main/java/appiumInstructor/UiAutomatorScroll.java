package appiumInstructor;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UiAutomatorScroll {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Sep6");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		//cap.setCapability("appActivity", "io.appium.android.apis.preference.SwitchPreference");
		AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

		MobileElement m1= (MobileElement) ((FindsByAndroidUIAutomator)driver)
				.findElementByAndroidUIAutomator("new UiSelector().text(\"Views\")");
		System.out.println(m1.getText());
		m1.click();

		Thread.sleep(2000);
	
//scrolling using uiAutomator Frameowrk

		
		MobileElement m2 = (MobileElement) ((FindsByAndroidUIAutomator)driver)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
				         ".scrollIntoView(new UiSelector().text(\"TextFields\"))");
		
		m2.click();
		
		
		driver.navigate().back();
		
				
	}
}
	