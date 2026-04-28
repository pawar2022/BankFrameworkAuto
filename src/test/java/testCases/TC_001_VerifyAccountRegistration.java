package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.Registration_Page;
import testBase.BaseClass;



@Listeners(utilities.ExtentListener.class)
public class TC_001_VerifyAccountRegistration extends BaseClass {

	@Test
	public void verifyaccountregistration() {
		
		logger.info("Test case is started");
		HomePage hp = new HomePage(driver);
		hp.clickRegisterButton();
		
		Registration_Page rp = new Registration_Page(driver);
		rp.sendfname(randomstring().toUpperCase());
		rp.sendlname(randomstring().toUpperCase());
		rp.sendaddname("svm socity");
		rp.sendcty("Pune");
		rp.sendstate("Goa");
		rp.sendzip("431526");
		rp.sendphn("8884554585");
		rp.sendcssn("789456");
		rp.senduname("rao");
		
		String psd = randomalphanumeric();
		
		rp.sendpwd(psd);
		rp.sendcnf(psd);
		rp.clickrsbtn();
		
		

		String msg = rp.getSuccessMessage();

		Assert.assertTrue(
		    msg.contains("Your account was created successfully"),
		    "Registration Failed"
		);
	
 
	}
}
