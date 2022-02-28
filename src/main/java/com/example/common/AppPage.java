package com.example.common;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.awt.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AppPage {
    AppiumDriver driver;

    public AppPage(AppiumDriver driver) {
        this.driver = driver;
    }

    By buttonWomen = By.xpath("//android.widget.Button[@content-desc='Кнопка Женское']");
    By noThanksButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");
    By searchButton = By.xpath("//android.widget.TextView[@content-desc='Искать товары и бренды']");
    By sideMenu = By.xpath("//android.widget.ImageButton[@content-desc='Каталог']");
    By signInSideMenuButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[2]");
    By cartSideMenuButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]");
    By emailField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText");
    By passwordField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[3]/android.view.View[2]/android.widget.EditText");
    By signInButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.Button");
    By iAmNotRobotButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.Button");
    By cartToolbarTitle = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView");
    By emptyCartImage = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView");
    By mainPageSideMenuButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
    By searchField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText");
    By productIcon = By.xpath("//android.widget.LinearLayout[@content-desc='Тушь для ресниц Revolution 5D Lash; 890,00 руб.']");
    By addToCartButton = By.xpath("//android.widget.FrameLayout[@content-desc='Добавить в корзину']/android.widget.Button");
    By notGoToCartButton;
    SelenideElement name = $(By.xpath("name")).shouldHave(text(Constants.PRODUCTS.PRODUCT_NAME));
    By price;
    By image;
    By deleteButton;
    By addToFavoritesButton;
    By amountOfProduct;
    By addedToFavorites;
    By finalCart;

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

    public boolean isItCart() throws InterruptedException {
        Thread.sleep(2000);
        return $(cartToolbarTitle).exists();
    }

    public boolean isCartEmpty() throws InterruptedException {
        Thread.sleep(2000);
        return $(emptyCartImage).exists();
    }

    public void searchProduct(String query) throws InterruptedException, AWTException {
        $(searchButton).click();
        $(searchField).sendKeys(query);
        Robot robot = new Robot();
        robot.keyPress(66);
        $(productIcon).click();
    }

   public void clickAddToCart() throws InterruptedException {
        Thread.sleep(4000);
        TouchActions action = new TouchActions(driver);
        action.scroll($(addToCartButton), 10, 500);
        $(addToCartButton).click();
        action.perform();
    }

    public void clickNotGoToCart() throws InterruptedException {
        Thread.sleep(4000);
        $(notGoToCartButton).click();
    }

    public int getPrice() throws InterruptedException {
        String calculatedSum;
        Thread.sleep(4000);
        calculatedSum = $(price).getText();
        calculatedSum = calculatedSum.replace("\r\n", "");
        calculatedSum = calculatedSum.replace(" ", "");
        return Integer.valueOf(calculatedSum.substring(0, 3));
    }

    public void clickDelete() throws InterruptedException, AWTException {
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.mouseMove(200, 220);
        Thread.sleep(1000);
        $(deleteButton).click();
    }

    public void clickaddToFavorites() throws InterruptedException, AWTException {
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.mouseMove(200, 220);
        Thread.sleep(1000);
        $(addToFavoritesButton).click();
    }


    public boolean isAllProductInfoPresent() throws InterruptedException {
        Thread.sleep(2000);
        return ($(image).exists()
                && $(name).exists()
                && $(amountOfProduct).exists()
                && $(price).exists());
    }

    public boolean isProductInCart() throws InterruptedException {
        Thread.sleep(2000);
        return $(name).exists();
    }

    public boolean isProductInFavorites() {
        return $(addedToFavorites).exists();
    }

    public int getTotalSum() throws InterruptedException {
        String calculatedSum;
        Thread.sleep(4000);
        calculatedSum = $(finalCart).getText();
        calculatedSum = calculatedSum.replace("\r\n", "");
        calculatedSum = calculatedSum.replace(" ", "");
        return Integer.valueOf(calculatedSum.substring(20, 23));
    }

    public int amountOfProductsOnCartImage() {
        return Integer.parseInt($(cartToolbarTitle).getText().substring(0, 1));
    }

    public int amountOfProductsOnCartPage() {
        return Integer.parseInt($(amountOfProduct).getText().substring(0, 1));
    }

}
