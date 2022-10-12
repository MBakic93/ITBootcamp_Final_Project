package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirmPassword");
    private By signMeUpBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");
    private By mesageField = By.xpath(
            "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div");
    private By messageVerifyYourAccountField = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");

    private By emailAlreadyExistMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li");

    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getConfirmPasswordField() {
        return getDriver().findElement(confirmPasswordField);
    }

    public WebElement getSignMeUpBtn() {
        return getDriver().findElement(signMeUpBtn);
    }

    public WebElement getEmailAlreadyExistMessage() {
        return getDriver().findElement(emailAlreadyExistMessage);
    }

    public WebElement getMessageVerifyYourAccountField() {
        return getDriver().findElement(messageVerifyYourAccountField);
    }

    public WebElement getMesageField() {
        return getDriver().findElement(mesageField);
    }

    public void signUp(String name, String email, String password, String confirmPassword) {
        getNameField().clear();
        getNameField().sendKeys(name);
        getEmailField().clear();
        getEmailField().sendKeys(email);
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().clear();
        getConfirmPasswordField().sendKeys(confirmPassword);
        getSignMeUpBtn().click();
    }
}
