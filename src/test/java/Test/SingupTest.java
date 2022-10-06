package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SingupTest extends BaseTest{

    @Test (priority = 1)
    public void VisitsTheSignupPageTest(){
        homePage.openSignUpPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedUrlPart= "/signup";
        String actualResult= signupPage.getDriver().getCurrentUrl();                   //dohvati trenutni URL
        Assert.assertTrue(actualResult.endsWith("/signup"));

    }
    //Test #2: Checks input types
    //assert:
    //•	Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //•	Verifikovati da polje za unos lozinke za atribut type ima vrednost password
    //•	Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password
    @Test
    public void ChecksInputTypes(){
        homePage.openSignUpPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String expectedResultEmail= "email";
        String actualResultEmail=signupPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualResultEmail,expectedResultEmail);                                  //verifikacija da polja za unos emaila za atribut type ima vrednost password

        String expectedResultPassword="password";
        String actualResultPassword=signupPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualResultPassword,expectedResultPassword);                           //verifikacija da polja za unos passworda za atribut type ima vrednost password

        String expectedResultConfirmPassword="password";
        String actualResultConfirmPassword=signupPage.getConfirmPasswordField().getAttribute("type");
       Assert.assertTrue(actualResultConfirmPassword.contains(expectedResultConfirmPassword));        //verifikacija da polja za unos plozinke za potvrdu za atribut type ima vrednost password

    }

}
