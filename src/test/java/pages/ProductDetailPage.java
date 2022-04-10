package pages;

import org.openqa.selenium.By;

public class ProductDetailPage extends BaseMethods {

    private final By ADD_CART_BUTTON = By.id("isCartBtn_btn");

    public void clickAddCart() {
        click(ADD_CART_BUTTON);
    }
}
