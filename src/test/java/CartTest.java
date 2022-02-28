import com.example.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class CartTest extends BaseTest {

    @Test
    void isItCartTest() throws InterruptedException {
        AppPage appPage = new AppPage(driver);
        appPage.initialize();
        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);
        appPage.goToCart();
        Assertions.assertTrue(appPage.isItCart());
    }

    @Test
    void emptyCartTest() throws InterruptedException {
        AppPage appPage = new AppPage(driver);
        appPage.initialize();
        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);
        appPage.goToCart();
        Assertions.assertTrue(appPage.isCartEmpty());
    }

    @Test
    void addToCartTest() throws InterruptedException, AWTException {
        AppPage appPage = new AppPage(driver);
        appPage.initialize();
        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);

        appPage.searchProduct(Constants.PRODUCTS.PRODUCT_NAME);

        appPage.clickAddToCart();
        appPage.goToCart();

        Assertions.assertTrue(appPage.isProductInCart());
    }

    @Test
    void deleteFromCartTest() throws InterruptedException, AWTException {
        AppPage appPage = new AppPage(driver);

        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);
        appPage.goToCart();

        appPage.clickDelete();
        Assertions.assertFalse(appPage.isProductInCart());
    }

    @Test
    void totalCostTest() throws InterruptedException {
        int totalPrice = 0;
        AppPage appPage = new AppPage(driver);

        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);

        totalPrice += appPage.getPrice();
        appPage.clickAddToCart();
        appPage.clickNotGoToCart();
        totalPrice += appPage.getPrice();
        appPage.clickAddToCart();
        appPage.goToCart();

        Assertions.assertEquals(totalPrice, appPage.getTotalSum());
    }

    @Test
    void amountOfProductsTest() throws InterruptedException {
        int totalAmount, productsInCart;
        AppPage appPage = new AppPage(driver);

        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);

        appPage.goToCart();

        totalAmount = appPage.amountOfProductsOnCartImage();

        productsInCart = appPage.amountOfProductsOnCartPage();
        Assertions.assertEquals(totalAmount, productsInCart);
    }

    @Test
    void addToFavoritesTest() throws InterruptedException, AWTException {
        AppPage appPage = new AppPage(driver);

        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);

        appPage.goToCart();

        appPage.clickaddToFavorites();
        Assertions.assertTrue(appPage.isProductInFavorites());
    }

    @Test
    void productInformationTest() throws InterruptedException {
        AppPage appPage = new AppPage(driver);

        appPage.signIn(Constants.CREDENTIALS.EMAIL, Constants.CREDENTIALS.PASSWORD);
        appPage.goToCart();
        Assertions.assertTrue(appPage.isAllProductInfoPresent());
    }

}
