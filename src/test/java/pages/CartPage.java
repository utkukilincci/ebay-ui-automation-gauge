package pages;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CartPage extends BaseMethods {

    private final By CART_ITEMS = By.className("cart-bucket");
    private final By REMOVE_ITEM_BUTTON = By.cssSelector("[data-test-id='cart-remove-item']");

    @Step("Check there are <count> items in the cart")
    public void checkTheCartHasItemsWithCount(String count) {
        List<WebElement> productListInCart = findElements(CART_ITEMS);

        assertThat(
                "When user add product to cart, should be able to see in cart  ",
                productListInCart.size(),
                is(parseInt(count))
        );
    }

    @Step("Remove an item in cart")
    public void removeAnItemInCart() throws InterruptedException {
        clickItemWithJs(REMOVE_ITEM_BUTTON);
        Thread.sleep(250);
    }
}
