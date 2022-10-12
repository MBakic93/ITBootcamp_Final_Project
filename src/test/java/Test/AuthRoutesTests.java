package Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    public void verifyGuestCanNotReachHomePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult = "/login";
        String actualResult = driver.getCurrentUrl();

        //Verify that the route /login appears in the url of the page
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyGuestCanNotReachProfilePage() {
        //Load the /profile page
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedResult = "/login";
        String actualResult = driver.getCurrentUrl();

        //Verify that the route /login appears in the url of the page
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void verifyCanNotReachAdminCitiesPage() {
        //Load the /admin/cities page
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedResult = "/login";
        String actualResult = driver.getCurrentUrl();

        ////Verify that the route /login appears in the url of the page
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority = 4)
    public void verifyUserCanNotReachAdminUsersPage() {
        //Load the /admin/users page
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedResult = "/login";
        String actualResult = driver.getCurrentUrl();

        //Verify that the route /login appears in the url of the page
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
