package Openmrs;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Element {
    public Element() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "i[class='icon-user']")
    public WebElement registerPatient;
    @FindBy(name = "givenName")
    public WebElement inputName;
    @FindBy(name = "familyName")
    public WebElement inputSurName;
    @FindBy(id = "next-button")
    public WebElement nextBtn;
    @FindBy(id = "gender-field")
    public WebElement gender;
    @FindBy(name = "birthdateDay")
    public WebElement day;
    @FindBy(name = "birthdateMonth")
    public WebElement month;
    @FindBy(name = "birthdateYear")
    public WebElement year;
    @FindBy(css = "input[id='address1']")
    public WebElement address1;
    @FindBy(id = "address2")
    public WebElement address2;
    @FindBy(id = "cityVillage")
    public WebElement city;
    @FindBy(id = "stateProvince")
    public WebElement state;
    @FindBy(id = "country")
    public WebElement country;
    @FindBy(id = "postalCode")
    public WebElement postCode;
    @FindBy(name = "phoneNumber")
    public WebElement phonnumber;
    @FindBy(css = "select[id='relationship_type']")
    public WebElement relationship;
    @FindBy(css = "[placeholder='Person Name']")
    public WebElement personName;
    @FindBy(css = "input[id='submit']")
    public WebElement confirm;
}
