package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{
    //Test #1: Forbids visits to home url if not authenticated
    //assert:
    //Ucitati /home stranu kada korisnik nije ulogovan
    //Verifikovati da se u url-u stranice javlja ruta /login
    //

    @Test(priority = 1)
    public void verifyGuestCanNotReachHomePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult = "/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    //Test #2: Forbids visits to profile url if not authenticated
    //assert:
    //Ucitati /profile stranu
    //Verifikovati da se u url-u stranice javlja ruta /login
    //
    @Test(priority = 2)
    public void verifyGuestCanNotReachProfilePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedResult = "/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    //Test #3: Forbids visits to admin cities url if not authenticated
    //assert:
    //Ucitati /admin/cities stranu
    //Verifikovati da se u url-u stranice javlja ruta /login
    //
    @Test(priority = 3)
    public void verifyCanNotReachAdminCitiesPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedResult = "/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    //Test #4: Forbids visits to admin users url if not authenticated
    //assert:
    //Ucitati /admin/users stranu
    //Verifikovati da se u url-u stranice javlja ruta /login
    @Test(priority = 4)
    public void verifyUserCanNotReachAdminUsersPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedResult = "/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains( expectedResult));
    }




}
