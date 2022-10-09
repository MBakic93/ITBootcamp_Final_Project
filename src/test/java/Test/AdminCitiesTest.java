package Test;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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


        //NAPOMENA IYVUCI OVO U METODU KADA BUDES BILA FREE

    }
//Test #2: Create new city
//Podaci: random grad korisćenjem faker library-ja
//assert:
//•	Verifikovati da poruka sadrzi tekst Saved successfully
    @Test (priority=2)
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
        String cityName= "Mumbaj"; //faker.address().cityName();
       adminCitiesPage.createNewCity(cityName);
       WebElement messageField= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
       String actualMessage= messageField.getText();
       String expectedMessage="Saved successfully";
       Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //Test #3: Edit city
    //Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited (primer: Beograd – Beograd edited)
    //assert:
    //•	Verifikovati da poruka sadrzi tekst Saved successfully

    @Test (priority = 3)
    public void EditCityTest() throws InterruptedException {
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String adminEmail= "admin@admin.com";
        String password="12345";
        loginPage.login(adminEmail,password);                                                       //logovanje pomocu metode iz login page
        Thread.sleep(1000);
        homePage.getAdminBtn().click();                                                               //klik na AdminBTN iz home page
        Thread.sleep(1000);
        adminCitiesPage.getCitiesBtn().click();                                                       //klik na BTN cities iz AdminCities Page
        Thread.sleep(1000);                                                                     //bez threada nece da radi


        WebElement myCityNameEditBtn= driver.findElement(By.id("edit"));
        myCityNameEditBtn.click();
        WebElement cityNameEditField= driver.findElement(By.id("name"));
        cityNameEditField.click();
        cityNameEditField.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
       // Thread.sleep(1000);
        cityNameEditField.sendKeys("Mumbaj-edited");                                      //prosledjujem tekst za editovanje
        WebElement saveBtn= driver.findElement(By.xpath(
                "//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]"));

        saveBtn.click();
        Thread.sleep(2000);

        WebElement messageField= driver.findElement                                                  //pronalazim polje sa porukom
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        String expectedMessage="Saved successfully";
        String actualMesage= messageField.getText();

        Assert.assertTrue(actualMesage.contains(expectedMessage));

    }
    @Test (priority = 4)
    public void searchCityTest () throws InterruptedException {
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String adminEmail= "admin@admin.com";
        String password="12345";
        loginPage.login(adminEmail,password);                                                       //logovanje pomocu metode iz login page
        Thread.sleep(1000);
        homePage.getAdminBtn().click();                                                               //klik na AdminBTN iz home page
        Thread.sleep(1000);
        adminCitiesPage.getCitiesBtn().click();                                                       //klik na BTN cities iz AdminCities Page
        Thread.sleep(1000);                                                                     //bez threada nece da radi

       adminCitiesPage.searchCity();
       Thread.sleep(2000);
       String expectedResult="Mumbaj";
       String actualResult= adminCitiesPage.getNameCity().getText();
        Assert.assertTrue(actualResult.contains(expectedResult) );

    }

    @Test(priority = 5)
    public void deleteCity() throws InterruptedException {
        homePage.openLoginPage();
        Thread.sleep(2000);
        loginPage.login("admin@admin.com", "12345");
        Thread.sleep(2000);
        homePage.getAdminBtn().click();                                                               //klik na AdminBTN iz home page
        Thread.sleep(1000);
        adminCitiesPage.getCitiesBtn().click();                                                       //klik na BTN cities iz AdminCities Page
        Thread.sleep(1000);                                                                     //bez threada nece da radi
        adminCitiesPage.deleteCity();
        Thread.sleep(2000);

        String expectedResult="Deleted successfully";
        String actualResult=adminCitiesPage.getDeleteCityMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
