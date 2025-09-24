package Fishtechy.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FishMeasure {
        private AppiumDriver driver;
        private WebDriverWait wait;

        public FishMeasure(AppiumDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void Measure(){
            //in homepage and selecting camera to upload the fish
            driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View[1]/android.widget.ImageView")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Camera\"]"))).click();

            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Continue"))).click();
            //this behaves so stupid failing sometime or  running sometime
            handlePermission();

            //this is auto measure off but due to login code resume can't start from here
            //wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Auto Measure"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@resource-id=\"measurement_tutorial_popup_close_button_button\"]"))).click();


//            wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]"))).click();


//            WebElement guide=wait.until(ExpectedConditions.presenceOfElementLocated(
//                    AppiumBy.accessibilityId("Continue")));
//            guide.click();
//
//            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_all_button"))).click();
//
//            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("measurement_tutorial_popup_close_button_button"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"00:04\"])[2]"))).click();
            //vdo select

            //Next
            //wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("close_gallery_button"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Measure Now"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Export Video"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Measure Fish"))).click();

            //wait few second as it takes time
            driver.findElement(AppiumBy.accessibilityId("Next")).click();
            //if all perfect contest is fine without selecting
            //then post will be redirected to your page and then setting logout login loop

        }

    public void handlePermission(){
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
        }}
    }
