package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyProfilePage extends BasePage {

    private By nameField= By.id("name");
    private By phoneField=By.id("phone");
    private By cityField= By.id("city");
    private By country= By.id("country");
    private By twitterAddress= By.id("urlTwitter");
    private By gitHubField= By.id("urlGitHub");
    private By saveBtn= By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");

    public MyProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getPhoneField() {
        return getDriver().findElement(phoneField);
    }

    public WebElement getCityField() {
        return getDriver().findElement(cityField);
    }

    public WebElement getCountry() {
        return getDriver().findElement(country);
    }

    public WebElement getTwitterAddress() {
        return getDriver().findElement(twitterAddress);
    }

    public WebElement getGitHubField() {
        return getDriver().findElement(gitHubField);
    }

    public WebElement getSaveBtn() {
        return getDriver().findElement(saveBtn);
    }


    public void editProfile(String name, String phone, String country, String twitterAddress,String gitHub ) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getNameField().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getNameField().sendKeys(name);
        getPhoneField().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getPhoneField().sendKeys(phone);
        //getCityField().click();

       // WebElement city= getDriver().findElement(By.xpath("//*[@id=\"list-item-394-15\"]/div/div"));   //CITYYYY!!!!
        //city.click();
        getCountry().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getCountry().sendKeys(country);

        getTwitterAddress().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);

        getTwitterAddress().clear();
        getTwitterAddress().sendKeys(twitterAddress);
        getSaveBtn().click();
        getGitHubField().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);

        getGitHubField().clear();
        getGitHubField().sendKeys(gitHub);

    }
}
