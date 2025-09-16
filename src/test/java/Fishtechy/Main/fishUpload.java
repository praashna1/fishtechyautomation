package Fishtechy.Main;

import Fishtechy.Basee.Capability;
import Fishtechy.Pages.FishMeasure;
import org.testng.annotations.Test;

public class fishUpload extends Capability {

    @Test
    public void Fish (){
        FishMeasure fishMeasure=new FishMeasure(driver);
        fishMeasure.Measure();
    }
}
