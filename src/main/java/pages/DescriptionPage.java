package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DescriptionPage {
    //Sauce Labs Backpack
    WebDriver driver;

    public DescriptionPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    WebElement iconoCarrito;


    public void clickOnAddToCart(){
        addToCartButton.click();
    }

    public String getTextItemCarrito(){
        String textoCarrito = iconoCarrito.getText();
        return textoCarrito;
    }
    public void clickOnAddBackPack(){
        addToCartButton.click();
    }
}
