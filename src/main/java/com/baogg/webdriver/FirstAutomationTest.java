package com.baogg.webdriver;

//Info: When you write your code IntelliJ automatically adds required classes
//Also you can select and add required classes by pressing ALT+Enter then select related class

import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
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



        //ChromeOptions profile = new ChromeOptions();
        //profile.addAdditionalPreference("general.useragent.override", "my_selenium_browser");
        //profile.setBinary("/usr/bin/google-chrome");
        //profile.setPreference("general.useragent.override","my_selenium_browser");
        //profile.addArgument("--user-agent=" + "my_selenium_browser");
        //profile.addArguments();


        //System.setProperty("webdriver.chrome.driver", "/home/bob/IdeaProjects/selenium-tutorial/out/artifacts/selenium_tutorial_jar/chromedriver");
        /**
         * Download chrome drive from http://chromedriver.storage.googleapis.com/index.html
         * then execute java -jar ./selenium-tutorial.jar -Dwebdriver.chrome.driver=./chromedriver
         */
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        //options.AddArgument("--start-maximized");
        //chromeOptions.AddExcludedArgument("ignore-certificate-errors");
        options.addArguments("--user-agent=my_selenium_browser");
        //capabilities.setCapability("chrome.binary", "/home/bob/IdeaProjects/selenium-tutorial/out/artifacts/selenium_tutorial_jar/chromedriver");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);



        //driver = new FirefoxDriver(profile); //FirefoxDriver


        String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
        System.out.println("Browser name : " + s);

        baseUrl = "https://123.207.122.202:3002"; //192.168.199.247
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testReferralSmartASender() throws Exception {
        driver.get(baseUrl + "/");
        //JavascriptExecutor js = ((JavascriptExecutor) driver);
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


        /*((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findDynamicElement(By.xpath("(//a[contains(text(),'Refer Now')])[2]")));
        */
        Thread.sleep(10000);

        findDynamicElement(By.xpath("(//a[contains(text(),'Refer Now')])[1]")).click();
        findVisibleElement(By.id("email")).clear();
        findVisibleElement(By.id("email")).sendKeys("22376415@qq.com");
        driver.findElement(By.id("pwd")).clear();
        findVisibleElement(By.id("pwd")).sendKeys("123456");
        findDynamicElement(By.id("btnLogin")).click();
        // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
        findDynamicElement(By.xpath("//li[@ui-sref=\"app-rs.profile.newrefer\"]")).click();
        // ERROR: Caught exception [Error: Dom locators are not implemented yet!]


        findVisibleElement(By.xpath("//input[@ng-model='theReferal.customerEmail']")).clear();
        driver.findElement(By.xpath("//input[@ng-model='theReferal.customerEmail']")).sendKeys("beimuaihui@gmail.com");
        findVisibleElement(By.xpath("//input[@ng-model='theReferal.customerName']")).clear();
        driver.findElement(By.xpath("//input[@ng-model='theReferal.customerName']")).sendKeys("Beimu Bob");
        findVisibleElement(By.xpath("//input[@ng-model='theReferal.customerPhone']")).sendKeys("0412345678");
        //input[@ng-model="theReferal.customerPhone"]
        findDynamicElement(By.xpath("//div[contains(@class, 'btn-next')]")).click();
        findDynamicElement(By.xpath("//div[@ng-model='theReferal.rePartner.selected']//span[@ng-click='$select.activate()']")).click();
        findVisibleElement(By.xpath("//div[@ng-model='theReferal.rePartner.selected']//input")).sendKeys("frimann2test@gmail.com");
        findVisibleElement(By.xpath("//input[@ng-model='theReferal.newReceiverCompany']")).click();
        findVisibleElement(By.xpath("//input[@ng-model='theReferal.newReceiverName']")).sendKeys("Test Bob");
        findVisibleElement(By.xpath("//input[@ng-model='theReferal.newReceiverPhone']")).sendKeys("0412987654");
        findVisibleElement(By.xpath("//input[@ng-model='theReferal.newReceiverCompany']")).sendKeys("Abacus");

        findDynamicElement(By.xpath("//div[text()='Refer']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@ng-model='isAgree']")).click();
        findDynamicElement(By.xpath("//button[@ng-disabled='!isAgree']")).click();

        //driver.findElement(By.xpath("//button[2]")).click();
        findDynamicElement(By.cssSelector("button.confirm"),10000).click();
        waitSweetAlertHide();
        Thread.sleep(5000);



        findDynamicElement(By.xpath("//li[@ui-sref='app-rs.profile.info']"),10).click();
        findDynamicElement(By.xpath("//button[@ng-click='logout()']"),10).click();
/*

    }


    @Test
    public void testReferralSmartBReceiver() throws Exception {*/
        Thread.sleep(5000);
        //driver.get(baseUrl + "/1/#/rs/login");
        //driver.navigate().to(baseUrl + "/1/#/rs/login");
        findVisibleElement(By.id("email")).clear();
        findVisibleElement(By.id("email")).sendKeys("frimann2test@gmail.com");
        driver.findElement(By.id("pwd")).clear();
        findVisibleElement(By.id("pwd")).sendKeys("123456");
        findDynamicElement(By.id("btnLogin")).click();

        /*Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

        findDynamicElement(By.xpath("//table[@id=\"receiverDashboard\"]/tbody/tr[1]"),10000).click();


        /*Thread.sleep(5000);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#block_status_Contacted_Client > div.rs-timeline-content > div.rs-subject")));*/

        findDynamicElement(By.cssSelector("#block_status_Contacted_Client > div.rs-timeline-content > div.rs-subject"),10000).click();
        waitSweetAlertShow();

        findVisibleElement(By.cssSelector(".sweet-alert > fieldset > input[type='text']")).clear();
        findVisibleElement(By.cssSelector(".sweet-alert > fieldset > input[type='text']")).sendKeys("I have contacted client at yesterday");

        findDynamicElement(By.cssSelector("button.confirm"),10000).click();
        waitSweetAlertHide();

        findDynamicElement(By.cssSelector("#block_status_Appointment_Made_or_Lead_Closed > div.rs-timeline-content > div.rs-subject > p.smwidth.ng-binding"),10000).click();
        waitSweetAlertShow();
        findDynamicElement(By.cssSelector(".sweet-alert button.confirm"),10000).click();
        waitSweetAlertHide();


        findDynamicElement(By.cssSelector("#block_status_Appointment_Completed > div.rs-timeline-content > div.rs-subject"),10000).click();
        waitSweetAlertShow();
        findDynamicElement(By.cssSelector("button.confirm"),10000).click();
        waitSweetAlertHide();


        findDynamicElement(By.cssSelector("#block_status_Application_Received > div.rs-timeline-content > div.rs-subject"),10000).click();
        waitSweetAlertShow();
        findDynamicElement(By.cssSelector("button.confirm"),10000).click();
        waitSweetAlertHide();

        //Thread.sleep(3000);
        findDynamicElement(By.cssSelector("#block_status_Application_Submitted > div.rs-timeline-content > div.rs-subject"),10000).click();
        waitSweetAlertShow();
        findDynamicElement(By.cssSelector("button.confirm"),10000).click();
        waitSweetAlertHide();

        findDynamicElement(By.cssSelector("#block_status_Application_Conditional_Approval > div.rs-timeline-content > div.rs-subject"),10000).click();
        waitSweetAlertShow();
        findDynamicElement(By.cssSelector("button.confirm"),10000).click();
        waitSweetAlertHide();

        findDynamicElement(By.cssSelector("#block_status_Valuation > div.rs-timeline-content > div.rs-subject"),10000).click();
        waitSweetAlertShow();
        findDynamicElement(By.cssSelector("button.confirm"),10000).click();
        waitSweetAlertHide();


        findDynamicElement(By.cssSelector("#block_status_Application_Formal_Approval > div.rs-timeline-content > div.rs-subject > p.smwidth.ng-binding"),10000).click();

        waitSweetAlertShow();
        findDynamicElement(By.cssSelector("button.confirm"),10000).click();
        waitSweetAlertHide();


        findDynamicElement(By.cssSelector("#block_status_Settlement_Booked > div.rs-timeline-content > div.rs-subject"),10000).click();
        waitSweetAlertShow();
        findDynamicElement(By.cssSelector("button.confirm"),10000).click();
        waitSweetAlertHide();

        findDynamicElement(By.cssSelector("#block_status_Settlement > div.rs-timeline-content > div.rs-subject > p.smwidth.ng-binding"),10000).click();
        waitSweetAlertShow();
        findDynamicElement(By.cssSelector("button.confirm"),10000).click();
        waitSweetAlertHide();



        findDynamicElement(By.xpath("//*[@id=\"block_status_Settlement\"]/div[2]/div[2]/button[7]")).click();
        findDynamicElement(By.xpath("//button[@type='submit']"),10000).click();
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("123456789");
        driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("100000");
        findDynamicElement(By.xpath("//div[@type='submit']"),10000).click();
        findDynamicElement(By.xpath("(//div[@type='submit'])[2]"),10000).click();
        findDynamicElement(By.cssSelector("button.confirm"),10000).click();

        Thread.sleep(10000);  // Let the user actually see something!
        driver.quit();
    }


    public void waitSweetAlertHide() throws InterruptedException {
        if(false) {
            Thread.sleep(500);
            By loadingImage = By.cssSelector(".sweet-overlay");

            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));
            Thread.sleep(500);
        }
    }

    public void waitSweetAlertShow() throws InterruptedException {
        if(false) {
            Thread.sleep(500);
            By loadingImage = By.cssSelector(".sweet-overlay");

            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.visibilityOfElementLocated(loadingImage));
            Thread.sleep(500);
        }
    }


    public WebElement findDynamicElement(By by, int timeOut) throws InterruptedException {
        Thread.sleep(1000);
        return (new WebDriverWait(driver,timeOut,1000))
                .until(ExpectedConditions.elementToBeClickable(by));
    }


    public WebElement findDynamicElement(By by) throws InterruptedException {
        return this.findDynamicElement(by,10);
    }


    public WebElement findVisibleElement(By by) throws InterruptedException {

        WebElement ele =  (new WebDriverWait(driver,20,1500))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        Thread.sleep(1600);
        return ele;

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