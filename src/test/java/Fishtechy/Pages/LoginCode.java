package Fishtechy.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginCode {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public LoginCode(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email, String password) throws InterruptedException {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.Button[@content-desc='Login']")));
        loginBtn.click();

        WebElement continueWithEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.ImageView[@content-desc='Continue with Email']")));
        continueWithEmail.click();

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//android.widget.EditText)[2]")));
        emailField.click();
        Thread.sleep(2000);
        emailField.sendKeys(email);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//android.widget.EditText)[4]")));
        passwordField.click();
        Thread.sleep(2000);
        passwordField.sendKeys(password);

        WebElement finalLoginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.Button[@content-desc='Login']")));
        finalLoginBtn.click();
        Thread.sleep(2000);
    }

    public void handlePermission(){
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement allowButton = shortWait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")
            ));
            allowButton.click();
            System.out.println("Permission popup appeared and 'Allow' was clicked.");
        } catch (TimeoutException e) {
            System.out.println("No permission popup appeared.");
        }
    }
    public void CameraGuide(){
        try{
        WebElement camera=wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]")));
                camera.click();
            System.out.println("first step clicked");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
               wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath
                       ("//android.view.View[@content-desc=\"Measure fish directly from your saved photos or videos.\"]/android.view.View"))).click();
            System.out.println("second step clicked");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath
                            ("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]"))).click();
            System.out.println("long pressed camera");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Continue"))).click();
            System.out.println("clicked continue");

            for (int i = 0; i < 3; i++) {
                try {
                    WebElement allowBtn = wait.until(ExpectedConditions.elementToBeClickable(
                            AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")
                    ));
                    allowBtn.click();
                } catch (StaleElementReferenceException e) {
                    WebElement allowBtn = driver.findElement(
                            AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")
                    );
                    allowBtn.click();
                }    //three same permissions in a row so
            }   //trying this cause the code breakout after several run saying stale element reference exception

            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc=\"Turn on Auto-Measure to let the app measure your catch automatically.\"]/android.view.View"))).click();
            System.out.println("auto measure guide clicked");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Done"))).click();
            System.out.println("guide mode done clicked");
        //android.view.View[@content-desc="Done"]

        //wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("close_button"))).click();
           wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@resource-id=\"close_button\"]"))).click();
        } catch (TimeoutException e) {
            System.out.println("No guides were seen");
        }
    }
}
