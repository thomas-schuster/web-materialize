package de.hspf.sysdev.web.tests.it;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author thomas.schuster
 */
public class LoginWebTestIT {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public LoginWebTestIT() {
    }

    @Before
    public void startSelenium() {
        // Create and configure a new instance of the chrome driver
        // Notice that the configuration is made by an external dependency (not selenium itself)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://google.de";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("http://localhost:50193/web-materialize");
        driver.findElement(By.id("navBar:loginLink")).click();
        driver.findElement(By.id("loginForm:username")).click();
        driver.findElement(By.id("loginForm:username")).clear();
        driver.findElement(By.id("loginForm:username")).sendKeys("thomas");
        driver.findElement(By.id("loginForm:password")).clear();
        driver.findElement(By.id("loginForm:password")).sendKeys("test");
        driver.findElement(By.id("loginForm:loginLink")).click();
        try {
            assertEquals("thomas DashBoard", driver.findElement(By.xpath("//form[@id='form']/div/div[2]/h1")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
