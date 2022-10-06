package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SingupTest extends BaseTest{

    //Test #1: Visits the signup page
    //assert:
    //•	Verifikovati da se u url-u stranice javlja /signup ruta
    @Test
    public void VisitsTheSignupPageTest(){
        homePage.openSignUpPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedUrlPart= "/signup";
        String actualResult= signupPage.getDriver().getCurrentUrl();                   //dohvati trenutni URL
        Assert.assertTrue(actualResult.endsWith("/signup"));

    }

}
