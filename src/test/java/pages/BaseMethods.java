package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class BaseMethods {

    protected WebDriver driver = BaseTest.driver;
    protected Actions actions = new Actions(driver);
    protected String firstTab = BaseTest.firstTab;
    protected ArrayList<String> newTab;

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public List<WebElement> findElements(By element) {
        return driver.findElements(element);
    }

    public void click(By element) {
        driver.findElement(element).click();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void setText(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void clickItemWithJs(By element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", findElement(element));
    }

    public WebElement getElementByIndex(By element, int index){
        List<WebElement> elements = driver.findElements(element);

        return elements.get(index);
    }

    public WebElement getListElementWithText(By element, String name){

        List<WebElement> elements = driver.findElements(element);

        for(WebElement item : elements){

            if (item.getText().contains(name)){
                return item;
            }
        }

        return null;
    }

    public void switchToOpenedTabWhenClickProductInHomePage() {
        newTab = new ArrayList<>(driver.getWindowHandles());
        newTab.remove(firstTab);
        driver.switchTo().window(newTab.get(0));
    }

    public void closeToOpenedTabAndSwitchFirstTab() {
        driver.close();
        driver.switchTo().window(firstTab);
    }
}