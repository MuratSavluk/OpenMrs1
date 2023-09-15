package Utility;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static final org.apache.logging.log4j.Logger logger4j = LogManager.getLogger();

    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void baslangicIsleri(){
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        driver = new EdgeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        // elmantlari arama icin 20 saniye bekliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        loginTest();
    }
    @AfterClass
    public void bitisIslemleri(){
        MyFunc.Wait(5);
        driver.quit();

    }
    public void loginTest(){
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        WebElement inputEmail = driver.findElement(By.id("username"));
        inputEmail.sendKeys("admin");
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("Admin123");
        WebElement btn = driver.findElement(By.xpath("//li[text()='Inpatient Ward']"));
        btn.click();
        WebElement logBtn = driver.findElement(By.xpath("(//div[@id='content']//p//input)[3]"));
        logBtn.click();
    }

    @BeforeMethod
    public void beforeMetod(){
        logger4j.info("test metodu baslatildi");
        logger4j.warn("wating mesaji test baslatildi");
    }

    @AfterMethod
    public void afterMethod(ITestResult sonuc){
        logger4j.info(sonuc.getTestName() );
    }
}
