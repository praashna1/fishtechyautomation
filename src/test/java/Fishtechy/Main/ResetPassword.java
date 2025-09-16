package Fishtechy.Main;

import Fishtechy.Basee.Capability;
import Fishtechy.Pages.Reset;
import org.testng.annotations.Test;


public class ResetPassword extends Capability {

    @Test
    public void RePassword(){
        Reset reset=new Reset(driver);
        reset.Password();
    }
}
