package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "shopping_cart_link")
    WebElement botonCarrito;

    public void clickOnCartButton(){
        botonCarrito.click();
    }

    @FindBy(id = "checkout")
    WebElement botonCheckout;

    public void clickOnCheckOutButton(){
        botonCheckout.click();
    }

    public boolean verifyCheckOutButton() {
        boolean verifyAppLogo = botonCheckout.isDisplayed();
        return verifyAppLogo;
    }

    @FindBy(id = "continue-shopping")
    WebElement botonCContinueShopping;

    public void clickOnContinueShoppingButton(){
        botonCContinueShopping.click();
    }

}
