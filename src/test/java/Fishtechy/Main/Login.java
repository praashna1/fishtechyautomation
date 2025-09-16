package Fishtechy.Main;

import Fishtechy.Basee.Capability;
import Fishtechy.Pages.LoginCode;
import org.testng.annotations.Test;

public class Login extends Capability {

    @Test
    public void loginShouldSucceed() throws InterruptedException {
        LoginCode loginPage = new LoginCode(driver);
        loginPage.enterEmail("testershrig+2@gmail.com", "TestTest");
        loginPage.handlePermission();
        loginPage.CameraGuide();
        
    }
}
