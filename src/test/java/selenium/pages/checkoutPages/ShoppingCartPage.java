package selenium.pages.checkoutPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.pages.utilities.BasePage;

public class ShoppingCartPage extends BasePage {
    private final By shoppingCartBadge = By.className("shopping_cart_badge");
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By inventoryItem = By.className("inventory_item_name");
    private final By checkoutButton = By.id("checkout");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void openShoppingCartPage() {
        click(shoppingCartLink);
    }

    public void waitUntilBadgeIsVisible() {
        waitForElementVisible(shoppingCartBadge);
    }

    public void waitInventoryItemVisible(String productName) {
        waitForElementVisible(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
    }

    public void clickCheckoutButton() {
        click(checkoutButton);
    }


}
