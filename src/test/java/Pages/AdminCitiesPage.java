package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {


    private By citiesBtn = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    private By newItemBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By searchField = By.id("search");
    private By nameCityField = By.id("name");
    private By nameCity = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");
    private By saveBtn = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    private By searchedText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]");
    private By firstCityInTable = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");
    private By deleteFirstCityBtn = By.xpath("//*[@id=\"delete\"]/span");
    private By deleteCityMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By saveMessageField = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By saveBtnCity = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    private By deleteDialog = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]/span");


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


    public WebElement getNameCity() {
        return getDriver().findElement(nameCity);
    }


    public WebElement getSaveBtnCity() {
        return getDriver().findElement(saveBtnCity);
    }

    public WebElement getDeleteDialog() {
        return getDriver().findElement(deleteDialog);
    }

    public WebElement getDeleteBtn() {
        return getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/button[2]"));
    }

    public WebElement getDeleteCityMessage() {
        return getDriver().findElement(deleteCityMessage);
    }

    public WebElement getDeleteFirstCityBtn() {
        return getDriver().findElement(deleteFirstCityBtn);
    }

    public void createNewCity(String cityName) {
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

        WebElement city = getFirstCityInTable();
        WebElement search = getSearchField();
        search.clear();
        search.sendKeys(city.getText());

        WebElement delete = getDeleteFirstCityBtn();
        delete.click();

        WebElement deleteDialog = getDeleteDialog();
        deleteDialog.click();
        Thread.sleep(1000);
        getDeleteBtn().click();

        //getWebWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Deleted successfully\nCLOSE"));


    }


}



