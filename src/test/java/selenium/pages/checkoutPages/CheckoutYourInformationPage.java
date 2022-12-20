package selenium.pages.checkoutPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.pages.utilities.BasePage;

public class CheckoutYourInformationPage extends BasePage {
    private final By continueButton = By.id("continue");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipCodeInput = By.id("postal-code");


    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    public void fillInFirstName(String firstName) {
        sendKeys(firstNameInput, firstName);
    }

    public void fillInLastName(String lastName) {
        sendKeys(lastNameInput, lastName);
    }

    public void fillInZipCode(String zipCode) {
        sendKeys(zipCodeInput, zipCode);
    }


    public void clickContinueButton() {
        click(continueButton);
    }


    public void fillInCheckoutInformation(String firstName, String lastName, String zipCode) {
        fillInFirstName(firstName);
        fillInLastName(lastName);
        fillInZipCode(zipCode);
        clickContinueButton();
    }


    
}
