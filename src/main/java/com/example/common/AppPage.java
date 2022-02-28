package com.example.common;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class AppPage {
    AppiumDriver driver;

    public AppPage(AppiumDriver driver) {
        this.driver = driver;
    }

    SelenideElement buttonWomen = $(By.xpath("//android.widget.Button[@content-desc='Кнопка Женское']"));
    SelenideElement noThanksButton = $(By.id("android:id/button2"));
    SelenideElement searchButton = $(By.xpath("//android.widget.TextView[@content-desc='Искать товары и бренды']"));
    SelenideElement sideMenu = $(By.xpath("//android.widget.ImageButton[@content-desc='Каталог']"));
    SelenideElement signInSideMenuButton = $(By.id("com.asos.app:id/navigation_drawer_sign_in"));
    SelenideElement cartSideMenuButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]"));
    SelenideElement cartProductButton = $(By.id("com.asos.app:id/bag_fab"));
    SelenideElement emailField = $(By.id("EmailAddress"));
    SelenideElement passwordField = $(By.xpath("Password"));
    SelenideElement signInButton = $(By.xpath("signin"));
    SelenideElement iAmNotRobotButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.Button"));
    SelenideElement cartToolbarTitle = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"));
    SelenideElement emptyCartImage = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView"));
    SelenideElement mainPageSideMenuButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"));
    SelenideElement searchField = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText"));
    SelenideElement productIcon = $(By.xpath("//android.widget.LinearLayout[@content-desc='Тушь для ресниц Revolution 5D Lash; 890,00 руб.']"));
    SelenideElement addToCartButton = $(By.xpath("//android.widget.FrameLayout[@content-desc='Добавить в корзину']/android.widget.Button"));
    SelenideElement name = $(By.xpath("name")).shouldHave(exactText(Constants.PRODUCTS.PRODUCT_NAME));
    SelenideElement price = $(By.id("com.asos.app:id/bag_item_price"));
    SelenideElement image = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.ImageView"));
    SelenideElement deleteButton = $(By.xpath("(//android.widget.ImageView[@content-desc='УДАЛИТЬ'])[1]"));
    SelenideElement addToFavoritesButton = $(By.id("com.asos.app:id/bag_item_move_to_saved_button"));
    SelenideElement productProperties = $(By.id("com.asos.app:id/bag_item_properties_text"));
    SelenideElement goToFavoritesButton = $(By.id("com.asos.app:id/bag_addon_items_view_saved_items"));
    SelenideElement finalCart = $(By.id("com.asos.app:id/bag_list_total_amount"));

    public void initialize() throws InterruptedException{
        Thread.sleep(2000);
        $(buttonWomen).click();
        Thread.sleep(2000);
        $(noThanksButton).click();
    }

    public void signIn(String email, String password) throws InterruptedException {
        Thread.sleep(2000);
        $(sideMenu).click();
        Thread.sleep(2000);
        $(signInSideMenuButton).click();
        Thread.sleep(2000);
        $(emailField).sendKeys(email);
        Thread.sleep(2000);
        $(passwordField).sendKeys(password);
        Thread.sleep(2000);
        $(signInButton).click();
        Thread.sleep(2000);
        if ($(iAmNotRobotButton).exists()){
            $(iAmNotRobotButton).click();
        }
        if ($(mainPageSideMenuButton).exists()){
            $(mainPageSideMenuButton).click();
        }
    }

    public void goToCart() throws InterruptedException {
        Thread.sleep(2000);
        $(sideMenu).click();
        Thread.sleep(2000);
        $(cartSideMenuButton).click();
    }

    public void clickGoToCartButton() throws InterruptedException {
        Thread.sleep(2000);
        $(cartProductButton).click();
    }

    public boolean isItCart() throws InterruptedException {
        Thread.sleep(2000);
        return $(cartToolbarTitle).exists();
    }

    public boolean isCartEmpty() throws InterruptedException {
        Thread.sleep(2000);
        return $(emptyCartImage).exists();
    }

    public void searchProduct(String query) throws InterruptedException {
        Thread.sleep(2000);
        $(searchButton).click();
        Thread.sleep(2000);
        $(searchField).setValue(query).pressEnter();
        Thread.sleep(2000);
        $(productIcon).click();
    }

    public void clickAddToCart() throws InterruptedException {
        Thread.sleep(2000);
        TouchActions action = new TouchActions(driver);
        action.scroll($(addToCartButton), 10, 500);
        action.perform();
        $(addToCartButton).click();
    }

    public int getPrice() throws InterruptedException {
        String calculatedSum;
        Thread.sleep(2000);
        calculatedSum = $(price).getText();
        calculatedSum = calculatedSum.replace("\r\n", "");
        calculatedSum = calculatedSum.replace(" ", "");
        return Integer.valueOf(calculatedSum.substring(0, 3));
    }

    public void clickDelete() throws InterruptedException {
        Thread.sleep(2000);
        $(deleteButton).click();
    }

    public void clickaddToFavorites() throws InterruptedException {
        Thread.sleep(2000);
        $(addToFavoritesButton).click();
    }

    public void goToFavorites(){
        $(goToFavoritesButton).click();
    }

    public boolean isAllProductInfoPresent() throws InterruptedException {
        Thread.sleep(2000);
        return ($(image).exists()
                && $(name).exists()
                && $(productProperties).exists()
                && $(price).exists());
    }

    public boolean isProductInCart() throws InterruptedException {
        Thread.sleep(2000);
        return $(name).exists();
    }

    public int getTotalSum() throws InterruptedException {
        String calculatedSum;
        Thread.sleep(2000);
        calculatedSum = $(finalCart).getText();
        calculatedSum = calculatedSum.replace("\r\n", "");
        calculatedSum = calculatedSum.replace(" ", "");
        return Integer.valueOf(calculatedSum.substring(0, 2));
    }

    public int amountOfProductsInCart() {
        return Integer.parseInt($(productProperties).getText().substring(41));
    }

}
