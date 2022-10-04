package Pages;
//Osnovna klasa koju svaki test da nasledjuje. Ova klasa treba da ima:
//•	baseUrl - url stranice https://vue-demo.daniel-avellaneda.com
//•	beforeClass - gde se podesava drajver sa implicitnim cekanjem
// i cekanjem za ucitavanje stranice i kreiraju svi pagevi potrebni za testiranje
//•	aftterClass - gde se gasi stranica
//•	beforeMethod - gde se pre svakog testa ucitava baseUrl stranica
//
//Navedene su samo obavezne assertacije, po potrebi dodajte dodatne.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public  class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    String baseURL="https://vue-demo.daniel-avellaneda.com";
    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public WebDriverWait getWait() {
        return wait;
    }

}
