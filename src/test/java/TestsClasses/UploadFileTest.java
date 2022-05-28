package TestsClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoginPage;
import pageObjects.UploadFileTypePage;

public class UploadFileTest extends BaseClass{
	
	LoginPage lp;
	UploadFileTypePage upFile;
	
	@BeforeClass
	public void setUp(){
		lp = new LoginPage(driver);
		upFile = new UploadFileTypePage(driver);
	}
	
	@Test
	public void addVideoTest() throws InterruptedException {
		lp.login_actions("intern5", "testing2510934@gmail.com", "Gaurav@123");
		Thread.sleep(10000);
		upFile.upload_file();
		
		Thread.sleep(15000);
//		SoftAssert sa = new SoftAssert();
//		boolean result = upFile.videoFile_DIsplayed();
//		sa.assertTrue(result, "File Uploade Fails");
//		System.out.println("File upload Successfull");
		
	}
}
