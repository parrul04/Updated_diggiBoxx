package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UploadFolderPage {
		
	AppiumDriver driver;
	WebDriverWait wait;

	
	public UploadFolderPage(AppiumDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//		Thread.sleep(10);
	}
	
	
	/// **************  LOCATORS *****************
	// create folder locators
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")
	WebElement addButton;

	@CacheLookup
	@AndroidFindBy(id = "com.liqvd.digibox.test:id/llCreateNewFolder") //xpath = "//android.widget.TextView[@text='Create Folder']")
	WebElement createFolder;
	

	
	@CacheLookup
	@AndroidFindBy(id = "com.liqvd.digibox.test:id/edtCreateFolderName" )
	WebElement TypeFolderName;
	
	@CacheLookup
	@AndroidFindBy(id = "com.liqvd.digibox.test:id/btnCreateFolder")
	WebElement CreateFolderButton;
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView") //[@text='NewFolder']
	WebElement FolderExist;
	
	
	//// REname folder locators
	
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"kabab menu\"][1])")
	WebElement folderPropertiesOpen;
	
	@CacheLookup
	@AndroidFindBy(id = "com.liqvd.digibox.test:id/textView11")
	WebElement renameFolder;
	
	@CacheLookup
	@AndroidFindBy(id="com.liqvd.digibox.test:id/edtReNameFolder")
	WebElement renameFolderTextBox;
	
	@CacheLookup
	@AndroidFindBy(id="com.liqvd.digibox.test:id/btnReNameFolder")
	WebElement renamFolder_Btn;
	
	// Change color locators
			
	@CacheLookup
	@AndroidFindBy(id = "com.liqvd.digibox.test:id/textView10")
	WebElement changeColor;
	
	@CacheLookup
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.View")
	WebElement selectColor;
	
	@CacheLookup
	@AndroidFindBy(id = "com.liqvd.digibox.test:id/btnApply")
	WebElement applyColor;
	
	// create subfolder locators
	
	@CacheLookup
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/androidx.cardview.widget.CardView[1]")
	WebElement folder;
	
	// 2) Add
	//3). Create folder button
	//4  enter foldername  - TypeFolderName
	//5. CreateFolderButton
	// android.widget.TextView- sub
	
//	@CacheLookup
//	@AndroidFindBy(id = "com.liqvd.digibox.test:id/add")
//	WebElement Add;
//	
//	@CacheLookup
//	@AndroidFindBy(id = "com.liqvd.digibox.test:id/llCreateNewFolder")
//	WebElement CreateFolder;
	
	
	public void click_AddButton() {
		addButton.click();
	}	
	
	public void create_folder_click() {
		createFolder.click();
	}
	
	public void send_folderName(String folder) {
		TypeFolderName.clear();
		TypeFolderName.sendKeys(folder);

	}

	public void click_CreateFolder_Button() {
		CreateFolderButton.click();
	}
		
	
//	
//	public boolean verify_folderExist() {
//		Boolean result = FolderExist.isDisplayed();
//		return result;
//	}
	
	public void verify_folderExist() {
		if(FolderExist.getText().contains("NewFolder")) {
			System.out.println("Folder created Successfully");
		}
	}
	
	// actions for rename folder
	
	
	// id="com.liqvd.digibox.test:id/ivMenu"
	//class =  android.widget.TextView
	
	
	public void open_folderProperties() {
		//wait.until(ExpectedConditions.elementToBeClickable(folderPropertiesOpen));
		folderPropertiesOpen.click();
	}
	
//	public void open_folderProperties() {
//		
//	}
	
	public void click_renameFolder() {
		renameFolder.click();
	}
	
	public void enter_newFolderName(String newName) {
		renameFolderTextBox.sendKeys(newName);
	}
	
	public void click_createButton() {
		renamFolder_Btn.click();
	}
	
	
	// change color actions
	public void click_changeColor() {
		changeColor.click();	}
	
	public void select_color() {
		selectColor.click();
		}
	
	public void click_applyColor() {
		applyColor.click();
	}
	
	// create sub folder actions
	
	public void click_folder() {
		folder.click();
	}
	
	
	
	// calling functions from test class
	
	// Create Folder
	public void create_folder(String folderName) {
		click_AddButton();
		create_folder_click();
		send_folderName(folderName);
		System.out.println("Folder Name sent");
		click_CreateFolder_Button();
		
	}
	
	
	// Rename Folder
	public void renameFolder_actions(String rename_folder) {
		open_folderProperties();
		click_renameFolder();
		enter_newFolderName(rename_folder);
		click_createButton();
		
	}
	
	
	// change color
	public void change_FolderColor() {
		open_folderProperties();
		click_changeColor();
		select_color();
		click_applyColor();
	}
	
	// create subfolder
	public void create_subFolder(String subFolder) {
		click_folder();
		click_AddButton();
		create_folder_click();
		send_folderName(subFolder);
		System.out.println("Sub Folder Name sent");
		click_CreateFolder_Button();
	}
}
