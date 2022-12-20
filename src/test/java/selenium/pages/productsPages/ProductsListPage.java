package selenium.pages.productsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.pages.utilities.BasePage;

public class ProductsListPage extends BasePage {
    private final By titleText = By.className("title");
//    private final By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
//    private static final String addToCartButtonForProduct ="//td[normalize-space(text())=%s]/a";
    private static final String addToCartButtonForProduct ="//div[text()='%s']/parent::a/parent::div/parent::div//button[text()='Add to cart']";

    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getText(titleText);
    }

    public void clickAddToCartForProduct(String productName) {
        clickStringXpath(String.format(addToCartButtonForProduct, productName));
    }
}
