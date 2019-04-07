import core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Comarch on 2017-04-24.
 */
public class MySecondTest extends DriverFactory {

    @Test
    public void firstTest() {

        String url = "http://automationpractice.com";
        driverThread.get().goToUrl(url);

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h5/a[@class='product-name']")));
        //driver.findElement(By.xpath("//div/h5/a[@class='product-name']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h5/a[@class='product-name']")));
        WebElement container = getDriver().findElement(By.className("ajax_block_product"));
        container.findElement(By.className("product-name")).click();

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/p/button[@class='exclusive']")));
        //driver.findElement(By.xpath("//div/div/p/button[@class='exclusive']")).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2/i[@class='icon-ok']")));

        try{
            Thread.sleep(2000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        getDriver().findElement(By.id("add_to_cart")).click();
        // String title = driver.findElement(By.xpath("//div[@id='layer_cart']/div/div/h2")).getText();

        try{
            Thread.sleep(2000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        //Assert.assertTrue(title.equals("Product successfully added to your shopping cart"));
        WebElement popup = getDriver().findElement(By.className("layer_cart_product"));
        String title = "Product successfully added to your shopping cart";
        Assert.assertEquals(title, popup.findElement(By.tagName("h2")).getText());

    }
}
