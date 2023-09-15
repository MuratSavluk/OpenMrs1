package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {
    public WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIsleri(String browserTipi) {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        switch (browserTipi.toLowerCase()){
            case "edge":
                driver = new EdgeDriver();break;
            case "safari":
                driver = new SafariDriver();break;
            case "firefox":
                driver = new FirefoxDriver(); break;
            default: driver = new ChromeDriver();
        }

        //driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        // elmantlari arama icin 20 saniye bekliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginTest();
    }

    @AfterClass
    public void bitisIslemleri() {
        MyFunc.Wait(5);
        driver.quit();

    }

    public void loginTest() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        WebElement inputEmail = driver.findElement(By.id("username"));
        inputEmail.sendKeys("admin");
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("Admin123");
        WebElement btn = driver.findElement(By.xpath("//li[text()='Inpatient Ward']"));
        btn.click();
        WebElement logBtn = driver.findElement(By.className("btn confirm"));
        logBtn.click();
    }
}
