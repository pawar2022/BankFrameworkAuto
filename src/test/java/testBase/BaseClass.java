package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties prop;

    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional("chrome") String br) throws IOException {

        logger = LogManager.getLogger(this.getClass());

        FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        prop = new Properties();
        prop.load(file);

        logger.info("Launching browser: " + br);

        switch (br.toLowerCase()) {

        case "chrome":
            driver = new ChromeDriver();
            break;

        case "edge":
            driver = new EdgeDriver();
            break;

        case "firefox":
            driver = new FirefoxDriver();
            break;

        default:
            throw new IllegalArgumentException("Invalid browser: " + br);
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String url = prop.getProperty("url");
        logger.info("Opening URL: " + url);

        driver.get(url);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    // 🔥 Screenshot Method
    public String captureScreenshot(String testName) {

        String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File target = new File(path);

            FileHandler.copy(source, target);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }

    // 🔹 Random Utilities
    public String randomstring() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomalphanumeric() {
        return RandomStringUtils.randomAlphabetic(5) + RandomStringUtils.randomNumeric(5);
    }
}