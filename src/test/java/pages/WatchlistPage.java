package pages;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WatchlistPage extends BaseMethods {

    private final By WATCHLIST_ITEMS = By.className("m-item");
    private final By BULK_CHECK_FOR_ITEMS = By.className("bulkCheck");
    private final By WATCHLIST_DELETE_BUTTON = By.cssSelector(".m-cta .btn--delete");

    @Step("Check there are <count> items in the watchlist")
    public void checkTheWatchlistHasItemsWithCount(String count) {
        List<WebElement> productListInWatchlist = findElements(WATCHLIST_ITEMS);

        assertThat(
                "When user add product to watchlist, should be able to see in watchlist  ",
                productListInWatchlist.size(),
                is(parseInt(count))
        );
    }

    @Step("Clear watchlist")
    public void clearWatchList() {
        click(BULK_CHECK_FOR_ITEMS);
        click(WATCHLIST_DELETE_BUTTON);
    }
}