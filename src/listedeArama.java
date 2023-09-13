import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class listedeArama extends BaseDriver {
    @Test(dataProvider = "hastalar")
    public void listedeArama(String hasta){
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        MyFunc.Bekle(1);
        WebElement usernameBox = driver.findElement(By.id("username"));
        usernameBox.sendKeys("Admin");
        WebElement pswrdBox = driver.findElement(By.id("password"));
        pswrdBox.sendKeys("Admin123");
        WebElement location = driver.findElement(By.cssSelector("[value='6']"));
        location.click();
        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();
        MyFunc.Bekle(1);

        WebElement aramaBtn = driver.findElement(By.xpath("//*[@class='icon-search']"));
        aramaBtn.click();
        WebElement arama = driver.findElement(By.cssSelector("[id='patient-search']"));
        arama.sendKeys(hasta);
        MyFunc.Bekle(1);
        WebElement tiklama = driver.findElement(By.xpath("//*[text()='1000A8']"));
        tiklama.click();

    }

    @DataProvider
    Object[] hastalar()
    {
        Object[] hasta={"1000A8","500TR"};
        return hasta;
    }
}
