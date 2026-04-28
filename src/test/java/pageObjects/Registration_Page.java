package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration_Page extends BasePage{

	public Registration_Page(WebDriver driver) {
		
		super(driver);
	
	}
	
	@FindBy(id="customer.firstName")
	WebElement fname;
	
	@FindBy(id="customer.lastName")
	WebElement lname;
	
	@FindBy(id="customer.address.street")
	WebElement add;
	
	@FindBy(id="customer.address.city")
	WebElement cty;
	
	@FindBy(id="customer.address.state")
	WebElement state;
	
	@FindBy(id="customer.address.zipCode")
	WebElement zcd;
	
	@FindBy(id="customer.phoneNumber")
	WebElement ph;
	
	@FindBy(id="customer.ssn")
	WebElement ssn;
	
	@FindBy(id="customer.username")
	WebElement uname;
	
	@FindBy(id="customer.password")
	WebElement pswd;
	
	@FindBy(id="repeatedPassword")
	WebElement cnf;
	
	@FindBy(xpath="//input[@value=\"Register\"]")
	WebElement rster;
	
	@FindBy(xpath="//p[contains(text(),'Your account was created successfully')]")
	WebElement successMsg;
	
	
	
	public void sendfname(String name) {
		fname.sendKeys(name);
	}
	
	public void sendlname(String Lname) {
		lname.sendKeys(Lname);
	}
	
	public void sendaddname(String ads) {
		add.sendKeys(ads);
	}
	
	public void sendcty(String city) {
		cty.sendKeys(city);
	}
	
	public void sendstate(String stat) {
		state.sendKeys(stat);
	}
	
	public void sendzip(String zip) {
		zcd.sendKeys(zip);
	}
	
	public void sendphn(String phn) {
		ph.sendKeys(phn);
	}
	
	public void sendcssn(String cssn) {
		ssn.sendKeys(cssn);
	}
	
	public void senduname(String usname) {
		uname.sendKeys(usname);
	}
	
	public void sendpwd(String pwds) {
		pswd.sendKeys(pwds);
	}
	
	public void sendcnf(String conf) {
		cnf.sendKeys(conf);
	}
	
	public void clickrsbtn() {
		rster.click();
	}
	
	public String getSuccessMessage() {
	    return successMsg.getText();
	}

}
