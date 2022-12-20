package selenium.pages.checkoutPages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.pages.utilities.BasePage;

public class CheckoutOverviewPage extends BasePage {

    private final By finishButton = By.id("finish");
    private final By headerContainer = By.className("header_secondary_container");
    private final By publicInfoValue = By.className("summary_value_label");
    private final By shippingInformationValue = By.className("summary_value_label");
    private final By summaryTotalValue = By.className("summary_total_label");


    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderContainerText() {
        return getText(headerContainer);
    }

    public void verifyPublicInfoValue(String expectedPublicInfoValue) {
        waitForElementVisible(By.xpath("//div[@class='summary_value_label' and text()='" + expectedPublicInfoValue + "']"));
    }

    public String getSummaryTotalValue() {
        return getText(summaryTotalValue);
    }

    public void verifyShippingInformationValue(String expectedShippingInformation) {
        waitForElementVisible(By.xpath("//div[@class='summary_value_label' and text()='" + expectedShippingInformation + "']"));
    }

    public void clickFinishButton() {
        click(finishButton);
    }

    public void verifyOverviewInformation(String expectedPageName, String expectedTotalValue) {

        String actualPageName = getHeaderContainerText();
        Assertions.assertEquals(actualPageName, expectedPageName);

        verifyPublicInfoValue("SauceCard #31337");
        verifyShippingInformationValue("FREE PONY EXPRESS DELIVERY!");

        String actualTotalValue = getSummaryTotalValue();
        Assertions.assertEquals(actualTotalValue, expectedTotalValue);
    }


    
}
