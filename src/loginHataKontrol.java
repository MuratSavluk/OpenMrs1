import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginHataKontrol extends BaseDriver{
    @Test(dataProvider = "usernames")
    public void hataKontrol(String kullaniciAdi,String password) {
        driver.get("https://openmrs.org/");
        WebElement demoBtn = driver.findElement(By.xpath("//a[text()='Demo']"));
        demoBtn.click();
        WebElement explr2demo = driver.findElement(By.xpath("//span[@class='elementor-button-text' and text()='Explore OpenMRS 2']"));
        explr2demo.click();
        MyFunc.Bekle(1);
        WebElement enter2demo = driver.findElement(By.xpath("//span[@class='elementor-button-text' and text()='Enter the OpenMRS 2 Demo']"));
        enter2demo.click();
        MyFunc.Bekle(2);

        WebElement usernameBox = driver.findElement(By.id("username"));
        usernameBox.sendKeys(kullaniciAdi);
        WebElement pswrdBox = driver.findElement(By.id("password"));
        pswrdBox.sendKeys(password);
        WebElement location = driver.findElement(By.cssSelector("[value='6']"));
        location.click();
        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();
    }

    @DataProvider
    Object[][] usernames()
    {
        Object[][] username={
                {" ","ali"},
                {"ahmed","0"},
                {"ken","barbie"},
                {"null","null"},
                {"ali","cabbar"},
                {"joe","biden"},
                {"Admin","Admin123"}
        };
        return username;
    }

}
