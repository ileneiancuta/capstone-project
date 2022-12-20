package selenium.pages.checkoutPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.pages.utilities.BasePage;

public class CheckoutCompletePage extends BasePage {

    private final By backToProductsButton = By.id("back-to-products");
    private final By headerContainer = By.className("header_secondary_container");
    private final By completeHeaderContainer = By.className("complete-header");


    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderContainerText() {
        return getText(headerContainer);
    }

    public String getCompleteHeaderText() {
        return getText(completeHeaderContainer);
    }

    public void clickBackToProductsButton() {
        click(backToProductsButton);
    }

}
