import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.InformationPage;
import pages.LoginPage;
import utilities.DriverManager;

public class CheckoutTests extends BaseTest {
    @Test()
    public void verificarCarritoPasaSinItems() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnCartButton();
        Thread.sleep(2000);
        CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver().driver);
        checkoutPage.clickOnCheckOutButton();
        Thread.sleep(2000);
        InformationPage informationPage = new InformationPage(DriverManager.getDriver().driver);
        Assert.assertTrue(informationPage.verifyContinueButton());

    }

    @Test()
    public void verificarContinueShopping(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnCartButton();

        CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver().driver);
        checkoutPage.clickOnContinueShoppingButton();

        Assert.assertTrue(homePage.verifyAppLogo());
    }

}
