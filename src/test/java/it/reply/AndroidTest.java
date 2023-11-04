package it.reply;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Pixel 6 API 33");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://0.0.0.0:4723");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        String pageSource = driver.getPageSource();



        //System.out.println(pageSource);

        WebElement buttonLogin = driver.findElement(By.id("it.unimib.worldnews:id/button_login"));

        WebElement email = driver.findElement(By.id("it.unimib.worldnews:id/text_input_edit_text_email"));
        email.sendKeys("davide.ginelli@unimib.it");



        WebElement password = driver.findElement(By.id("it.unimib.worldnews:id/text_input_edit_text_password"));
        password.sendKeys("password");

        buttonLogin.click();

        Assert.assertEquals("Login", driver.findElement(By.id("it.unimib.worldnews:id/button_login")).getText());

        //String pageSource = driver.getPageSource();



        //System.out.println(pageSource);
    }

    @Test
    public void sampleTest() {

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}