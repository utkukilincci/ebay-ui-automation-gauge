package pages;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static constans.Keywords.*;
import static java.lang.Integer.parseInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HomePage extends BaseMethods {

    private final By CATEGORIES = By.className("hl-cat-nav__js-tab");
    private final By SUB_CATEGORIES = By.className("hl-cat-nav__js-link");
    private final By MINI_CART = By.id("gh-minicart-hover");
    private final By MINI_CART_TITLE = By.className("gh-minicart-header__title");
    private final By PRODUCTS = By.className("s-item");
    private final By WATCHLIST_MENU = By.className("watchlist-menu");
    private final By WATCHLIST_TEXT = By.cssSelector("#gh-wl-click-body .rvi .rvi__title");
    private final By WATCH_HEART_BUTTON = By.className("s-item__watchheart-click");
    private final By WATCHLIST_PAGE = By.cssSelector(".rvi__title > a");

    @Step("Go to login page")
    public void goToLoginPage() {
        navigateToUrl(SIGN_IN_PAGE);
    }

    @Step("Check the mini cart is empty")
    public void checkMiniCartIsEmpty() {
        WebElement element = findElement(MINI_CART);

        moveToElement(element);

        String actualMiniCartTitle = getText(MINI_CART_TITLE);

        assertThat(
                "When mini cart is empty, title is should be ",
                actualMiniCartTitle,
                is(EMPTY_MINI_CART_TITLE)
        );
    }

    @Step("Check the watchlist is empty")
    public void checkWatchlistIsEmpty() {
        click(WATCHLIST_MENU);

        String actualWatchlistTitle = getText(WATCHLIST_TEXT);

        assertThat(
                "When mini cart is empty, title is should be ",
                actualWatchlistTitle,
                is(EMPTY_WATCHLIST_TEXT)
        );
    }

    @Step("Go to <subCategory> in <category> category")
    public void hoverToCategory(String subCategory, String category){
        WebElement element = getListElementWithText(CATEGORIES, category);

        moveToElement(element);

        click(getListElementWithText(SUB_CATEGORIES, subCategory));
    }

    @Step("Add <count> product to cart")
    public void addProductToCartWithCount(String count) {
        for (int i = 0; i < parseInt(count); i++) {
            addProductToCart(getElementByIndex(PRODUCTS, i));
        }
    }

    @Step("Go to cart page")
    public void goToCartPage() {
        click(MINI_CART);
    }

    @Step("Add <count> product to watchlist")
    public void addProductToWatchListWithCount(String count) {
        for (int i = 0; i < parseInt(count); i++) {
            click(getElementByIndex(WATCH_HEART_BUTTON, i));
        }
    }

    @Step("Go to watchlist page")
    public void goToWatchlistPage() {
        click(WATCHLIST_PAGE);
    }

    private void addProductToCart(WebElement element) {
        ProductDetailPage productDetailPage = new ProductDetailPage();

        click(element);
        switchToOpenedTabWhenClickProductInHomePage();
        productDetailPage.clickAddCart();
        closeToOpenedTabAndSwitchFirstTab();
    }

}
