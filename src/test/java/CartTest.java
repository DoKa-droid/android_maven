import com.example.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class CartTest extends BaseTest {

    @Test
    void isItCartTest() throws InterruptedException {
        AppPage appPage = new AppPage(driver);
        CartPage cartPage = new CartPage(driver);
        appPage.initialize();
        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);
        appPage.goToCart();
        Assertions.assertTrue(cartPage.isItCart());
    }

    @Test
    void emptyCartTest() throws InterruptedException {
        AppPage appPage = new AppPage(driver);
        CartPage cartPage = new CartPage(driver);
        appPage.initialize();
        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);
        appPage.goToCart();
        Assertions.assertTrue(cartPage.isCartEmpty());
    }

    @Test
    void addToCartTest() throws InterruptedException {
        AppPage appPage = new AppPage(driver);
        CartPage cartPage = new CartPage(driver);
        SearchResultPage searchPage = new SearchResultPage(driver);
        ProductPage productPage = new ProductPage(driver);
        appPage.initialize();
        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);

        searchPage.searchProduct(Constants.PRODUCTS.PRODUCT_NAME);

        productPage.clickAddToCart();
        productPage.clickGoToCartButton();

        Assertions.assertTrue(cartPage.isProductInCart());
    }

    @Test
    void deleteFromCartTest() throws InterruptedException {
        AppPage appPage = new AppPage(driver);
        CartPage cartPage = new CartPage(driver);

        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);
        appPage.goToCart();

        cartPage.clickDelete();
        Assertions.assertFalse(cartPage.isCartEmpty());
    }

    @Test
    void totalCostTest() throws InterruptedException {
        int totalPrice = 0;
        AppPage appPage = new AppPage(driver);
        CartPage cartPage = new CartPage(driver);
        SearchResultPage searchPage = new SearchResultPage(driver);
        ProductPage productPage = new ProductPage(driver);

        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);

        searchPage.searchProduct(Constants.PRODUCTS.PRODUCT_NAME);
        totalPrice += productPage.getPrice();
        productPage.clickAddToCart();
        totalPrice += productPage.getPrice();
        productPage.clickAddToCart();
        productPage.clickGoToCartButton();

        Assertions.assertEquals(totalPrice, cartPage.getTotalSum());
    }

    @Test
    void amountOfProductsTest() throws InterruptedException {
        int totalAmount, productsInCart;
        AppPage appPage = new AppPage(driver);
        CartPage cartPage = new CartPage(driver);

        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);

        appPage.goToCart();
        totalAmount = 2;
        productsInCart = cartPage.amountOfProductsInCart();
        Assertions.assertEquals(totalAmount, productsInCart);
    }

    @Test
    void addToFavoritesTest() throws InterruptedException {
        AppPage appPage = new AppPage(driver);
        CartPage cartPage = new CartPage(driver);

        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);
        appPage.goToCart();
        cartPage.clickaddToFavorites();
        cartPage.goToFavorites();
        Assertions.assertTrue(cartPage.isProductInCart());
    }

    @Test
    void productInformationTest() throws InterruptedException {
        AppPage appPage = new AppPage(driver);
        CartPage cartPage = new CartPage(driver);

        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);
        appPage.goToCart();
        Assertions.assertTrue(cartPage.isAllProductInfoPresent());
    }

}
