package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {
        super(driver);
    }
    

    String URL = "https://www.saucedemo.com/ ";
    By usernameBy = By.id("user-name");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("login-button");
    By errorMessage = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");


    public LoginPage basePage () {
        driver.get(URL);
        return this;
    }

    public LoginPage login (String username, String password) {
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

    public LoginPage verifyUnsuccessfulLogin(String expectedText){
        String actualText = readText(errorMessage);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public LoginPage verifyLogout (){
        waitVisability(usernameBy);
        waitVisability(passwordBy);
        waitVisability(loginButtonBy);
        return this;
    }
}


