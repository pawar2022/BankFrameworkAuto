package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends BasePage{

	public Login_Page(WebDriver driver) {
		
		super(driver);
	
	}

	@FindBy(xpath="//input[@name=\"username\"]")
	WebElement usname;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement pwd;
	
	@FindBy(xpath="//input[@value=\"Log In\"]")
	WebElement btn;
	
	public void enterusname(String usrname) {
		usname.clear();
		usname.sendKeys(usrname);
	}
	
	public void enterpswd(String pswd) {
		pwd.clear();
		pwd.sendKeys(pswd);
	}
	public void clicklgnbtn() {
		btn.click();
	}
	
}
