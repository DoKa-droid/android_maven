package com.example.common;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    AppiumDriver driver;

    public ProductPage(AppiumDriver driver) {
        this.driver = driver;
    }

    SelenideElement cartProductButton = $(By.id("com.asos.app:id/bag_fab"));
    SelenideElement addToCartButton = $(By.xpath("//android.widget.FrameLayout[@content-desc='Добавить в корзину']/android.widget.Button"));
    SelenideElement price = $(By.id("com.asos.app:id/product_details_price_text"));

    public void clickGoToCartButton() throws InterruptedException {
        Thread.sleep(2000);
        cartProductButton.click();
    }
    public void clickAddToCart() throws InterruptedException {
        Thread.sleep(2000);
        TouchActions action = new TouchActions(driver);
        action.scroll(addToCartButton, 10, 500);
        action.perform();
        addToCartButton.click();
    }

    public int getPrice() throws InterruptedException {
        String calculatedSum;
        Thread.sleep(2000);
        calculatedSum = price.getText();
        calculatedSum = calculatedSum.replace("\r\n", "");
        calculatedSum = calculatedSum.replace(" ", "");
        return Integer.valueOf(calculatedSum.substring(0, 2));
    }
}
