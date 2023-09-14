package US9;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.List;


public class US9_EDIT extends BaseDriverParameter {


    @Test
    public void TC_0909() {
        US9_POMElements_EDIT elements = new US9_POMElements_EDIT();
        login();

        List<String> registerPatients= hastaOlustur(2);
        hastaBirlestir(registerPatients);
        dogrulamaYap(registerPatients);

    }
    public void hastaBirlestir(List<String> registerPatients ){
        US9_POMElements_EDIT elements = new US9_POMElements_EDIT();

        elements.logo.click();
        wait.until(ExpectedConditions.visibilityOf(elements.dataManagement));
        elements.dataManagement.click();
        wait.until(ExpectedConditions.visibilityOf(elements.mergePatientElectronic));
        elements.mergePatientElectronic.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.patient1));
        elements.patient1.click();
        elements.patient1.sendKeys(registerPatients.get(0) + Keys.TAB);
        elements.patient2.sendKeys(registerPatients.get(1));
        elements.closeBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continueBtn));
        elements.continueBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.clickPatient1));




    }
    public List<String> hastaOlustur(int sayi) {
        US9_POMElements_EDIT elements = new US9_POMElements_EDIT();
        List<String> registerPatients = new ArrayList<>();
        for (int i = 0; i < sayi; i++) {

            elements.logo.click();
            elements.registerAPatientBtn.click();
            Actions actions = new Actions(driver);
            wait.until(ExpectedConditions.elementToBeClickable(elements.given));

            actions.click(elements.given)
                    .sendKeys("Hasta").sendKeys(Keys.TAB)
                    .sendKeys("Team").sendKeys(Keys.TAB)
                    .sendKeys("selenium").sendKeys(Keys.ENTER)
                    .sendKeys(Keys.DOWN).sendKeys(Keys.ENTER)
                    .sendKeys("7").
                    build().perform();

            Select birthDay = new Select(elements.birthDay);
            birthDay.selectByIndex(2);

            actions.click(elements.birthYear) .
                    sendKeys("1907").sendKeys(Keys.TAB)
                    .sendKeys("istanbul").sendKeys(Keys.TAB)
                    .sendKeys("ANKARA").sendKeys(Keys.TAB)
                    .sendKeys("iSTANBUL").sendKeys(Keys.TAB)
                    .sendKeys("KADIKÖY").sendKeys(Keys.TAB)
                    .sendKeys("TURKİYE").sendKeys(Keys.TAB)
                    .sendKeys("34920").sendKeys(Keys.TAB)
                    .sendKeys("02127777777").sendKeys(Keys.TAB)
                    .build().perform();

            wait.until(ExpectedConditions.visibilityOf(elements.relationshipType));
            Select relationType = new Select(elements.relationshipType);
            relationType.selectByIndex(2);
            elements.personName.sendKeys("777");
            wait.until(ExpectedConditions.elementToBeClickable(elements.nextBtn));
            elements.nextBtn.click();
            elements.confirm.click();
            registerPatients.add(elements.ids.get(0).getText());

        }
        return registerPatients;
    }


    public void dogrulamaYap(List<String> registerPatients){
        US9_POMElements_EDIT elements = new US9_POMElements_EDIT();
        SoftAssert _softAssert = new SoftAssert();
        boolean messageControl = elements.message.getText().contains("Merging cannot be undone!");
        _softAssert.assertTrue(messageControl, "İstenen mesaj alınamadı");
        elements.clickPatient1.click();
        elements.yesContinueBn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.showContactInfo));

        List<String> patients = new ArrayList<>();
        for (WebElement e : elements.ids) {//list Webelement
            patients.add(e.getText());
        }
        int sayac=0;
        for (int i = 0; i <patients.size() ; i++) {
            for (int j = 0; j <registerPatients.size() ; j++) {
                if (patients.get(i).equals(registerPatients.get(j))){
                    sayac++;
                }
            }
        }


        boolean control = (sayac==patients.size());
        _softAssert.assertTrue(control, "Birleştirilen idler uyumsuzdur.");

        _softAssert.assertAll();



    }
}

