package Test;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SingupTest extends BaseTest {
    Faker faker = new Faker();

    @Test
    public void VisitsTheSignupPageTest() {
        homePage.openSignUpPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualResult = signupPage.getDriver().getCurrentUrl();

        //Verify that the /signup route appears in the url of the page
        Assert.assertTrue(actualResult.endsWith("/signup"));


    }

    @Test
    public void ChecksInputTypes() {
        homePage.openSignUpPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String expectedResultEmail = "email";
        String actualResultEmail = signupPage.getEmailField().getAttribute("type");

        //verify that the email input field for the attribute type has the value email
        Assert.assertEquals(actualResultEmail, expectedResultEmail);

        String expectedResultPassword = "password";
        String actualResultPassword = signupPage.getPasswordField().getAttribute("type");

        //Verify that the password input field for the type attribute has the value password
        Assert.assertEquals(actualResultPassword, expectedResultPassword);

        String expectedResultConfirmPassword = "password";
        String actualResultConfirmPassword = signupPage.getConfirmPasswordField().getAttribute("type");

        //Verify that the confirmation password input field for the type attribute has the value password
        Assert.assertTrue(actualResultConfirmPassword.contains(expectedResultConfirmPassword));


    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists() {
        homePage.openSignUpPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String name = "Test Test";
        String email = "admin@admin.com";
        String password = "123654";
        String confirmPassword = "123654";
        signupPage.signUp(name, email, password, confirmPassword);

        //Verify that the message field exists
        Assert.assertTrue(signupPage.getMesageField().isDisplayed());

        String expectedMessage = "E-mail already exists";
        String actualMessage = signupPage.getEmailAlreadyExistMessage().getText();

        //Verify that the error contains the message E-mail already exists
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        //Verify that the /signup route appears in the url of the page
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/signup"));

    }

    @Test
    public void SignupTest() throws InterruptedException {
        homePage.openSignUpPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String name = "Milica Bakic";
        String email = faker.internet().emailAddress();
        String password = "12346";
        String confirmPassword = "12346";

        signupPage.signUp(name, email, password, confirmPassword);
        //Without tread sleep, the test fails, I dream it passes successfully, with the need of a waiter, the test fails
        Thread.sleep(2000);
        String expectedMessage = "IMPORTANT: Verify your account";
        String actualMessage = signupPage.getMessageVerifyYourAccountField().getText();
        Thread.sleep(1000);

        //Verify that the notification dialog contains the text IMPORTANT: Verify your account
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }


}
