import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class saatDilimiHatasi extends BaseDriver {
    @Test
    public void saatDilimihata(){
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

        WebElement randevu = driver.findElement(By.xpath("//*[@id='appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension']"));
        randevu.click();
        WebElement rndvYonetme = driver.findElement(By.xpath("//*[@id='appointmentschedulingui-manageAppointments-app']"));
        rndvYonetme.click();
        WebElement aramaBtn = driver.findElement(By.xpath("//input[@id='patient-search']"));
        aramaBtn.sendKeys("100MPR");
        WebElement hasta = driver.findElement(By.xpath("//*[text()='100MPR']"));
        hasta.click();
        
    }
}
