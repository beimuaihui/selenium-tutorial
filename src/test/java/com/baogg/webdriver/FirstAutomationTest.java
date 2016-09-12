package com.baogg.webdriver;

//Info: When you write your code IntelliJ automatically adds required classes
//Also you can select and add required classes by pressing ALT+Enter then select related class

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.MethodSorters;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ONUR BASKIRT on 26.08.2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FirstAutomationTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {

        /*
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        */

        driver = new FirefoxDriver();
        baseUrl = "https://localhost:3002/1/#/rs/login";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testReferralSmartASender() throws Exception {
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
        driver.findElement(By.xpath("//div[@ng-model='theReferal.rePartner.selected']//input")).sendKeys("ylb2016@126.com");
        driver.findElement(By.xpath("//input[@ng-model='theReferal.newReceiverName']")).sendKeys("Test Bob");
        driver.findElement(By.xpath("//input[@ng-model='theReferal.newReceiverPhone']")).sendKeys("0412987654");


        driver.findElement(By.xpath("//div[text()='Refer']")).click();
        driver.findElement(By.xpath("//input[@ng-model='isAgree']")).click();
        driver.findElement(By.xpath("//button[@ng-disabled='!isAgree']")).click();
        //driver.findElement(By.xpath("//button[2]")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        waitSweetAlert();



        driver.findElement(By.xpath("//li[@ui-sref='app-rs.profile.info']")).click();
        driver.findElement(By.xpath("//button[@ng-click='logout()']")).click();


    }


    @Test
    public void testReferralSmartBReceiver() throws Exception {

        driver.get(baseUrl + "/1/#/rs/login");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("frimann2test@gmail.com");
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();

        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id=\"receiverDashboard\"]/tbody/tr")));
        driver.findElement(By.xpath("//table[@id=\"receiverDashboard\"]/tbody/tr")).click();

        Thread.sleep(5000);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#block_status_Contacted_Client > div.rs-timeline-content > div.rs-subject")));

        driver.findElement(By.cssSelector("#block_status_Contacted_Client > div.rs-timeline-content > div.rs-subject")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();

        waitSweetAlert();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#block_status_Appointment_Made_or_Lead_Closed > div.rs-timeline-content > div.rs-subject > p.smwidth.ng-binding")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        waitSweetAlert();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#block_status_Appointment_Completed > div.rs-timeline-content > div.rs-subject")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        waitSweetAlert();
        Thread.sleep(5000);


        driver.findElement(By.cssSelector("#block_status_Application_Received > div.rs-timeline-content > div.rs-subject")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        waitSweetAlert();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#block_status_Application_Submitted > div.rs-timeline-content > div.rs-subject")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        waitSweetAlert();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#block_status_Application_Conditional_Approval > div.rs-timeline-content > div.rs-subject")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        waitSweetAlert();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#block_status_Valuation > div.rs-timeline-content > div.rs-subject")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        waitSweetAlert();
        Thread.sleep(5000);


        driver.findElement(By.cssSelector("#block_status_Application_Formal_Approval > div.rs-timeline-content > div.rs-subject > p.smwidth.ng-binding")).click();

        driver.findElement(By.cssSelector("button.confirm")).click();
        waitSweetAlert();
        Thread.sleep(5000);


        driver.findElement(By.cssSelector("#block_status_Settlement_Booked > div.rs-timeline-content > div.rs-subject")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        waitSweetAlert();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#block_status_Settlement > div.rs-timeline-content > div.rs-subject > p.smwidth.ng-binding")).click();
        driver.findElement(By.cssSelector("button.confirm")).click();
        waitSweetAlert();
    }

    public void waitSweetAlert() {

        By loadingImage = By.cssSelector(".sweet-overlay");

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));
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
