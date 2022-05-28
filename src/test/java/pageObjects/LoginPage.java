package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	AppiumDriver driver; 
	
	
	public LoginPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	WebElement allow;

	@AndroidFindBy(id="com.liqvd.digibox.test:id/btnNextIntroOne")
	WebElement firstNextButton;
	
	@AndroidFindBy(id="com.liqvd.digibox.test:id/btnNextIntroOne")
	WebElement secondNextButton;
	
	@AndroidFindBy(id="com.liqvd.digibox.test:id/btnNextIntroOne")
	WebElement getStarted;
	
	@AndroidFindBy(id="com.liqvd.digibox.test:id/edtDigiSpaceName")
	WebElement  digiSpace;
	
	@AndroidFindBy(id="com.liqvd.digibox.test:id/edtEmail")
	WebElement  userName;
	
	@AndroidFindBy(id="com.liqvd.digibox.test:id/edtPassword")
	WebElement  userPassword;
	
	@AndroidFindBy(id="com.liqvd.digibox.test:id/btnSignIn")
	WebElement  signInButton;
	
	@AndroidFindBy(id="com.liqvd.digibox.test:id/tvFolderTitle")
	WebElement homePage_myBoxx;
	
	
	public void click_allow() {
		allow.click();
	}
	
	public void click_firstNext() {
		firstNextButton.click();
	}
	
	public void click_secondNext() {
		secondNextButton.click();
	}
	
	public void click_getStarted() {
		getStarted.click();
	}
	
	public void send_digiSpace(String digispace_value) {
		digiSpace.sendKeys(digispace_value);
	}
	
	public void send_userName(String userName_value) {
		userName.sendKeys(userName_value);
	}
	
	
	public void send_password(String password_value) {
		userPassword.sendKeys(password_value);
	}
	
	public void click_signIn() {
		signInButton.click();
	}

	
	public boolean is_displayedMydiggiBoxx() {
		boolean result = homePage_myBoxx.isDisplayed();
		return result;
	}
	
	
	public void login_actions(String digi_Space, String user_Name, String user_password) {
		click_allow();
		click_firstNext();
		click_secondNext();
		click_getStarted();
		send_digiSpace(digi_Space);
		send_userName(user_Name);
		send_password(user_password);
		click_signIn();
		
	}






}
