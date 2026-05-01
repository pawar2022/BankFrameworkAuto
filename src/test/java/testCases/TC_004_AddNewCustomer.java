package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AddNewCustomer;
import pageObjects.DashboardA;
import testBase.BaseClass;

@Listeners(utilities.ExtentListener.class)
public class TC_004_AddNewCustomer extends BaseClass {
	@Test
	public void addnewcustomer() {
		
		logger.info("Test case is started ");
		
		DashboardA ds = new DashboardA (driver);
		
		ds.clickonnwacc();
	
		
	AddNewCustomer ac  = new AddNewCustomer(driver);
	
	ac.setcusname("Pavan");
	ac.selectGender("female");
	ac.setDOB("15-o6-1996");
	ac.setadd("Nanded");
	ac.setcty("nanded");
	ac.setstate("MH");
	ac.setpin("432565");
	ac.setphn("9685741452");
	ac.seteid("abc@gmail.com");
	ac.clicksbbtn();

		
		
	}
	
	
	
	

}
