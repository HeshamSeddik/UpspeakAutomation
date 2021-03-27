package appiumtests;


import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;

public class Methods {
	
	public static AndroidDriver <MobileElement> driver;
	public static WebDriverWait wait;
	public static final String BASE_VIEW_ID = "com.voctag.android.staging:id/";
	
	public static final String SETTINGS_BTN_ID = "toolbarSettingsImageView";
	public static final String DIALOGUE_GOT_IT_BTN_ID = "android:id/button1";
	public static final String INTRO_LOGIN_BTN_ID = "tv_intro_login";
	public static final String NAV_PROFILE_TAB = "tabbar_profile";
	public static final String FACEBOOK_BTN_ID = "btn_facebook";
	public static final String FORGOT_PASSWORD_BTN_ID = "tv_forgot_password";	
	public static final String SUBMIT_BTN_ID = "btn_submit";
	public static final String LOGOUT_ID = "settingLogout";
	public static final String CONFIRM_LOGOUT_ID = "btn_logout";
	public static final String CREATE_ACCOUNT_ID = "btn_create_account";
	public static final String LOGIN_ID = "btn_login";
	public static final String ET_CONFIRM_PASSWORD_ID = "et_confirm_password";
	public static final String LOGIN_PASSWORD_ID = "et_login_password";
	public static final String LOGIN_EMAIL_ID = "et_login_email";
	public static final String ET_USERNAME_ID = "et_username";
	public static final String COURSES_TITLE_ID = "tb_courseslist";
	public static final String SNACKBAR_ID = "snackbar_text";
	
	public static String correctEmail = "hseddik@identity-solutions.org";
	public static String correctPassword = "123456";
	
	public static String incorrectEmail = "hseddikk@identity-solutions.org";
	public static String incorrectPassword = "1234567";
	
	public static void clickOneIndex(String id, int index) {
		List<MobileElement> elements = listing(id);
		clickIndex(elements, index);
	}
	
	public static MobileElement find(String id) {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + id)));
		wait.until(elementFound(By.id(BASE_VIEW_ID + id)));
		return driver.findElement(By.id(BASE_VIEW_ID + id));
	}
	
	public static MobileElement findNoBaseId(String id) {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + id)));
		wait.until(elementFound(By.id(id)));
		return driver.findElement(By.id(id));
	}
	
	public static void click(String id) {
//		wait.until(elementFound(By.id(BASE_VIEW_ID + id)));
		find(id).click();
		return;
	}
	
	public static void clickNoBaseId(String id) {
//		wait.until(elementFound(By.id(BASE_VIEW_ID + id)));
		findNoBaseId(id).click();
		return;
	}
	
	public static void fillIn(String id, String text) {
		find(id).sendKeys(text);
		return;
	}
	
	public static List<MobileElement> listing(String id) {
		System.out.println("Trying to retrive the List");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + id)));
		wait.until(elementFound(By.id(BASE_VIEW_ID + id)));
		List<MobileElement> parent = driver.findElements(By.id(BASE_VIEW_ID + id));
		System.out.println("List retrieved...");
		System.out.println(parent.size());
		return parent;
	}
	
	
	public static void clickIndex(List<MobileElement> p, int index) {
		p.get(index).click();
		return;
	}
	
	public static void clickIndexRange(String id, int i, int j) {
		List<MobileElement> elementList = listing(id);
		for(;i<=j;i++) {
			clickIndex(elementList, i);
		}
	}
	
	public static void assertElement(String id) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID+id))).isDisplayed();
		
	}
	
	public static void assertElementText(String description) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(description))).isDisplayed();
		
	}
	
	public static void assertIsSelected(String description) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(description))).isSelected();
		
	}
	
	public static boolean assertPageTitle(String id) {
		String x = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + "tv_title"))).getText();
		boolean y = x.trim() == id;
		System.out.println(y);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + "tv_title"))).getText() == id;
	}
	
	public static int randomNumberGenerator(int range) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(range);
	}
	
	
	public static void delay(int secs) {
		try {
			TimeUnit.SECONDS.sleep(secs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private static ExpectedCondition<Boolean> elementFound(final By locator) {
	    return new ExpectedCondition<Boolean>() {
	    	public Boolean apply(WebDriver driver) {
	            WebElement el = driver.findElement(locator);
	            return el != null;
	        }
	    };
	}
	
//	private static ExpectedCondition<Boolean> elementsFound(final By locator) {
//	    return new ExpectedCondition<Boolean>() {
//	    	public Boolean apply(WebDriver driver) {
//	    		List<WebElement> el = driver.findElements(locator);
//	            return el != null;
//	        }
//	    };
//	}
}
