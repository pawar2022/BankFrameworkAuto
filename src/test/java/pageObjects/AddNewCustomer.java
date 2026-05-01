package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewCustomer extends BasePage{

	public AddNewCustomer(WebDriver driver) {
		
		super(driver);
		
	}

	@FindBy(xpath="//input[@onkeyup=\"validatecustomername();\"]")
	WebElement cusname;
	
	
	@FindBy(xpath="(//input[@name='rad1'])[2]")
	WebElement selectgender;
	
	@FindBy(xpath="//input[@id=\"dob\"]")
	WebElement DOB;
	
	@FindBy(xpath="//textarea[@name=\"addr\"]")
	WebElement add;
	
	@FindBy(xpath="//input[@name=\"city\"]")
	WebElement cty;
	
	@FindBy(xpath="//input[@name=\"state\"]")
	WebElement state;
	
	@FindBy(xpath="//input[@name=\"pinno\"]")
	WebElement pin;
	
	@FindBy(xpath="//input[@name=\"telephoneno\"]")
	WebElement tphn;
	
	@FindBy(xpath="//input[@name=\"emailid\"]")
	WebElement eid;
	
	@FindBy(xpath="//input[@name=\"sub\"]")
	WebElement subbtn;
	
	public void setcusname(String name) {
		cusname.sendKeys(name);
	}
	
	public void selectGender(String gender) {
	    if(gender.equalsIgnoreCase("male")) {
	        driver.findElement(By.xpath("(//input[@name='rad1'])[1]")).click();
	    } else {
	        driver.findElement(By.xpath("(//input[@name='rad1'])[2]")).click();
	    }
	}
	
	public void setDOB(String date) {
		DOB.sendKeys(date);
	}
	
	public void setadd(String ads) {
		add.sendKeys(ads);
	}
	
	public void setcty(String city) {
		cty.sendKeys(city);
	}
	
	public void setstate(String stt) {
		
		state.sendKeys(stt);
	}
	
	public void setpin(String pn) {
		
		pin.sendKeys(pn);
	}
	
	public void setphn(String phn) {
		
		tphn.sendKeys(phn);
	}
	
	public void seteid(String emid) {
		
		eid.sendKeys(emid);
	}
	
	public void clicksbbtn() {
		
		subbtn.click();
	}
	
	
}
