package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UploadFileTypePage {
	
	AppiumDriver driver;
	
	public UploadFileTypePage(AppiumDriver driver) {
		this.driver = driver;
		//Thread.sleep(10000);
		//refresh the page
		//driver.navigate().to(driver.getCurrentUrl());
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//driver.navigate().to(driver.getCurrentUrl());
	}
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")
	WebElement addButton;
	
	@CacheLookup
	@AndroidFindBy(id= "com.liqvd.digibox.test:id/llUploadFileFolders")
	WebElement uploadFile;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='image5.jpeg']")
	WebElement imageFile;
	
	
//	@AndroidFindBy(xpath = "	\r\n"+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.cardview.widget.CardView[1]")
//	WebElement videoFileExist;
	
//	@AndroidFindAllBy(xpath="//android.widget.TextView[@resource-id='com.liqvd.digibox.test:id/tvName']")
//	WebElement allFilesUploaded;
//	public void select_file(WebElement fileElement) {
//		fileElement.click();
//	} 
//	
	public void click_AddButton() {
		addButton.click();
	}
	
	public void click_uploadFile() {
		uploadFile.click();
	}
	
	public void select_file() {
		imageFile.click();
	} 
	
	public void upload_file() {
		click_AddButton();
		click_uploadFile();
		select_file();
	}
	
//	public boolean videoFile_DIsplayed() {
//		boolean result = videoFileExist.isDisplayed();
//		return result;
//	}
//	
}