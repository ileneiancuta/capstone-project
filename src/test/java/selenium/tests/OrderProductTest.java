package selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.models.UserInformation;
import selenium.pages.utilities.BaseTest;
import selenium.pages.checkoutPages.CheckoutCompletePage;
import selenium.pages.checkoutPages.CheckoutOverviewPage;
import selenium.pages.checkoutPages.CheckoutYourInformationPage;
import selenium.pages.LoginPage;
import selenium.pages.productsPages.*;
import selenium.pages.checkoutPages.ShoppingCartPage;

import static selenium.pages.utilities.Constants.checkoutCompletePageName;
import static selenium.pages.utilities.Constants.checkoutOverviewPageName;
import static selenium.pages.utilities.Constants.productPageName;
import static selenium.pages.utilities.Constants.sauceLabsBike;
import static selenium.pages.utilities.Constants.standardPassword;
import static selenium.pages.utilities.Constants.standardUsername;
import static selenium.pages.utilities.Constants.thankYouOrder;

public class OrderProductTest extends BaseTest {

    @Test
    public void orderProductFlow() {

        ProductsListPage productsListPage = new ProductsListPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        UserInformation userInformation = new UserInformation("Ancuta", "Stafie", "54321");


        // Navigate to application and login
        new LoginPage(driver).login(standardUsername, standardPassword);

        // Verify automatic redirect to products page
        String actualPageTitle = productsListPage.getPageTitle();
        Assertions.assertEquals(actualPageTitle, productPageName);

        // Add product to cart and wait for badge to be visible on cart
        productsListPage.clickAddToCartForProduct(sauceLabsBike);
        shoppingCartPage.waitUntilBadgeIsVisible();

        // Open shopping cart page and verify item is visible
        shoppingCartPage.openShoppingCartPage();
        shoppingCartPage.waitInventoryItemVisible(sauceLabsBike);
        shoppingCartPage.clickCheckoutButton();

        // Fill in information for checkout
        checkoutYourInformationPage.fillInCheckoutInformation(userInformation.getFirstName(), userInformation.getLastName(), userInformation.getZipCode());

        // Verify checkout complete page and finish the order
        checkoutOverviewPage.verifyOverviewInformation(checkoutOverviewPageName, "Total: $10.79");
        checkoutOverviewPage.clickFinishButton();

        // Verify Order is complete page
        String actualCompleteCheckoutPageName = checkoutCompletePage.getHeaderContainerText();
        Assertions.assertEquals(actualCompleteCheckoutPageName, checkoutCompletePageName);
        String actualCompleteHeaderText = checkoutCompletePage.getCompleteHeaderText();
        Assertions.assertEquals(actualCompleteHeaderText, thankYouOrder);

    }


}
