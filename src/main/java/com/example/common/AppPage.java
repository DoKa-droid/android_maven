package com.example.common;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AppPage {
    AppiumDriver driver;

    public AppPage(AppiumDriver driver) {
        this.driver = driver;
    }

    SelenideElement buttonWomen = $(By.xpath("//android.widget.Button[@content-desc='Кнопка Женское']"));
    SelenideElement noThanksButton = $(By.id("android:id/button2"));
    SelenideElement sideMenu = $(By.xpath("//android.widget.ImageButton[@content-desc='Каталог']"));
    SelenideElement signInSideMenuButton = $(By.id("com.asos.app:id/navigation_drawer_sign_in"));
    SelenideElement cartSideMenuButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]"));
    SelenideElement emailField = $(By.id("EmailAddress"));
    SelenideElement passwordField = $(By.id("Password"));
    SelenideElement signInButton = $(By.id("signin"));
    SelenideElement iAmNotRobotButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.widget.Button"));
    SelenideElement sideMenuMainPageButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"));

    public void initialize() throws InterruptedException {
        Thread.sleep(2000);
        buttonWomen.click();
        Thread.sleep(2000);
        noThanksButton.click();
    }

    public void signIn(String email, String password) throws InterruptedException {
        Thread.sleep(2000);
        sideMenu.click();
        Thread.sleep(2000);
        signInSideMenuButton.click();
        Thread.sleep(2000);
        emailField.sendKeys(email);
        Thread.sleep(2000);
        passwordField.sendKeys(password);
        Thread.sleep(2000);
        signInButton.click();
        Thread.sleep(2000);
        if (iAmNotRobotButton.exists()) {
            iAmNotRobotButton.click();
        }
        if (sideMenuMainPageButton.exists()) {
            sideMenuMainPageButton.click();
        }
    }

    public void goToCart() throws InterruptedException {
        Thread.sleep(2000);
        sideMenu.click();
        Thread.sleep(2000);
        cartSideMenuButton.click();
    }
}
