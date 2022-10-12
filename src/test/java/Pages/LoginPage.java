package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{


    private By emailField= By.id("email");
    private By passwordField = By.id("password");
    private By loginBtn= By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private By userDoesNotExistField = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");
    private By userDoesNotExistMessageField = By.xpath(
            "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By wrongPasswordMesage =By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private  By wrongPasswordField = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public WebElement getEmailField() {
        return getDriver().findElement(emailField);         //pronalazim email Field
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }

    public WebElement getUserDoesNotExistField() {
        return getDriver().findElement(userDoesNotExistField);
    }

    public WebElement getUserDoesNotExistMessageField() {
        return getDriver().findElement(userDoesNotExistMessageField);
    }

    public WebElement getWrongPasswordMesage() {
        return getDriver().findElement(wrongPasswordMesage);
    }

    public WebElement getWrongPasswordField() {
        return getDriver().findElement(wrongPasswordField);
    }

    public void login(String email, String password){
        getEmailField().clear();
        getEmailField().sendKeys(email);
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
        getLoginBtn().click();
    }




}
