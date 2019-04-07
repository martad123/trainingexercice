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

        String url = "https://www.scrum.org/andy-brandt";
        driverThread.get().goToUrl(url);

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Scrum.org_Logos")));
        //WebElement container = getDriver().findElement(By.className("ajax_block_product"));
        //container.findElement(By.className("product-name")).click();

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/p/button[@class='exclusive']")));
        //driver.findElement(By.xpath("//div/div/p/button[@class='exclusive']")).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2/i[@class='icon-ok']")));

        try{
            Thread.sleep(2000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }



        WebElement trainings = getDriver().findElement(By.xpath("//h2[text()='Upcoming Courses Taught by Andy Brandt']"));
        String title = "Upcoming Courses Taught by Andy Brandt";
        Assert.assertEquals(title, trainings.getText());
        WebElement training = getDriver().findElement(By.xpath("//a[contains(@href,'2019-11-14')][text()='Professional Scrum with Kanban']"));
        String trainingTitle = "Professional Scrum with Kanban";
        Assert.assertEquals(trainingTitle, training.getText());

        training.click();


    }
}
