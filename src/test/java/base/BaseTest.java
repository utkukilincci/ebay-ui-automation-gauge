package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import static base.BrowserFactory.getChromeOptions;
import static base.BrowserFactory.getFirefoxOptions;
import static base.Config.BROWSER_NAME;
import static base.Config.URL;
import static java.time.Duration.ofSeconds;

public class BaseTest {
    public static WebDriver driver;
    public static String firstTab;
    private ChromeOptions chromeOptions;
    private FirefoxOptions firefoxOptions;


    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeScenario
    public void setupScenario() {
        chromeOptions = getChromeOptions();
        firefoxOptions = getFirefoxOptions();

        switch (BROWSER_NAME) {
            case "CHROME":
            default:
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "SAFARI":
                driver = new SafariDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(URL);
        firstTab = driver.getWindowHandle();
    }

    @AfterScenario
    public void afterScenario() {
        driver.quit();
    }
}