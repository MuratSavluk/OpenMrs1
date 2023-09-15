package Openmrs;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HastaKayt extends BaseDriver {

    @Test
    public void Test_Hasta_Kayt() {
        Element el = new Element();
        el.registerPatient.click();
        el.inputName.sendKeys("Talat");
        el.inputSurName.sendKeys("Ahmet");
        el.nextBtn.click();
        Select menu = new Select(el.gender);
        menu.selectByValue("M");
        el.nextBtn.click();
        el.day.sendKeys("1");
        Select menuMonth = new Select(el.month);
        menuMonth.selectByValue("2");
        el.year.sendKeys("1990");
        el.nextBtn.click();
        el.confirm.click();
    }
}
