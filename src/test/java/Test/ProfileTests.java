package Test;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTests extends BaseTest{
    Faker faker= new Faker();
//Test #1: Edits profile
//Podaci: random podaci korišćenjem faker library-ja
//assert:
//Verifikovati da je prikazana poruka Profile saved successfuly
//Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme
    @Test
    public void editsPtofileTest() throws InterruptedException {
        homePage.openLoginPage();                                                      //pomocu metode openLoginPage() otvaram Login Page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));             //dodajem waiter
        String email= "admin@admin.com";                                               //deklarisem i dodeljujem vrednost za email
        String password= "12345";                                                      ///deklarisem i dodeljujem vrednost za password
        loginPage.login(email,password);                                                //prosledjujem metodi login vrednosti email i password


        homePage.getMyProfileBtn().click();
        String name= String.valueOf(faker.name());
        String city=faker.address().city();
        String phone= String.valueOf(faker.phoneNumber());
        String country= faker.address().country();

        String twitter="http://"+faker.internet().domainName();

        String gutHub= "https://" + faker.internet().domainName();

        myProfilePage.editProfile(name,phone,country,twitter,gutHub);

        WebElement messageField= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"));
        String expectedMesage= "Profile saved successfuly";
        Assert.assertTrue(messageField.getText().contains(expectedMesage));








    }
}
