package Test;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AdminCitiesTest extends BaseTest {
    Faker faker = new Faker();

    @Test
    public void VisitsTheAdminCitiesAndListCitiesTest() throws InterruptedException {
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.login("admin@admin.com", "12345");
        Thread.sleep(1500);
        homePage.getAdminBtn().click();
        Thread.sleep(1000);
        adminCitiesPage.getCitiesBtn().click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlPart = "/admin/cities";

        ////Verify that the /admin/cities route appears in the url of the page
        Assert.assertTrue(actualUrl.contains(expectedUrlPart));

        // Verify if there is a login button from the home page
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed());

    }

    @Test
    public void createNewCityTest() throws InterruptedException {
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.login("admin@admin.com", "12345");
        Thread.sleep(1000);
        homePage.getAdminBtn().click();
        Thread.sleep(1000);
        adminCitiesPage.getCitiesBtn().click();
        String cityName = "Mumbaj";
        adminCitiesPage.createNewCity(cityName);
        String actualMessage = adminCitiesPage.getSaveMessageField().getText();
        String expectedMessage = "Saved successfully";

        // Verify that the message contains the text Saved successfully
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }


    @Test(dependsOnMethods = {"createNewCityTest"})
    public void editCityTest() throws InterruptedException {
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.login("admin@admin.com", "12345");
        Thread.sleep(1500);
        homePage.getAdminBtn().click();
        Thread.sleep(1000);
        adminCitiesPage.getCitiesBtn().click();

        WebElement myCityNameEditBtn = driver.findElement(By.id("edit"));
        myCityNameEditBtn.click();
        WebElement cityNameEditField = driver.findElement(By.id("name"));
        cityNameEditField.click();
        cityNameEditField.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);

        cityNameEditField.sendKeys("Mumbaj-edited");

        adminCitiesPage.getSaveBtnCity().click();
        Thread.sleep(2000);
        adminCitiesPage.getSaveMessageField().getText();

        String expectedMessage = "Saved successfully";
        String actualMesage = adminCitiesPage.getSaveMessageField().getText();

        //Verify that the message contains the text Saved successfully
        Assert.assertTrue(actualMesage.contains(expectedMessage));

    }

    @Test(dependsOnMethods = {"editCityTest"})
    public void searchCityTest() throws InterruptedException {
        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.login("admin@admin.com", "12345");
        homePage.getAdminBtn().click();
        adminCitiesPage.getCitiesBtn().click();

        adminCitiesPage.searchCity();
        Thread.sleep(2000);
        String expectedResult = "Mumbaj";
        String actualResult = adminCitiesPage.getNameCity().getText();

        //Verify that there is text from the search in the Name column of the first row
        Assert.assertTrue(actualResult.contains(expectedResult));


    }


    @Test(dependsOnMethods = {"editCityTest", "createNewCityTest"})
    public void deleteCity() throws InterruptedException {
        homePage.openLoginPage();
        loginPage.login("admin@admin.com", "12345");
        homePage.getAdminBtn().click();
        adminCitiesPage.getCitiesBtn().click();

        adminCitiesPage.deleteCity();

        webDriverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Deleted successfully\nCLOSE"));

        String expectedResult = "Deleted successfully";
        String actualResult = adminCitiesPage.getDeleteCityMessage().getText();
        //  Verify that the message contains the text Deleted successfully
        Assert.assertTrue(actualResult.contains(expectedResult));

    }


}
