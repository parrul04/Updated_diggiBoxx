package TestsClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.UploadFileTypePage;
import pageObjects.UploadFolderPage;

public class UploadFolderTest extends BaseClass{
	
	LoginPage lp;
	UploadFolderPage upFolder;
	
	@BeforeClass
	public void setUp() throws InterruptedException{
		lp = new LoginPage(driver);
		upFolder = new UploadFolderPage(driver);
		
		// login at class level
		
		lp.login_actions("intern5", "testing2510934@gmail.com", "Gaurav@123");
		System.out.println("Login Successful");
		Thread.sleep(10000);
	}
	
	
	@Test(priority = 1)
	public void test_createFolder() throws InterruptedException {
		

		upFolder.create_folder("NewFolder");
		System.out.println("FOlder created succesfully");
		Thread.sleep(10000);
		
		//upFolder.verify_folderExist();
		
//		SoftAssert sa  = new SoftAssert();
//		boolean result = upFolder.verify_folderExist();
//		sa.assertTrue(result, "Folder creation unsuccessful");		
//		System.out.println("Folder created Successfully");
	}
	
	@Test(dependsOnMethods = {"test_createFolder"}, priority = 2 )
	public void test_renameFolder() throws InterruptedException {
		
		upFolder.renameFolder_actions("Rename_Folder");
		Thread.sleep(10000);
	}
	
	@Test(dependsOnMethods = {"test_renameFolder"}, priority = 3)
	public void test_changeFolderColor() throws InterruptedException {
		
		upFolder.change_FolderColor();
		Thread.sleep(10000);
	}
	
	@Test(priority = 4)
	public void test_createSubfolder(String SubFolder) throws InterruptedException {
		upFolder.create_subFolder(SubFolder);
		System.out.println("SubFolder Created Successfully");
		Thread.sleep(10000);
	}
}
