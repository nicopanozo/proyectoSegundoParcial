import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

import java.util.List;

public class HomeTests extends BaseTest {

    @Test
    public void verificarCartNumberPlus(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnAddBackPack();
        System.out.println(homePage.getTextItemCarrito());
        Assert.assertEquals(homePage.getTextItemCarrito(),"1");
    }
    @Test
    public void verificarCartNumberLess(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnAddBackPack();
        homePage.clickOnRemoveBackPack();
        System.out.println(homePage.getTextItemCarrito());
        Assert.assertNotEquals(homePage.getTextItemCarrito(),"1");
    }

    /*
    @Test
    public void verificarFuncionSegundoFiltro(){
        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnContainer();
        homePage.clickOnContainer();
        String a = homePage.getTextFiltros();
        if (a == "NAME (Z TO A)"){
            Assert.assertTrue(homePage.verifyAppLogo());
            Assert.assertEquals(homePage.getTextFiltros(),"");
        }
        else{
            return false;
        }
    }
     */

    @Test
    public void verificarClickOnCarritoCheckOut(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnCartButton();

        CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver().driver);
        Assert.assertTrue(checkoutPage.verifyCheckOutButton());
    }

    @Test
    public void verificarFuncionAbout(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnMenu();
        homePage.clickOnAbout();
        Assert.assertTrue(homePage.verifyElementAboutPage());
        //Assert.assertTrue(homePage.verifyElementAboutPage());
    }

    @Test
    //Verificar que al dar click en el nombre de un producto en el homepage nos lleva a una pagina con la informacion detallada de este producto
    public void verificarAlDarClickEnNombre(){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnNombreItem();
        Assert.assertTrue(homePage.verifyElementBotonBack());
        //Assert.assertTrue(homePage.verifyElementAboutPage());
    }

    @Test
    public void verifyHighToLowPriceItemFilterTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();
        //Filtrando
        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectProductFilter("Price (low to high)");

        Thread.sleep(5000);
        List<Double> prices = homePage.getAllItemPrices();

        for (Double price:prices){
            System.out.println(price);
        }
        //boolean pricesAreSorted = Ordering.natural().reverse().isOrdered(prices);
        boolean pricesAreSorted = Ordering.natural().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);

    }

    @Test
    public void verifyLowToHighPriceItemFilterTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();
        //Filtrando
        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectProductFilter("Price (high to low)");

        Thread.sleep(5000);
        List<Double> prices = homePage.getAllItemPrices();

        for (Double price:prices){
            System.out.println(price);
        }
        boolean pricesAreSorted = Ordering.natural().reverse().isOrdered(prices);
        //boolean pricesAreSorted = Ordering.natural().isOrdered(prices);
        Assert.assertTrue(pricesAreSorted);
    }

}
