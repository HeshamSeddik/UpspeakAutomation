package appiumtests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class AutomationMethods extends Methods {
	
	public static void login(){	
		fillIn(LOGIN_EMAIL_ID, correctEmail);
		fillIn(LOGIN_PASSWORD_ID, correctPassword);
		click(LOGIN_ID);
	}
	
	public static void navigateToLogin() {
		click(INTRO_LOGIN_BTN_ID);
	}
	
	public static void checkSuccessfulLogin() {
		find(COURSES_TITLE_ID);
	}
	
	public static void logout(){	
		click(NAV_PROFILE_TAB);
		clickNoBaseId(DIALOGUE_GOT_IT_BTN_ID);
		click(SETTINGS_BTN_ID);
		click(LOGOUT_ID);
	}
	
	public static void checkSuccessfulLogout() {
		find(INTRO_LOGIN_BTN_ID);
	}
	
	public static void checkUnsuccessfulLogout() {
		find(SNACKBAR_ID);
	}
	
	public static void invalidLogin(){	
		fillIn(LOGIN_EMAIL_ID, incorrectEmail);
		fillIn(LOGIN_PASSWORD_ID, incorrectPassword);
		click(LOGIN_ID);
	}
}
