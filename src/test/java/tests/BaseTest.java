package tests;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.chaintest.service.ChainPluginService;
import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected SelfHealingDriver driver;
    WebDriver delegate;

    /**
     * Adding system info in the ChainTest local report i.e., Email.html
     */
    @BeforeSuite
    public void suiteSetup() {
        ChainPluginService.getInstance().addSystemInfo("Project Name", "Healenium_ChainTest");
        ChainPluginService.getInstance().addSystemInfo("Tester Name", "Appan Roy");
    }

    @BeforeClass
    public void setup() {
        delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) driver.quit();
        if (delegate != null) delegate.quit();
    }

    public void addStepLog(String logMessage){
        ChainTestListener.log(logMessage);
    }

    public String takeScreenshot() {
        return ((TakesScreenshot)delegate).getScreenshotAs(OutputType.BASE64);
    }

    public void attachScreenshot() {
        ChainTestListener.embed(takeScreenshot(), "image/png");
    }

}
