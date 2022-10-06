package Test;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitiesTest extends BaseTest{
    Faker faker=new Faker();
    @Test(priority = 1)
    public void VisitsTheAdminCitiesAndListCitiesTest() throws InterruptedException {
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String adminEmail= "admin@admin.com";
        String password="12345";
        loginPage.login(adminEmail,password);                   //logovanje pomocu metode iz login page
        Thread.sleep(2000);
        homePage.getAdminBtn().click();                         //klik na AdminBTN iz home page
        Thread.sleep(2000);
        adminCitiesPage.getCitiesBtn().click();                 //klik na BTN cities iz AdminCities Page
        Thread.sleep(1000);                                 //bez threada nece da radi
        String actualUrl= driver.getCurrentUrl();               //citam trenutni url
        String expectedUrlPart= "/admin/cities";                //ocekivani deo url-a

        Assert.assertTrue(actualUrl.contains(expectedUrlPart));     //Verifikacija da se u url-u stranice javlja /admin/cities ruta
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed());   //	Verifikacija da li postoji logut dugmeta iz home page-a

    }
//Test #2: Create new city
//Podaci: random grad korisćenjem faker library-ja
//assert:
//•	Verifikovati da poruka sadrzi tekst Saved successfully
    @Test
    public void createNewCityTest() throws InterruptedException {
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String adminEmail= "admin@admin.com";
        String password="12345";
        loginPage.login(adminEmail,password);                   //logovanje pomocu metode iz login page
        Thread.sleep(2000);
        homePage.getAdminBtn().click();                         //klik na AdminBTN iz home page
        Thread.sleep(2000);
        adminCitiesPage.getCitiesBtn().click();                 //klik na BTN cities iz AdminCities Page
        Thread.sleep(1000);                                 //bez threada nece da radi
        String cityName= faker.address().cityName();
       adminCitiesPage.createNewCity(cityName);

       //WebElement messageField= driver.findElement(By.);

    }
}
