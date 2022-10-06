package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage{


    private By citiesBtn = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    private By newItem= By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private  By searchField= By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[2]");



    public AdminCitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

   /* public WebElement getAdminBtn() {
        return getDriver().findElement(adminBtn);
    }*/

    public WebElement getCitiesBtn() {
        return getDriver().findElement(citiesBtn);
    }

    public WebElement getNewItem() {
        return getDriver().findElement(newItem);
    }

    public WebElement getSearchField() {
        return getDriver().findElement(searchField);
    }
}
