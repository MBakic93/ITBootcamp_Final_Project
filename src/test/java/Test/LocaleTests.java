package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{
    //Test #1: Set locale to ES
    //assert:
    //•	Postaviti jezik na ES
    //•	Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje
    @Test
    public void SetLocaleToSpanishTest(){
        homePage.getLanguageSetBtn().click();
        homePage.getEsBtn().click();
        WebElement hederElement= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        String expectedResult="Página de aterrizaje";
        String actualResult= hederElement.getText();

        Assert.assertTrue(actualResult.contains(expectedResult));


    }

}
