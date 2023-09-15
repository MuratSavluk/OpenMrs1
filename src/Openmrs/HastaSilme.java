package Openmrs;

import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class HastaSilme extends BaseDriver {
    @Test
    public void Test_Hasta_sil() {
        Element el = new Element();
        el.search.click();
        el.searchInput.sendKeys("Talat" + Keys.ENTER);
        el.kaytSil.click();
        el.inputYes.sendKeys("yes");
        el.btnSil.click();
    }
}
