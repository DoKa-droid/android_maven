package com.example.common;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    AppiumDriver driver;

    public SearchResultPage(AppiumDriver driver) {
        this.driver = driver;
    }

    SelenideElement searchField = $(By.id("com.asos.app:id/search_edit_text"));
    SelenideElement productIcon = $(By.xpath("//android.widget.LinearLayout[@content-desc='Тушь для ресниц Revolution 5D Lash; 690,00 руб. снижена с 890,00 руб. (-22%)']"));
    SelenideElement searchButton = $(By.xpath("//android.widget.TextView[@content-desc='Искать товары и бренды']"));

    public void searchProduct(String query) throws InterruptedException {
        Thread.sleep(2000);
        searchButton.click();
        Thread.sleep(2000);
        searchField.setValue(query).pressEnter();
        Thread.sleep(2000);
        productIcon.click();
    }
}
