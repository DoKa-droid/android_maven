package com.example.common;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    AppiumDriver driver;

    public CartPage(AppiumDriver driver) {
        this.driver = driver;
    }

    SelenideElement cartToolbarTitle = $(By.id("com.asos.app:id/bag_toolbar_tile"));
    SelenideElement emptyCartImage = $(By.id("com.asos.app:id/bag_empty_message_when_expired_items"));
    SelenideElement deleteButton = $(By.xpath("(//android.widget.ImageView[@content-desc='УДАЛИТЬ'])[1]"));
    SelenideElement addToFavoritesButton = $(By.id("com.asos.app:id/bag_item_move_to_saved_button"));
    SelenideElement goToFavoritesButton = $(By.id("com.asos.app:id/bag_addon_items_view_saved_items"));
    SelenideElement finalCart = $(By.id("com.asos.app:id/bag_list_total_amount"));
    SelenideElement image = $(By.id("com.asos.app:id/bag_item_image"));
    SelenideElement productProperties = $(By.id("com.asos.app:id/bag_item_properties_text"));
    SelenideElement price = $(By.id("com.asos.app:id/product_details_price_text"));
    SelenideElement name = $(By.id("com.asos.app:id/bag_product_name")).shouldHave(exactText(Constants.PRODUCTS.PRODUCT_NAME));

    public boolean isItCart() throws InterruptedException {
        Thread.sleep(2000);
        return cartToolbarTitle.exists();
    }

    public boolean isCartEmpty() throws InterruptedException {
        Thread.sleep(2000);
        return emptyCartImage.exists();
    }

    public void clickDelete() throws InterruptedException {
        Thread.sleep(2000);
        deleteButton.click();
    }

    public void clickaddToFavorites() throws InterruptedException {
        Thread.sleep(2000);
        addToFavoritesButton.click();
    }

    public void goToFavorites() {
        goToFavoritesButton.click();
    }

    public int getTotalSum() throws InterruptedException {
        String calculatedSum;
        Thread.sleep(2000);
        calculatedSum = finalCart.getText();
        calculatedSum = calculatedSum.replace("\r\n", "");
        calculatedSum = calculatedSum.replace(" ", "");
        return Integer.valueOf(calculatedSum.substring(0, 3));
    }

    public boolean isAllProductInfoPresent() throws InterruptedException {
        Thread.sleep(2000);
        return (image.exists()
                && name.exists()
                && productProperties.exists()
                && price.exists());
    }

    public boolean isProductInCart() throws InterruptedException {
        Thread.sleep(2000);
        return name.exists();
    }

    public int amountOfProductsInCart() {
        return Integer.parseInt(productProperties.getText().substring(41));
    }
}
