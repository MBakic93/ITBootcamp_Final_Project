package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitiesTest extends BaseTest{
    //Test #1: Visits the admin cities page and list cities
    //Podaci:
    //•	admin email: admin@admin.com
    //•	admin password: 12345
    //assert:
    //•	Verifikovati da se u url-u stranice javlja /admin/cities ruta
    //•	Verifikovati postojanje logut dugmeta
    @Test(priority = 1)
    public void VisitsTheAdminCitiesAndListCitiesTest() throws InterruptedException {
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String adminEmail= "admin@admin.com";
        String password="12345";
        loginPage.login(adminEmail,password);
        Thread.sleep(2000);
        homePage.getAdminBtn().click();
        Thread.sleep(2000);
        adminCitiesPage.getCitiesBtn().click();
        Thread.sleep(1000);
        String actualUrl= driver.getCurrentUrl();
        String expectedUrlPart= "/admin/cities";

        Assert.assertTrue(actualUrl.contains(expectedUrlPart));
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed());

    }
}
