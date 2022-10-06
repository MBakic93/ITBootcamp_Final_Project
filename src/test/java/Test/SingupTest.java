package Test;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SingupTest extends BaseTest{
    Faker faker=new Faker();
    @Test (priority = 1)
    public void VisitsTheSignupPageTest(){
        homePage.openSignUpPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedUrlPart= "/signup";
        String actualResult= signupPage.getDriver().getCurrentUrl();                   //dohvati trenutni URL
        Assert.assertTrue(actualResult.endsWith("/signup"));

    }

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

    @Test (priority = 3)
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

        String actualUrl= driver.getCurrentUrl();                                      //getCurrentUrl() preuzimam trenutni URL
        String expectedUrlPart= "/signup";
        Assert.assertTrue(actualUrl.endsWith("/signup"));                               //Verifikacija da se u url-u stranice javlja /signup ruta

    }
    //Test #4: Signup
    //Podaci:
    //•	name: Ime i prezime polaznika
    //•	email template: ime.prezime@itbootcamp.rs
    //•	password: 12346
    //•	confirm password: 123456
    //assert:
    //•	Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
    @Test (priority = 4)
    public void SignupTest() throws InterruptedException {
        homePage.openSignUpPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String name= "Milica Bakic";
        String email= faker.internet().emailAddress();
        String password= "12346";
        String confirmPassword= "12346";

        signupPage.signUp(name,email,password,confirmPassword);
        Thread.sleep(3000);
        WebElement messageField= driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"));
        Thread.sleep(3000);
        String expectedMessage="IMPORTANT: Verify your account";
        String actualMessage=messageField.getText();
      //  etWebDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));   //PROVERITI KASNIJE 

        Thread.sleep(1000);
        Assert.assertTrue(actualMessage.contains(expectedMessage));


    }







}
