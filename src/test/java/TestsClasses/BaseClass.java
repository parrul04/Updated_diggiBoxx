package TestsClasses;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.LoginPage;

public class BaseClass {
	

	LoginPage login;
	AppiumDriver driver;
	boolean result;
	WebDriverWait wait;
	
	@BeforeTest
	public void browserLoading() throws MalformedURLException, InterruptedException {
		
		
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			String projectPath = System.getProperty("user.dir");
			String apkPath = null;
			String appPath = apkPath;
			
			appPath = projectPath + "" + "/apk/digiboxx.apk";
			cap.setCapability("app", appPath);
			cap.setCapability(CapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			
			cap.setCapability("appPackage", "com.liqvd.digibox.test");
			cap.setCapability("appActivity", "com.liqvd.digibox.ui.MainActivityNew");
			
//			cap.setCapability("autoGrantPermissions",true);
//			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver(url, cap);
			driver = new AndroidDriver(url, cap);
			driver = new IOSDriver(url, cap);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			//Thread.sleep(6000);
		}
		
		catch(Exception exp){
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
			exp.printStackTrace();
		}
		
	}
	
	@Test
	public void sampleTest() {
		//System.out.println("Running Base class");
	}
	
	@AfterTest
	public void tearDown() {
		
	}
}
