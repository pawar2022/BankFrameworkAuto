package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardA extends BasePage{

	public DashboardA(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement nwctmr;
	
	@FindBy(xpath="//a[text()='Edit Customer']")
	WebElement edcus;
	
	@FindBy(xpath="//a[text()='Delete Customer']")
	WebElement delcus;
	
	@FindBy(xpath="//a[text()='New Account']")
	WebElement nwacc;
	
	@FindBy(xpath="//a[text()='Edit Account']")
	WebElement edacc;
	
	public void clickonnwctmr() {
		
		nwctmr.click();
	}

public void clickedcus() {
		
		edcus.click();
	}
public void clickondelcus() {
	
	delcus.click();
}
public void clickonnwacc() {
	
	nwacc.click();
}

}
