package pageObjects;

import java.time.Duration;

import org.aspectj.apache.bcel.generic.TABLESWITCH;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UploadFileInsideFolderPage {
	AppiumDriver driver;
	WebDriverWait wait;

	public UploadFileInsideFolderPage(AppiumDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")
	WebElement addButton_frist;

	@CacheLookup
	@AndroidFindBy(id = "com.liqvd.digibox.test:id/llCreateNewFolder") //xpath = "//android.widget.TextView[@text='Create Folder']")
	WebElement createFolder_first;
	

	
	@CacheLookup
	@AndroidFindBy(id = "com.liqvd.digibox.test:id/edtCreateFolderName" )
	WebElement TypeFolderName_first;
	
	@CacheLookup
	@AndroidFindBy(id = "com.liqvd.digibox.test:id/btnCreateFolder")
	WebElement CreateFolderButton_first;
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.cardview.widget.CardView[1]")
	WebElement folder;
	
	@CacheLookup 
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")
	WebElement AddButton;  
	
	@CacheLookup
	@AndroidFindBy(id= "com.liqvd.digibox.test:id/llUploadFileFolders") //xpath = "//android.widget.TextView[@text='Upload File(s)']")
	WebElement uploadFile;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='image1.jpeg']")
	WebElement largeFile; 
	
	@CacheLookup
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.cardview.widget.CardView[1]")
	WebElement imageExist;
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='pdf-test.pdf']")
	WebElement pdfFile; 
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.cardview.widget.CardView[1]")
	WebElement pdfExist;
	
	//Actions tch = new Actions(driver);
	
	/// Actions on elements
	
	public void click_addButton_first() {
		addButton_frist.click();
	}
	
	public void click_createFolder_first() {
		createFolder_first.click();
	}
	
	public void sendKeys_folderName(String folderName) {
		TypeFolderName_first.sendKeys(folderName);
	}
	
	public void click_CreateFolderButton_first() {
		CreateFolderButton_first.click();
	}
	
	public void click_folder() {
		folder.click();
	}
	
	public void click_addButton() {
		AddButton.click();
	}
	
	public void click_uploadFile() {
		uploadFile.click();
	}
	
	public void click_largeFile(){
		largeFile.click();
		
	}
	
	public void click_pfdFile() {
		pdfFile.click();
	}
	
	
	public void uploadimage_insideFolder(String fname) {
		click_addButton_first();
		click_createFolder_first();
		sendKeys_folderName(fname);
		click_CreateFolderButton_first();
		click_folder();
		click_addButton();
		click_uploadFile();
		click_largeFile();
		wait.until(ExpectedConditions.elementToBeClickable(imageExist));
		
	}
	
	public void uploadPDF_insideFolder() {
		click_addButton();
		click_uploadFile();
		click_pfdFile();
		wait.until(ExpectedConditions.elementToBeClickable(pdfExist));
		
	}
	
	
	
}
