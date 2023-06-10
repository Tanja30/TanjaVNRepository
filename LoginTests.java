package tests;

import org.junit.Test;

import pages.LoginPage;
import pages.ProductListPage;

public class LoginTests extends BaseTest {

    public LoginPage loginPage;
    public ProductListPage productListPage;

    String standardUsername = "standard_user";
    String correctPassword = "secret_sauce";
    String titlePLP = "Products";
    String invalidPassword = "sauce";
    String invalidPasswordError = "Epic sadface: Username and password do not match any user in this service";
    String emptyUsername = "";
    String emptyUsernameError = "Epic sadface: Username is required";
    String lockedUser = "locked_out_user";
    String lockedUserError = "Epic sadface: Sorry, this user has been locked out.";

@Test
public void successfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    
    loginPage.basePage();
    loginPage.login(standardUsername, correctPassword);
    productListPage.verifySuccessfulLogin(titlePLP);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void unsuccessfulLoginInvalidPassword(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, invalidPassword);
    loginPage.verifyUnsuccessfulLogin(invalidPasswordError);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void unsuccessfulLoginEmptyUsername (){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(emptyUsername, correctPassword);
    loginPage.verifyUnsuccessfulLogin(emptyUsernameError);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void unsuccessfulLoginLockedUser (){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(lockedUser, correctPassword);
    loginPage.verifyUnsuccessfulLogin(lockedUserError);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyLogout(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, correctPassword);
    productListPage.verifySuccessfulLogin(titlePLP);
    productListPage.clickOnMenuButton();
    productListPage.clickOnLogoutButton();
    loginPage.verifyLogout();

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
    
}
