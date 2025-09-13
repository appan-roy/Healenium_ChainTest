package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableDisableTest extends BaseTest {

    int stepNo = 1;

    @Test(priority = 1)
    public void testEnable() throws InterruptedException {
        addStepLog("Step " + stepNo + " : " + "Test enable started");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        attachScreenshot();
        Thread.sleep(5000);
        String actText = driver.findElement(By.cssSelector("p#message")).getText();
        Assert.assertEquals(actText, "It's enabled!");
        stepNo++;
    }

    @Test(priority = 2)
    public void testDisable() throws InterruptedException {
        addStepLog("Step " + stepNo + " : " + "Test disable started");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        attachScreenshot();
        Thread.sleep(5000);
        String actText = driver.findElement(By.cssSelector("p#message")).getText();
        Assert.assertEquals(actText, "It's disabled!");
        stepNo++;
    }

}
