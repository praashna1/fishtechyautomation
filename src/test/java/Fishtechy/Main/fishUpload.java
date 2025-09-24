package Fishtechy.Main;

import Fishtechy.Basee.Capability;
import Fishtechy.Pages.FishMeasure;
import Fishtechy.Pages.LoginCode;
import org.testng.annotations.Test;

public class fishUpload extends Capability {

    @Test
    public void Fish () throws InterruptedException {
        LoginCode loginPage = new LoginCode(driver);
        loginPage.enterEmail("testershrig+2@gmail.com", "TestTest");
        loginPage.handlePermission();
        loginPage.CameraGuide();
        FishMeasure fishMeasure=new FishMeasure(driver);
        fishMeasure.Measure();
    }
}
