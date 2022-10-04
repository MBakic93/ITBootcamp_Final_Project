package Test;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {




    @Test (priority = 1)
    public void visitsTheLoginPage(){
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String expectedResult= "https://vue-demo.daniel-avellaneda.com/login";
      String actualResult= loginPage.getDriver().getCurrentUrl();                   //dohvati trenutni URL
        Assert.assertTrue(actualResult.endsWith("/login"));

    }

    //•	Verifikovati da polje za unos lozinke za atribut type ima vrednost password

    @Test (priority = 2)
    public void checksInputTypes()  {

        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String expectedResultEmail= "email";
        String actualResultEmail=loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualResultEmail,expectedResultEmail);


        String expectedResultPassword="password";
        String actualResultPassword=loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualResultPassword,expectedResultPassword);


    }



}
