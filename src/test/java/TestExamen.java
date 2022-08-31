import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.CheckoutPage;
import pages.DescriptionPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class TestExamen extends BaseTest{
    @Test()
    public void verificarTodoExamen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUsernameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickLoginButton();

        DescriptionPage descriptionPage = new DescriptionPage(DriverManager.getDriver().driver);
        descriptionPage.clickOnAddBackPack();
        descriptionPage.clickOnAddBikeLight();

        CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver().driver);

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnCartButton();

        System.out.println(descriptionPage.getTextItemCarrito());
        Assert.assertEquals(descriptionPage.getTextItemCarrito(),"2");
        //------------------------------------------------------

        Thread.sleep(2000);
        List<String> prices = checkoutPage.getAllItemPrices();

        for (String price:prices){
            System.out.println(price);
        }
        //boolean pricesAreSorted = Ordering.natural().reverse().isOrdered(prices);
        List<String> preciosC = new ArrayList<>();
        preciosC.add("$29.99");
        preciosC.add("$9.99");

        Assert.assertEquals(checkoutPage.getAllItemPrices(), preciosC);


        Assert.assertFalse(checkoutPage.listaVaciaItem());

        Assert.assertTrue(checkoutPage.verifyNoItemsByNameBackPack());
        Assert.assertTrue(checkoutPage.verifyNoItemsByNameBike());

        checkoutPage.clickOnRemoveBackPack();
        checkoutPage.clickOnRemoveBike();
        Thread.sleep(2000);
        Assert.assertTrue(checkoutPage.verifyNoItems());

    }
}
