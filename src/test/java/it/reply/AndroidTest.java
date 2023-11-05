package it.reply;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class AndroidTest {
    private AndroidDriver driver;
    private WebDriverWait waitDriver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Pixel 6 API 33");
        desiredCapabilities.setCapability("appPackage", "it.unimib.worldnews");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("appActivity", "it.unimib.worldnews.ui.welcom.WelcomeActivity");

        URL remoteUrl = new URL("http://0.0.0.0:4723");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    /**
     * The test verifies if an error message appears when inserting
     * only the password and pressing the login button.
     */
    @Test
    public void test1() {

        // It starts the app under test
        driver.activateApp("it.unimib.worldnews");

        // It waits until the app under test is opened (the timeout is 60 seconds and it is set at line 41)
        waitDriver.until(
                ExpectedConditions.presenceOfElementLocated(By.id("it.unimib.worldnews:id/button_login")));

        // It finds the input field with the id "text_input_edit_text_password"
        WebElement password = driver.findElement(By.id("it.unimib.worldnews:id/text_input_edit_text_password"));

        // It writes in the input field associated with the password
        password.sendKeys("12345678");

        // It finds the button with the id "button_login"
        WebElement buttonLogin = driver.findElement(By.id("it.unimib.worldnews:id/button_login"));

        // It clicks the login button
        buttonLogin.click();

        // Test if the error message appears, and it is "Insert a valid email address"
        WebElement emailErrorMessage = driver.findElement(By.id("it.unimib.worldnews:id/textinput_error"));
        Assert.assertEquals("Insert a valid email address", emailErrorMessage.getText());

        // It clears the text inserted in the input field associated with the password
        password.clear();
    }

    /**
     * The test verifies if an error message appears when inserting
     * only the email address and pressing the login button.
     */
    @Test
    public void test2() {

        // It starts the app under test
        driver.activateApp("it.unimib.worldnews");

        // It waits until the app under test is opened (the timeout is 60 seconds and it is set at line 41)
        waitDriver.until(
                ExpectedConditions.presenceOfElementLocated(By.id("it.unimib.worldnews:id/button_login")));

        // It finds the input field with the id "text_input_edit_text_email"
        WebElement email = driver.findElement(By.id("it.unimib.worldnews:id/text_input_edit_text_email"));

        // It writes in the input field associated with the email
        email.sendKeys("davide.ginelli@unimib.it");

        // It finds the button with the id "button_login"
        WebElement buttonLogin = driver.findElement(By.id("it.unimib.worldnews:id/button_login"));

        // It clicks the login button
        buttonLogin.click();

        // Test if the error message appears, and it is "Password cannot be empty"
        WebElement emailErrorMessage = driver.findElement(By.id("it.unimib.worldnews:id/textinput_error"));
        Assert.assertEquals("Password cannot be empty", emailErrorMessage.getText());

        // It clears the text inserted in the input field associated with the email
        email.clear();
    }

    /**
     * The test verifies if the Snackbar with the error message appears when
     * the email and password are empty.
     */
    @Test
    public void test3() {

        // It starts the app under test
        driver.activateApp("it.unimib.worldnews");

        // It waits until the app under test is opened (the timeout is 60 seconds and it is set at line 41)
        waitDriver.until(
                ExpectedConditions.presenceOfElementLocated(By.id("it.unimib.worldnews:id/button_login")));

        // It finds the button with the id "button_login"
        WebElement buttonLogin = driver.findElement(By.id("it.unimib.worldnews:id/button_login"));

        // It clicks the login button
        buttonLogin.click();

        FluentWait<WebDriver> wait = new WebDriverWait(
                driver, Duration.of(5, ChronoUnit.SECONDS)).ignoring(NoSuchElementException.class);

        // It tests if the Snackbar with the text "Check the data you inserted" is visible
        wait.until(visibilityOfElementLocated(By.xpath("//*[@text='Check the data you inserted']")));
    }

    /**
     * The test verifies if the application shows a new screen that has the button with id "button_next"
     * when the email and password are correct and the login button is pressed.è
     */
    @Test
    public void test4() {

        // It starts the app under test
        driver.activateApp("it.unimib.worldnews");

        // It waits until the app under test is opened (the timeout is 60 seconds and it is set at line 41)
        waitDriver.until(
                ExpectedConditions.presenceOfElementLocated(By.id("it.unimib.worldnews:id/button_login")));

        // It finds the input field with the id "text_input_edit_text_email"
        WebElement email = driver.findElement(By.id("it.unimib.worldnews:id/text_input_edit_text_email"));

        // It writes in the input field associated with the email
        email.sendKeys("davide.ginelli@unimib.it");

        // It finds the input field with the id "text_input_edit_text_password"
        WebElement password = driver.findElement(By.id("it.unimib.worldnews:id/text_input_edit_text_password"));

        // It writes in the input field associated with the passowrd
        password.sendKeys("12345678");

        // It finds the button with the id "button_login"
        WebElement buttonLogin = driver.findElement(By.id("it.unimib.worldnews:id/button_login"));

        // It clicks the login button
        buttonLogin.click();

        // It tests if the new screen with the button that has id "button_next" is visible
        waitDriver.until(
                ExpectedConditions.presenceOfElementLocated(By.id("it.unimib.worldnews:id/button_next")));
    }
}
