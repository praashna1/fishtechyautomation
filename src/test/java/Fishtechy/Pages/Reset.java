package Fishtechy.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Reset {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public Reset(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void Password(){
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Forgot password?\"]")).click();

        WebElement email=wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"email_textfield\"]/android.widget.EditText")));
        email.click();
        email.sendKeys("prashna@shrigsolutions.com");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Send Code\"]")).click();

        //otp field
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"otp_textfield\"]/android.widget.EditText")).click();

        WebElement pass=wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"toggle_visibility\"])[1]")));
        pass.click();
        pass.sendKeys();

        WebElement confirmPass=wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.EditText[@resource-id=\"toggle_visibility\"])[2]")));
        confirmPass.click();
        confirmPass.sendKeys();
    }
}
