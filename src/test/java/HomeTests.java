import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

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


    @Test
    public void verificarFuncionPrimerFiltro(){
        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnContainer();
        homePage.clickOnContainer();

        Assert.assertEquals(homePage.getTextFiltros(),"NAME (Z TO A)");
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
}
