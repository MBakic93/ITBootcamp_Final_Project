package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{

    @Test
    public void setLocaleToSpanishTest(){
        homePage.getLanguageSetBtn().click();
        homePage.getEspaniolBtn().click();

        String expectedResult="Página de aterrizaje";
        String actualResult= homePage.getHederElement().getText();

        //Set language to ES
        Assert.assertTrue(homePage.getEspaniolBtn().getText().equals("ES"));

        //Verify that the text Página de aterrizaje appears in the header of the page
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    public void setLocaleToEnglishTest(){
        homePage.getLanguageSetBtn().click();
        homePage.getEnglishBtn().click();

        String expectedResult="Landing";
        String actualResult= homePage.getHederElement().getText();

        //Set language to EN
        Assert.assertTrue(homePage.getEnglishBtn().getText().equals("EN"));

        //Verify that the text Landing appears in the header of the page
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    public void setLocaleToFrenchTest(){
        homePage.getLanguageSetBtn().click();
        homePage.getFrenchBtn().click();

        String expectedResult="Page d'atterrissage";
        String actualResult= homePage.getHederElement().getText();

        //Set language to FR
        Assert.assertTrue(homePage.getFrenchBtn().getText().equals("FR"));

        //Verify that the text  Page d'atterrissage appears in the header of the page
        Assert.assertTrue(actualResult.contains(expectedResult));

    }


}
