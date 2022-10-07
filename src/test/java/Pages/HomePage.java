package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private By goToLoginPageBTN= By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]\n");

    private By signUpBTN= By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");
    private By adminBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span");
    private By logoutBtn= By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
    private  By languageSetBtn= By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button");

    private By esBtn=By.id("list-item-75");




    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getGoToLoginPageBTN() {
        return getDriver().findElement(goToLoginPageBTN);              //Pronalazim dugme za odlazak na login page
    }

    public WebElement getSignUpBTN() {
        return getDriver().findElement(signUpBTN);
    }
    public WebElement getAdminBtn() {
        return getDriver().findElement(adminBtn);
    }

    public WebElement getLogoutBtn() {
        return getDriver().findElement(logoutBtn);
    }
    public WebElement getLanguageSetBtn() {
        return getDriver().findElement(languageSetBtn);
    }

    public WebElement getEsBtn() {
        return getDriver().findElement(esBtn);
    }

    public void openLoginPage(){                                     //metoda za odlazak na login page
        getGoToLoginPageBTN().click();                              //otvaram loginPage
    }

    public void openSignUpPage(){                                   //metoda za odlazak na signUp page
        getSignUpBTN().click();                                     //otvaram signUp
    }



}
