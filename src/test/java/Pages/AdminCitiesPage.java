package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage{



    private By citiesBtn = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    private By newItemBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private  By searchField= By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[2]");
    private By nameCityField = By.id("name");
    private By saveBtn= By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");



    public AdminCitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getCitiesBtn() {
        return getDriver().findElement(citiesBtn);
    }

    public WebElement getNewItemBtn() {
        return getDriver().findElement(newItemBtn);
    }

    public WebElement getSearchField() {
        return getDriver().findElement(searchField);
    }

    public WebElement getNameCityField() {
        return getDriver().findElement(nameCityField);
    }
    public WebElement getSaveBtn() {
        return getDriver().findElement(saveBtn);
    }

    public void createNewCity(String cityName){
        Faker faker= new Faker();
        String nameOfCity=faker.address().cityName();
        getNewItemBtn().click();
        getNameCityField().click();
        getNameCityField().sendKeys(cityName);
        getSaveBtn().click();

    }

    /*public void addNewCity() throws InterruptedException {
        faker = new Faker();
        String city = faker.address().city();
        getCreateItemBtn().click();
        getCreatNameInputField().click();
        getCreatNameInputField().sendKeys(city);
        Thread.sleep(1000);
        getSaveNewItemBtn().click();
    }*/
}
