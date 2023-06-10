package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage ( WebDriver driver){
        super(driver);
    }

    By nameOfProduct3By = By.xpath("//*[@id='item_1_title_link']/div");
    By nameOfProduct4By = By.xpath("//*[@id='item_5_title_link']/div");
    By checkoutButtonBy = By.id("checkout");
  

    public ShoppingCartPage verifySuccessfulAddedProduct3(String expectedName){
        String productsName = readText(nameOfProduct3By);
        assertTextEquals(productsName, expectedName);
        return this;
    }
    
    public ShoppingCartPage verifySuccessfulAddedProduct4(String expectedName){
        String productsName = readText(nameOfProduct4By);
        assertTextEquals(productsName, expectedName);
        return this;
    }

    public ShoppingCartPage clickOnCheckoutButton(){
        click(checkoutButtonBy);
        return this;
    }
     
}
