package Test;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest extends BaseTest {

    private Faker faker = new Faker();

    @Test

    public void visitsTheLoginPageTest() {
        homePage.openLoginPage();
        String actualResult = loginPage.getDriver().getCurrentUrl();

        // Verify that the route /login appears in the url of the page
        Assert.assertTrue(actualResult.endsWith("/login"));

    }

    @Test
    public void checksInputTypesTest() {

        homePage.openLoginPage();
        String expectedResultEmail = "email";
        String actualResultEmail = loginPage.getEmailField().getAttribute("type");

        //Verify that the email input field for the type attribute has the value email
        Assert.assertEquals(actualResultEmail, expectedResultEmail);


        String expectedResultPassword = "password";
        String actualResultPassword = loginPage.getPasswordField().getAttribute("type");

        //Verify that the password input field for the type attribute has the value password
        Assert.assertEquals(actualResultPassword, expectedResultPassword);

    }

    @Test
    public void userDoesNotExistTest() {
        homePage.openLoginPage();
        String emailRnd = faker.internet().emailAddress();
        String passwordRnd = faker.internet().password();
        loginPage.login(emailRnd, passwordRnd);

        //verify that the error message box appears
        Assert.assertTrue(loginPage.getUserDoesNotExistField().isDisplayed());


        String expectedMessage = "User does not exists";
        String actualMessage = loginPage.getUserDoesNotExistMessageField().getText();

        //Verify that the error contains the message User does not exist
        Assert.assertEquals(actualMessage, expectedMessage);


        String expectedUrlRoute = "https://vue-demo.daniel-avellaneda.com/login";
        String actualUrlResult = driver.getCurrentUrl();

        //Verify that the /login route appears in the url of the page
        Assert.assertTrue(actualUrlResult.endsWith(expectedUrlRoute));

    }

    @Test
    public void displayErrorsWhenPasswordIsWrongTest() {
        homePage.openLoginPage();
        String passwordRnd = faker.internet().password();
        String email = "admin@admin.com";
        loginPage.login(email, passwordRnd);

        //verify that the error message box appears
        Assert.assertTrue(loginPage.getWrongPasswordField().isDisplayed());


        String expectedMessage = "Wrong password";
        String actualMessage = loginPage.getWrongPasswordMesage().getText();

        //Verify that the error contains the message Wrong password
        Assert.assertEquals(actualMessage, expectedMessage);


        String actualUrl = driver.getCurrentUrl();
        String expectedPartUrl = "/login";

        //Verify that the /login route appears in the url of the page
        Assert.assertTrue(actualUrl.contains(expectedPartUrl));

    }

    @Test
    public void loginTest() throws InterruptedException {
        homePage.openLoginPage();
        loginPage.login("admin@admin.com",  "12345");

        //without thread sleep it throws an error, with it,  executes the test successfully
        Thread.sleep(1000);
        String actualUrl = driver.getCurrentUrl();
        String expectedPartUrl = "/home";

        //Verify that the /home route appears in the url of the page
        Assert.assertTrue(actualUrl.contains(expectedPartUrl));
        homePage.logout();
    }

    @Test
    public void logoutTest() throws InterruptedException {

        homePage.openLoginPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String email = "admin@admin.com";
        String password = "12345";
        loginPage.login(email, password);

        //Verify that the logout button is visible on the page
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed());

        homePage.logout();
        String actualUrl = driver.getCurrentUrl();
        String expectedPartUrl = "/login";

        //Verify that the /login route appears in the url of the page
        Assert.assertTrue(actualUrl.contains(expectedPartUrl));

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Thread.sleep(1000);

        //Verify that after trying to open the /home route, the /login route appears in the url of the page
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedPartUrl));


    }

}
