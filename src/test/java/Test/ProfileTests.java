package Test;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTests extends BaseTest {
    Faker faker = new Faker();

    @Test
    public void editsPtofileTest() throws InterruptedException {
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPage.login("admin@admin.com", "12345");


        homePage.getMyProfileBtn().click();
        String name = String.valueOf(faker.name());
        String phone = faker.number().digits(9);
        String country = faker.address().country();


        String twitter = "https://twitter.com/" + faker.name().firstName().toLowerCase();
        String gitHub = "https://github.com/" + faker.name().firstName().toLowerCase();
        myProfilePage.editProfile(name, phone, country, twitter, gitHub);
        Thread.sleep(1500);

        String expectedMesage = "Profile saved successfuly";
        Assert.assertTrue(myProfilePage.getMessageField().getText().contains(expectedMesage));


        String actualName = myProfilePage.getNameField().getAttribute("value");
        String actualPhone = myProfilePage.getPhoneField().getAttribute("value");
        String actualCountry = myProfilePage.getCountry().getAttribute("value");
        String actualTwitter = myProfilePage.getTwitterAddress().getAttribute("value");
        String actualGitHub = myProfilePage.getGitHubField().getAttribute("value");
        Thread.sleep(1000);


        //Verify that each input for the value attribute has the value entered in the form

        Assert.assertEquals(actualName, name);
        Assert.assertEquals(actualPhone, phone);
        Assert.assertEquals(actualTwitter, twitter);
        Assert.assertTrue(actualGitHub.contains(gitHub));
        Thread.sleep(1000);
        myProfilePage.getSaveBtn().click();

        ////Verify that the Profile saved successfully message is displayed
        Assert.assertTrue(myProfilePage.getMessageField().getText().contains("Profile saved successfuly"));


    }


}
