package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "shopping_cart_link")
    WebElement iconoCarrito;
////div[text()='Sauce Labs Backpack']
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement sauceLabsBackAddToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement sauceLabsBackPackRemoveButton;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyAppLogo() {
        boolean verifyAppLogo = appLogo.isDisplayed();
        return verifyAppLogo;
    }

    public String getTextItemCarrito(){
        String textoCarrito = iconoCarrito.getText();
        return textoCarrito;
    }

    public void clickOnAddBackPack(){
        sauceLabsBackAddToCartButton.click();
    }
    public void clickOnRemoveBackPack(){
        sauceLabsBackPackRemoveButton.click();
    }

    // FILTROS -----------------------------------------
    @FindBy(className = "product_sort_container")
    WebElement containerFiltros;
    public void clickOnContainer(){
        containerFiltros.click();
    }
    public String getTextFiltros(){
        String textoFiltros = containerFiltros.getText();
        return textoFiltros;
    }
    /*
    public String selectFiltro(){

        return ;
    }
    */
    // MENU -----------------------------------------

    @FindBy(id = "react-burger-menu-btn")
    WebElement botonMenu;

    @FindBy(id = "about_sidebar_link")
    WebElement sliderMenu;

    @FindBy(className = "nav-image-link")
    WebElement elementoPaginaAbout;
    public void clickOnMenu(){
        botonMenu.click();
    }

    public void clickOnAbout(){
        sliderMenu.click();
    }

    public boolean verifyElementAboutPage() {
        boolean verifyElementAboutPage = elementoPaginaAbout.isDisplayed();
        return verifyElementAboutPage;
    }
    //----------Descripcion

    @FindBy(className = "inventory_item_name")
    WebElement nombreItem;

    public void clickOnNombreItem(){
        nombreItem.click();
    }

    @FindBy(id = "back-to-products")
    WebElement botonBackToProducts;
    public boolean verifyElementBotonBack() {
        boolean verifyElementBotonBack = botonBackToProducts.isDisplayed();
        return verifyElementBotonBack;
    }
}
