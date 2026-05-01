package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends BasePage {

	public Dashboard(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(xpath="//a[text()='Open New Account']")
	WebElement opnacc;
	
	@FindBy(xpath="//a[text()='Accounts Overview']")
	WebElement accovw;
	
	@FindBy(xpath="//a[text()='Transfer Funds']")
	WebElement tsfds;
	
	public void clickonopenacc() {
		
		opnacc.click();
	}
	
     public void clickonaccovw() {
		
		accovw.click();
	}
	
     public void clickontsfds() {
	
	tsfds.click();
}


}
