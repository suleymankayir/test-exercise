package base;

import com.kayir.base.BasePage;
import com.kayir.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static utilities.Utility.setUtilityDriver;

public class BaseTest {

    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private String AE_URL = "https://automationexercise.com/";
    String downloadPath = "/Users/suleymankayir/Documents/TestDownload";

    @BeforeClass
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("prefs", java.util.Map.of(
                "download.default_directory", downloadPath,
                "download.prompt_for_download", false,
                "download.directory_upgrade", true,
                "safebrowsing.enabled", true
        ));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication(){
        driver.get(AE_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
