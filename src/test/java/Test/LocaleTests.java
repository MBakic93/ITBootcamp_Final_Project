package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{

    @Test   //1
    public void setLocaleToSpanishTest(){
        homePage.getLanguageSetBtn().click();     //klik na dugme za promenu jezika
        homePage.getEspaniolBtn().click();              //Klik na dugme ES u izboru jezika

        WebElement hederElement= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        String expectedResult="Página de aterrizaje";
        String actualResult= hederElement.getText();

        Assert.assertTrue(homePage.getEspaniolBtn().getText().equals("ES"));  ///Proveri na kraju

        Assert.assertTrue(actualResult.contains(expectedResult));  //Verifikacija da se na stranici u hederu javlja tekst Página de aterrizaje

    }

    @Test //2
    public void setLocaleToEnglishTest(){
        homePage.getLanguageSetBtn().click();
        homePage.getEnglishBtn().click();
        WebElement hederElement= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));

        String expectedResult="Landing";
        String actualResult= hederElement.getText();

        Assert.assertTrue(homePage.getEnglishBtn().getText().equals("EN"));
        Assert.assertTrue(actualResult.contains(expectedResult));  //Verifikacija da se na stranici u hederu javlja tekst Landing

    }
//Test #3: Set locale to FR
//assert:
//•	Postaviti jezik na FR
//•	Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage
    @Test  //3
    public void setLocaleToFrenchTest(){
        homePage.getLanguageSetBtn().click();
        homePage.getFrenchBtn().click();
        WebElement hederElement= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));

        String expectedResult="Page d'atterrissage";
        String actualResult= hederElement.getText();

        Assert.assertTrue(homePage.getFrenchBtn().getText().equals("FR"));
        Assert.assertTrue(actualResult.contains(expectedResult));  //Verifikacija da se na stranici u hederu javlja tekst Landing


    }


}
