package TestsClasses;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage login;

	
	@Test
	public void login() throws InterruptedException {
		login = new LoginPage(driver);
		login.login_actions("intern5", "testing2510934@gmail.com", "Gaurav@123");
		
		Thread.sleep(6000);
		result = login.is_displayedMydiggiBoxx();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(result, "Login Unsuccessful");
		System.out.println("Login Successful");
	}
	
	

}
