package Test;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private Faker faker= new Faker();

    @Test (priority = 1)
    public void visitsTheLoginPageTest(){
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String expectedResult= "https://vue-demo.daniel-avellaneda.com/login";
      String actualResult= loginPage.getDriver().getCurrentUrl();                   //dohvati trenutni URL
        Assert.assertTrue(actualResult.endsWith("/login"));

    }

    @Test (priority = 2)
    public void checksInputTypesTest()  {

        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String expectedResultEmail= "email";
        String actualResultEmail=loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualResultEmail,expectedResultEmail);   //verifikacija da polja za unos emaila za atribut type ima vrednost password

        String expectedResultPassword="password";
        String actualResultPassword=loginPage.getPasswordField().getAttribute("type"); ////verifikacija da polja za unos passworda za atribut type ima vrednost password
        Assert.assertEquals(actualResultPassword,expectedResultPassword);


    }

    @Test (priority= 3)
    public void userDoesNotExistTest(){
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        String emailRnd=faker.internet().emailAddress();                           //uzimam email iz fakera
        String passwordRnd = faker.internet().password();                         //uzimam password iz fakera
        loginPage.login(emailRnd,passwordRnd);                                   //prosledjujem metodi login vrednosti email i password iz fakera

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));       //dodajem wait-er

        WebElement userDoesNotExistField = driver.findElement(By.xpath(
                "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"));  //pronalazim polje sa porukom
        Assert.assertTrue(userDoesNotExistField.isDisplayed());                   //proveravam da li se polje sa porukom o gresci pojavljuje

        WebElement  userDoesNotExistMessageField= driver.findElement(By.xpath(
                "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));  //pronalazim polje sa porukom

        String expectedMessage= "User does not exists";                              //ocekivani tekst poruke
        String actualMessage= userDoesNotExistMessageField.getText();               //tekst poruke koji se stvarno prikazuje
        Assert.assertEquals(actualMessage,expectedMessage);                          //Verifikacija da li greska sadrzi poruku User does not exists

        String expectedUrlRoute="https://vue-demo.daniel-avellaneda.com/login";     //ocekivani URL stranice
        String actualUrlResult= loginPage.getDriver().getCurrentUrl();              //pomocu getCurrentUrl() metode citam stvarnu adresu stranice

        Assert.assertTrue(actualUrlResult.endsWith(expectedUrlRoute));              //pomocu metode endsWith() verifikujem da li se stvarni URL yavrsava sa /login


    }



}
