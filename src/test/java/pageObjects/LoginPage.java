package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		
		super(driver);
		
	}
	

	@FindBy(xpath="//input[@name=\"uid\"]")
	WebElement uid;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement passwd;
	
	@FindBy(xpath="//input[@name=\"btnLogin\"]")
	WebElement loginbtn;
	
	
	
	
	public void setuid(String usrid) {
		
		uid.sendKeys(usrid);
		
	}
	
	public void setpasswd(String pswd) {
		
		passwd.sendKeys(pswd);
	}
	
	public void clickloginbtn() {
		
		loginbtn.click();
	}
	
	@FindBy(xpath="//marquee[contains(text(),\"Manager's Page\")]")
	WebElement successMsg;

	public String getSuccessMsg() {
	    return successMsg.getText();
	}
}
