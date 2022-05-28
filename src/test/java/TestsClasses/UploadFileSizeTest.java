package TestsClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.UploadFileSizePage;

public class UploadFileSizeTest extends BaseClass{
	LoginPage login;
	UploadFileSizePage fileSize;
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		login = new LoginPage(driver);
		fileSize = new UploadFileSizePage(driver);
		
		// login the app
		login.login_actions("intern5", "testing2510934@gmail.com", "Gaurav@123");
		System.out.println("Login Successful");
		Thread.sleep(10000);
		
//		fileSize.delete_existingFiles();
//		Thread.sleep(30000);
	}
	
	@Test(priority = 1)
	public void test_smallFileSize() throws InterruptedException {
		Thread.sleep(6000);
		fileSize.upload_smallFile();
		//System.out.println("Small Size file upload successful");
		Thread.sleep(50000);
		fileSize.verify_smallFileSuccessFull();
		Thread.sleep(10000);
	}
	
	
	@Test(priority = 2)
	public void test_largeFileSize() throws InterruptedException {
		//driver.navigate().refresh();
		Thread.sleep(6000);
		fileSize.upload_largeFile();
		//System.out.println("Large Size file upload successful");
		Thread.sleep(50000);
		fileSize.verify_largeFileSuccessFull();
		Thread.sleep(10000);
	}
}
