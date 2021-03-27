package appiumtests;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTests extends AutomationMethods{
	
	
	@BeforeTest
	public static void initialization() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		
//		cap.setCapability("deviceName", "Galaxy J7 (2016)");
//		cap.setCapability("udid", "52034a51fc3a83fb");
//		cap.setCapability("platformName", "Android");
//		cap.setCapability("platformVersion", "8.1.0");
		
		cap.setCapability("deviceName", "Lenovo");
		cap.setCapability("udid", "f6a8d454");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("appPackage", "com.voctag.android.staging");
		cap.setCapability("appActivity", "com.voctag.android.ui.LauncherActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url, cap);
		wait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("Application started...");
		
	}
	
	@Test (priority = 0)
	public static void validEmailLogin() {
		navigateToLogin();
		login();
		checkSuccessfulLogin();
	}
	
	
	@Test (priority = 1)
	public static void betweenTests() {
		delay(1);
		driver.startActivity(new Activity("com.voctag.android.staging", "com.voctag.android.ui.main.MainActivity"));
		logout();
		checkSuccessfulLogout();
	}
	
	@Test (priority = 2)
	public static void invalidEmailLogin() {
		navigateToLogin();
		invalidLogin();
		checkUnsuccessfulLogout();
	}
}