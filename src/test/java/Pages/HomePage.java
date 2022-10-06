package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private By goToLoginPageBTN= By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]\n");
    private By signUpBTN= By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getGoToLoginPageBTN() {
        return getDriver().findElement(goToLoginPageBTN);              //Pronalazim dugme za odlazak na login page
    }

    public WebElement getSignUpBTN() {
        return getDriver().findElement(signUpBTN);
    }

    public void openLoginPage(){                                     //metoda za odlazak na login page
        getGoToLoginPageBTN().click();                              //otvaram loginPage
    }

    public void openSignUpPage(){                                   //metoda za odlazak na signUp page
        getSignUpBTN().click();                                     //otvaram signUp
    }

}
