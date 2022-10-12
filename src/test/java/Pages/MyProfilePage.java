package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyProfilePage extends BasePage {

    private By nameField = By.id("name");
    private By phoneField = By.id("phone");
    private By cityField = By.id("city");
    private By country = By.id("country");
    private By twitterAddress = By.id("urlTwitter");
    private By gitHubField = By.id("urlGitHub");
    private By saveBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    private By messageField = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");

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

    public WebElement getMessageField() {
        return getDriver().findElement(messageField);
    }

    public void editProfile(String name, String phone,String country, String twitterAddress, String gitHub) throws InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getNameField().sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        getNameField().sendKeys(name);
        WebElement closeX= getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[3]/span/div/div/div[1]/div[2]/div/button"));
        closeX.click();
        getPhoneField().sendKeys(phone);

        getCityField().clear();
        getCityField().sendKeys("Chicago"+ Keys.ENTER);


        getCountry().sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        getCountry().sendKeys(country);

        getTwitterAddress().sendKeys(Keys.CONTROL + "A" + Keys.DELETE);

        getTwitterAddress().clear();
        getTwitterAddress().sendKeys(twitterAddress);
        getSaveBtn().click();
        getGitHubField().sendKeys(Keys.CONTROL + "A" + Keys.DELETE);

        getGitHubField().clear();
        getGitHubField().sendKeys(gitHub);

    }
}

