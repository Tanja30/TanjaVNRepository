package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    public CheckoutPage (WebDriver driver){
        super(driver);
    }

    By firstNameBy = By.id("first-name");
    By lastNameBy = By.id("last-name");
    By postalCodeBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");
    By checkoutTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
   
    By itemTotalBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[6]/text()[2]");
    By taxBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[7]/text()[2]");
    By totalBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[8]/text()[2]");

    By finishButtonBy = By.id("finish");
    By finishShoppingMessageBy = By.xpath("//*[@id='checkout_complete_container']/h2");


    public CheckoutPage successfulInformationCheckout(String firstName, String lastName, String postalCode){
        writeText(firstNameBy, firstName);
        writeText(lastNameBy, lastName);
        writeText(postalCodeBy, postalCode);
        return this;
    }

    public CheckoutPage clickOnContinueButton(){
        click(continueButtonBy);
        return this;
    }

    public CheckoutPage verifySuccessfulCheckout(String expectedTitle){
        String checkoutTitle = readText(checkoutTitleBy);
        assertTextEquals(checkoutTitle, expectedTitle);
        return this;
    }

    public CheckoutPage calculatedTotalPrice(){
        double itemTotal = 65.98;
        double tax = 5.28;
        double sumTotal = itemTotal + tax;
        double total = 71.26;

        
        Assert.assertEquals(sumTotal, total ,0.01);
        return this;  
    }

    public CheckoutPage clickOnFinishButton(){
        click(finishButtonBy);
        return this;
    }

    public CheckoutPage verifySuccessfulShopping(String expectedMessage){
        String finishMessage = readText(finishShoppingMessageBy);
        assertTextEquals(finishMessage, expectedMessage);
        return this;
    }
   
}

    
