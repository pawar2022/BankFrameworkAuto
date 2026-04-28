package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Login_Page;
import testBase.BaseClass;


@Listeners(utilities.ExtentListener.class)
public class TC_002_LoginTest extends BaseClass {
	
	@Test
	public void verifyLogin() {
		
		
		logger.info("- - Login Test - - ");
		
		Login_Page lp = new Login_Page(driver);
		
		lp.enterusname(prop.getProperty("username"));
		
		lp.enterpswd(prop.getProperty("pswd"));
		
		lp.clicklgnbtn();
		
		
		 // Validation
        String title = driver.getTitle();

        Assert.assertTrue(
        		
            title.toLowerCase().contains("parabank")
        );

        logger.info("Login Test Passed");
		
	}

	

}
