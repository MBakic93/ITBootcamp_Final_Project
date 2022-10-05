package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{


    private By emailField= By.id("email");
    private By passwordField = By.id("password");
    private By loginBtn= By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public WebElement getEmailField() {
        return getDriver().findElement(emailField); //pronalazim email Field
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField); //pronalazim password field
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn); //pronalazim dugme za logovanje
    }



    public void login(String email, String password){ //unosim podatke u email i password field, klik na loginBtn
        getEmailField().clear();
        getEmailField().sendKeys(email);
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
        getLoginBtn().click();
    }




}