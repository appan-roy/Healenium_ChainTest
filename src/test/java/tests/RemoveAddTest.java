package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveAddTest extends BaseTest {

    int stepNo = 1;

    @Test(priority = 1)
    public void testRemove() throws InterruptedException {
        addStepLog("Step " + stepNo + " : " + "Test remove started");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        attachScreenshot();
        Thread.sleep(5000);
        String actText = driver.findElement(By.cssSelector("p#message")).getText();
        Assert.assertEquals(actText, "It's gone!");
        stepNo++;
    }

    @Test(priority = 2)
    public void testAdd() throws InterruptedException {
        addStepLog("Step " + stepNo + " : " + "Test add started");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        attachScreenshot();
        Thread.sleep(5000);
        String actText = driver.findElement(By.cssSelector("p#message")).getText();
        Assert.assertEquals(actText, "It's back!");
        stepNo++;
    }

}
