package Test;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    LoginPage loginPage;
    HomePage homePage;
    SignupPage signupPage;
    AdminCitiesPage adminCitiesPage;
    MyProfilePage myProfilePage;





    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\x\\Desktop\\Chrome\\chromedriver.exe");//"C:\\Users\\Dusanic\\Desktop\\selenium\\chromedriver.exe");
        driver= new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();
        homePage= new HomePage(driver,webDriverWait);
        loginPage= new LoginPage(driver,webDriverWait);
        signupPage= new SignupPage(driver,webDriverWait);
        adminCitiesPage= new AdminCitiesPage(driver,webDriverWait);
        myProfilePage= new MyProfilePage(driver,webDriverWait);



    }

    @BeforeMethod
    public  void beforeMethod(){

        driver.get("https://vue-demo.daniel-avellaneda.com");

    }

    @Test
    public  void baseTest() throws InterruptedException {
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String actualResult= driver.getCurrentUrl();
        String expectedResult="https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(actualResult,expectedResult);

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }






}
