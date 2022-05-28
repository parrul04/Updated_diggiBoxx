package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UploadFileSizePage{
	
	AppiumDriver driver;
	
	public UploadFileSizePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// lazy load concept. It is a variant of implicit wait using the class AjaxElementLocatorFactory. 
		 
	}
	
	// locators
//	
//	@CacheLookup
//	@AndroidFindBy(id = "com.liqvd.digibox.test:id/ivSelectAll")
//	WebElement selectAll;
//	
//	@CacheLookup
//	@AndroidFindBy(id = "com.liqvd.digibox.test:id/ivDelete")
//	WebElement deleteAll;
//	
//
//	@CacheLookup
//	@AndroidFindBy(id = "com.liqvd.digibox.test:id/tvContinue")
//	WebElement deleteConfirm;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")
	WebElement addButton;
	
	@CacheLookup
	@AndroidFindBy(id= "com.liqvd.digibox.test:id/llUploadFileFolders")
	WebElement uploadFile;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='large_file.zip']")
	WebElement large_File;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='image_mb.jpeg']")
	WebElement small_File;
	
	@CacheLookup
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/androidx.cardview.widget.CardView[1]")
	WebElement small_fileUploadVerify;
	
	@CacheLookup
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/androidx.cardview.widget.CardView[1]")
	WebElement large_fileUploadVerify;
	
//	// delete all existing data
//	public void click_selectAll() {
//		selectAll.click();
//	}
//	
//	public void click_delete() {
//		deleteAll.click();
//	}
//	
//	public void click_deleteConfirm() {
//		deleteConfirm.click();
//	}
	
	// file upload locators
	
	public void click_AddButton() {
		wait.until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();
	}
	
	public void click_uploadFile() {
		uploadFile.click();
	}
	
	public void small_fileClick() {
		small_File.click();
	}
	
	public void large_fileClick() {
		large_File.click();
	}
	
//	
//	public void delete_existingFiles(){
//		click_selectAll();
//		click_delete();
//		click_deleteConfirm();
//		
//	}
	
	public void upload_smallFile() {
//		uplodeFile.click_AddButton();
//		uplodeFile.click_uploadFile();
		click_AddButton();
		click_uploadFile();
		small_fileClick();
		System.out.println("Small Size file: " + " " + small_File.getText() + "upload successful");
	}
	
	public void upload_largeFile() {
//		uplodeFile.click_AddButton();
//		uplodeFile.click_uploadFile();
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(addButton)));
		driver.navigate().refresh();
		click_AddButton();
		click_uploadFile();
		large_fileClick();
		System.out.println("Small Size file: " + " " + large_File.getText() + "upload successful");
	}
	
	// Verify uploads Successfull
	
	
	public void verify_smallFileSuccessFull() {
		if(small_fileUploadVerify.isDisplayed()) {
			System.out.println("Small file upload successful");
		}
		else {
			System.out.println("Small file upload Unsuccessful");
		}
	}
	
	public void verify_largeFileSuccessFull() {
		if(large_fileUploadVerify.isDisplayed()) {
			System.out.println("Small file upload successful");
		}
		else {
			System.out.println("Small file upload Unsuccessful");
		}
	}
}
