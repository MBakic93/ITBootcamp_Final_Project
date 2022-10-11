package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {


    private By citiesBtn = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    private By newItemBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By searchField = By.id("search");     ////"//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[2]");
    private By nameCityField = By.id("name");
    private By nameCity = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");

    private By saveBtn = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    private By searchedText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]");

    private By firstCityInTable = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");
    private By deleteFirstCity = By.xpath("//*[@id=\"delete\"]/span/i");
    private By deleteBtn = By.xpath("\"//*[@id=\\\"delete\\\"]/span/i\"");
    //"//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]");

    private By deleteCityMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

    private By saveMessageField = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");


    public AdminCitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSaveMessageField() {
        return getDriver().findElement(saveMessageField);
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


    public WebElement getFirstCityInTable() {
        return getDriver().findElement(firstCityInTable);
    }

    public WebElement getSearchedText() {
        return getDriver().findElement(searchedText);
    }

    public WebElement getNameCity() {
        return getDriver().findElement(nameCity);
    }

    public WebElement getDeleteFirstCity() {
        return getDriver().findElement(deleteFirstCity);
    }

    //public WebElement getDeleteBtn() {
      //  return getDriver().findElement(deleteBtn);
    //}

    public WebElement getDelete1st() {
        return getDriver().findElement(By.xpath("//*[@id=\"delete\"]/span/i"));
    }
    public WebElement getDeleteBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/button[2]"));
    }


    public WebElement getDeleteCityMessage() {
        return getDriver().findElement(deleteCityMessage);
    }


    public void createNewCity(String cityName) {
        Faker faker = new Faker();
        String nameOfCity = faker.address().cityName();
        getNewItemBtn().click();
        getNameCityField().click();
        getNameCityField().sendKeys(cityName);
        getSaveBtn().click();

    }

    public void searchCity() throws InterruptedException {
        getSearchField().click();
        Thread.sleep(2000);
        String city = getFirstCityInTable().getText();
        getSearchField().sendKeys(city);
        Thread.sleep(2000);
    }


    public void deleteCity() throws InterruptedException {
        getDeleteFirstCity().click();
        //Thread.sleep(1000);
        getWebWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),"Deleted successfully\nCLOSE"));//until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),"Deleted successfully\nCLOSE"));
        getDeleteBtn().click();

    }
   /* public void deleteCity() throws InterruptedException {
        getDelete1st().click();
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),"Deleted successfully\nCLOSE"));
        getDeleteBtn().click();
    }*/


}



