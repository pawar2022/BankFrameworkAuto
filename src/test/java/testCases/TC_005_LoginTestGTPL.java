package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

@Listeners(utilities.ExtentListener.class)
public class TC_005_LoginTestGTPL extends BaseClass {

    @Test
    public void loginGTPL() {

        logger.info("Test case started");

        LoginPage lps = new LoginPage(driver);

        // Read from config.properties
        lps.setuid(prop.getProperty("usrid"));
        lps.setpasswd(prop.getProperty("pswd"));

        lps.clickloginbtn();

        // Validation
        String msg = lps.getSuccessMsg();

        Assert.assertTrue(
            msg.contains("Manager"),
            "Login failed"
        );

        logger.info("Login test passed");
    }
}