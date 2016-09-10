package com.baogg.webdriver;

//Info: When you write your code IntelliJ automatically adds required classes
//Also you can select and add required classes by pressing ALT+Enter then select related class

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ONUR BASKIRT on 26.08.2015.
 */
public class FirstAutomationTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
            baseUrl = "https://123.207.122.202:3002/1/#/rs/login";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSelenium2() throws Exception {
        driver.get(baseUrl + "/1/#/rs/login");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("22376415@qq.com");
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
        driver.findElement(By.xpath("//li[@ui-sref=\"app-rs.profile.newrefer\"]")).click();
        // ERROR: Caught exception [Error: Dom locators are not implemented yet!]

        driver.findElement(By.xpath("//input[@ng-model='theReferal.customerEmail']")).clear();
        driver.findElement(By.xpath("//input[@ng-model='theReferal.customerEmail']")).sendKeys("beimuaihui@gmail.com");
        driver.findElement(By.xpath("//input[@ng-model='theReferal.customerName']")).clear();
        driver.findElement(By.xpath("//input[@ng-model='theReferal.customerName']")).sendKeys("Beimu Bob");
        driver.findElement(By.xpath("//input[@ng-model='theReferal.customerPhone']")).sendKeys("0412345678");
        //input[@ng-model="theReferal.customerPhone"]
        driver.findElement(By.xpath("//div[contains(@class, 'btn-next')]")).click();
        driver.findElement(By.xpath("//div[@ng-model='theReferal.rePartner.selected']//span[@ng-click='$select.activate()']")).click();
        driver.findElement(By.xpath("//div[@ng-model='theReferal.rePartner.selected']//input")).sendKeys("frimann2test@gmail.com");
        driver.findElement(By.xpath("//input[@ng-model='theReferal.newReceiverName']")).sendKeys("Test Bob");
        driver.findElement(By.xpath("//input[@ng-model='theReferal.newReceiverPhone']")).sendKeys("0412987654");


        driver.findElement(By.xpath("//div[text()='Refer']")).click();
        driver.findElement(By.xpath("//input[@ng-model='isAgree']")).click();
        driver.findElement(By.xpath("//button[@ng-disabled='!isAgree']")).click();
        //driver.findElement(By.xpath("//button[2]")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        driver.findElement(By.xpath("//li[@ui-sref='app-rs.profile.info']")).click();
        driver.findElement(By.xpath("//button[@ng-click='logout()']")).click();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
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
