package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    @Test (priority = 2)
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

    //Test #3: Displays errors when user already exists
    //Podaci:
    //•	name: Test Test
    //•	email: admin@admin.com
    //•	password: 123654
    //•	confirm password: 123654
    //assert:
    //•	Verifikovati da greska sadrzi poruku E-mail already exists
    //•	Verifikovati da se u url-u stranice javlja /signup ruta

    @Test
    public void displaysErrorsWhenUserAlreadyExists(){
        homePage.openSignUpPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String name="Test Test";
        String email="admin@admin.com";
        String password= "123654";
        String confirmPassword="123654";
        signupPage.signUp(name,email,password,confirmPassword);             //metodi prosledjuem name,email, password i confirm pasword, i pokusavam signup


        WebElement mesageField= driver.findElement(By.xpath(
                "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div"));
        Assert.assertTrue(mesageField.isDisplayed());                                      //provera da li polje sa porukom postoji

        WebElement emailAlreadyExistMessage= driver.findElement(                        //pronalazim poruku
                By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));
        String expectedMessage="E-mail already exists";
        String actualMessage= emailAlreadyExistMessage.getText();                       //getText() preuzimam sadrzaj poruke
        Assert.assertTrue(actualMessage.contains(expectedMessage));                     //provera da li stvarna poruka sadrzi E-mail already exists

        String actualUrl= driver.getCurrentUrl();
        String expectedUrlPart= "/signup";
        Assert.assertTrue(actualUrl.endsWith("/signup"));

    }

}
