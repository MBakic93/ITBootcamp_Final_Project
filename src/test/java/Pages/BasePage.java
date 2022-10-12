package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    private WebDriver driver;
    private WebDriverWait webWait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.webWait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setWebWait(WebDriverWait webWait) {
        this.webWait = webWait;
    }

    public WebDriverWait getWebWait() {
        return webWait;
    }

}
