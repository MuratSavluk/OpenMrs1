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
    public void baslangicIslemleri(String browserTipi){
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        switch (browserTipi.toLowerCase())
        {
            case "firefox" :
                driver = new FirefoxDriver();
                break;

            case "safari" :
                driver = new SafariDriver();
                break;

            case "edge" :
                driver = new EdgeDriver();
                break;

            default:
                driver = new ChromeDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    }

    public void login(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
                MyFunc.bekle(2);

        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("testng1@gmail.com");

        WebElement inputpassword = driver.findElement(By.id("input-password"));
        inputpassword.sendKeys("123qweasd");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));
    }

    @AfterClass
    public void bitisIslemleri(){
        MyFunc.bekle(5);
        driver.quit();
    }

}