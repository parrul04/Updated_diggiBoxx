package TestsClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.UploadFileInsideFolderPage;



public class UploadFileInsideFolderTest extends BaseClass{
	
	LoginPage login;
	UploadFileInsideFolderPage insideFolder;
	
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		login = new LoginPage(driver);
		insideFolder = new UploadFileInsideFolderPage(driver);
		
		
		// login the app
		login.login_actions("intern5", "testing2510934@gmail.com", "Gaurav@123");
		System.out.println("Login Successful");
		Thread.sleep(10000);

	}
	
	@Test(priority=1)
	public void test_uploadImageFileInsideFolder() throws InterruptedException {
		
		insideFolder.uploadimage_insideFolder("NewFolder");
		Thread.sleep(10000);
		System.out.println("Image upload inside folder successfull");
	}
	
	
	@Test(priority=2, dependsOnMethods = {"test_uploadImageFileInsideFolder"})
	public void test_uploadPdfFileInsideFolder() throws InterruptedException {
		
		insideFolder.uploadPDF_insideFolder();
		Thread.sleep(10000);
		System.out.println("Pdf upload inside folder successfull");
	}
}
