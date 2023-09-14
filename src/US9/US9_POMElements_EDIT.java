package US9;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class US9_POMElements_EDIT {
    public US9_POMElements_EDIT() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(xpath = "//*[contains(@id,'registrationapp')]")
    public WebElement registerAPatientBtn;
    @FindBy(css = "[name='givenName']")
    public WebElement given;
    @FindBy(css = "[id='next-button']")
    public WebElement nextBtn;
    @FindBy(css = "[id='relationship_type']")
    public WebElement relationshipType;
    @FindBy(css = "[placeholder='Person Name']")
    public WebElement personName;
    @FindBy(css = "[id='submit']")
    public WebElement confirm;

    @FindBy(css = "[id='birthdateMonth-field']")
    public WebElement birthDay;
    @FindBy(css = "[id='birthdateYear-field']")
    public WebElement birthYear;

    //birleştirme kısmı
    @FindBy(css = "[class='logo']")
    public WebElement logo;/////buraya 100 sayısıı yazdır sonra entera bastır.
    @FindBy(css = "[id='coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension']")
    public WebElement dataManagement;///data management
    @FindBy(css = "[id='coreapps-mergePatientsHomepageLink-app']")
    public WebElement mergePatientElectronic;///merge managment
    @FindBy(css = "input[id='patient1-text']")
    public WebElement patient1;///hasta 1
    @FindBy(css = "input[id='patient2-text']")
    public WebElement patient2;///hasta 2
    @FindBy(css = "[id='patient-search-clear-button']")
    public WebElement closeBtn;///rastgele continue aktiff olsun ddiye 🙂
    @FindBy(css = "[id='confirm-button']")
    public WebElement continueBtn;///hasta 2
    @FindBy(css = "[class='messages-container'] h1")
    public WebElement message;///Merging cannot be undone! yazısı geçiyor mu kontrol ettir
    @FindBy(css = "[id='first-patient']")
    public WebElement clickPatient1;
    @FindBy(css = "[id='second-patient']")
    public WebElement clickPatient2;
    @FindBy(css = "[id='confirm-button']")
    public WebElement yesContinueBn;
    @FindBy(css = "[id='coreapps-showContactInfo']")

    public WebElement showContactInfo;

    @FindBy(css = "[class='float-sm-right'] span")
    public List<WebElement> ids;//burdaki ikisi başta gönderilenle aynnı mı bi bak


}