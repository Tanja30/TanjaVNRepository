package tests;

import org.junit.Test;

import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductListPage;
import pages.ShoppingCartPage;

public class ShoppingTests extends BaseTest{

    public LoginPage loginPage;
    public ProductListPage productListPage;
    public ShoppingCartPage shoppingCartPage;
    public CheckoutPage checkoutPage;

    String standardUsername = "standard_user";
    String correctPassword = "secret_sauce";
    String titlePLP = "Products";

    int numberOfAllProducts = 6;

    String nameOfProducts3 = "Sauce Labs Bolt T-Shirt";
    String nameOfProducts4 = "Sauce Labs Fleece Jacket";

    String correctFirstName = "Tanja";
    String correctLastName = "Vasic Nedic";
    String correctCodePostal = "13014";
    String checkoutTitle = "Checkout: Overview";

    double item = 65.98;
    double tax = 5.28;
    double total = 71.26;

    String finishShoppingMessage = "Thank you for your order!";


    

@Test
public void numberOffProductsPLP (){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, correctPassword);
    productListPage.verifySuccessfulLogin(titlePLP);
    productListPage.verifyNumberOfProducts(numberOfAllProducts);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}  

@Test
public void successfulAddedProducts (){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, correctPassword);
    productListPage.clickOnAddButton3();
    productListPage.clickOnAddButton4();
    productListPage.clickOnShoppingCartButton();
    shoppingCartPage.verifySuccessfulAddedProduct3(nameOfProducts3);
    shoppingCartPage.verifySuccessfulAddedProduct4(nameOfProducts4);

    
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyTotalPrice (){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, correctPassword);
    productListPage.clickOnAddButton3();
    productListPage.clickOnAddButton4();
    productListPage.clickOnShoppingCartButton();
    shoppingCartPage.verifySuccessfulAddedProduct3(nameOfProducts3);
    shoppingCartPage.verifySuccessfulAddedProduct4(nameOfProducts4);
    shoppingCartPage.clickOnCheckoutButton();
    checkoutPage.successfulInformationCheckout(correctFirstName, correctLastName, correctCodePostal);
    checkoutPage.clickOnContinueButton();
    checkoutPage.verifySuccessfulCheckout(checkoutTitle);
    checkoutPage.calculatedTotalPrice();


    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifySuccessfulFinishShopping (){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, correctPassword);
    productListPage.clickOnAddButton3();
    productListPage.clickOnAddButton4();
    productListPage.clickOnShoppingCartButton();
    shoppingCartPage.verifySuccessfulAddedProduct3(nameOfProducts3);
    shoppingCartPage.verifySuccessfulAddedProduct4(nameOfProducts4);
    shoppingCartPage.clickOnCheckoutButton();
    checkoutPage.successfulInformationCheckout(correctFirstName, correctLastName, correctCodePostal);
    checkoutPage.clickOnContinueButton();
    checkoutPage.verifySuccessfulCheckout(checkoutTitle);
    checkoutPage.calculatedTotalPrice();
    checkoutPage.clickOnFinishButton();
    checkoutPage.verifySuccessfulShopping(finishShoppingMessage);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}

}
