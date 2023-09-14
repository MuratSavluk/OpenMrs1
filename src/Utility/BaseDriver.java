package Utility;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {


    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void baslangicIslemleri() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void login() {

        driver.get("https://openmrs.org/");

                WebElement demoButton = driver.findElement(By.xpath("(//*[@href='https://openmrs.org/demo/'])[2]"));
                        demoButton.click();


        WebElement mrs2Button = driver.findElement(By.xpath("(//span[@class='elementor-button-text'])[2]"));
        mrs2Button.click();

        MyFunc.bekle(2);
        WebElement mrs2DemoButton = driver.findElement(By.xpath("(//span[@class='elementor-button-text'])[4]"));
        mrs2DemoButton.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
                WebElement name = driver.findElement(By.id("username"));
        name.sendKeys("Admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        MyFunc.bekle(2);
        WebElement location = driver.findElement(By.id("Inpatient Ward"));
        location.click();

        WebElement login = driver.findElement(By.id("loginButton"));
        login.click();

        Assert.assertTrue(driver.getCurrentUrl().equals("https://demo.openmrs.org/openmrs/referenceapplication/home.page"),"yanlış kullanıcı ");

        }

    @AfterClass
    public void bitisIslemleri() {
        MyFunc.bekle(5);
        driver.quit();
    }


}