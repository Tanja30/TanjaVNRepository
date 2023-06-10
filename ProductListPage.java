package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListPage extends BasePage {

    public ProductListPage (WebDriver driver) {
        super(driver);
    }
    
    By titlePLPBy = By.xpath("//*[@id='header_container']/div[2]/span ");
    By menuButtonBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");
    By numberOfProducts = By.className("inventory_item");
    By addToCartButton3By = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By addToCartButton4By = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By shoppingCarButtonBy = By.className("shopping_cart_link");
    By nameOfProductsBy = By.className("inventory_item_name");
     

    public ProductListPage verifySuccessfulLogin(String expectedTitle){
        String pageTitle = readText(titlePLPBy);
        assertTextEquals(pageTitle, expectedTitle);
        return this;
    }

    public ProductListPage clickOnMenuButton(){
        click(menuButtonBy);
        return this;
    }

    public ProductListPage clickOnLogoutButton(){
        click(logoutButtonBy);
        return this;
    }

    public ProductListPage verifyNumberOfProducts (int expectedNumberOfProducts){
        int actualNumberOfProducts = countProducts(numberOfProducts);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }
    
    public ProductListPage  clickOnAddButton3(){
        click(addToCartButton3By);
        return this;
    }

    public ProductListPage clickOnAddButton4(){
        click(addToCartButton4By);
        return this;
    }

    public ProductListPage clickOnShoppingCartButton(){
        click(shoppingCarButtonBy);
        return this;
    }

    
}

