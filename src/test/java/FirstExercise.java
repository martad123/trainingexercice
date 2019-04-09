import core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GoogleHomePage;
import pages.GoogleSearchResultsPage;


public class FirstExercise extends DriverFactory {

    @Test
    public void firstTest() {

        String url = "https://www.google.com";
        openPageWithUrl(url);

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        GoogleHomePage googleHomePage = new GoogleHomePage();
        wait.until(ExpectedConditions.visibilityOf(googleHomePage.searchInput));
        googleHomePage.searchInput.sendKeys("microsoft.com");
        googleHomePage.searchInput.sendKeys(Keys.ENTER);


        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage();
        wait.until(ExpectedConditions.visibilityOf(googleSearchResultsPage.searchInResults));
        googleSearchResultsPage.searchInResults.sendKeys("surface");
        googleSearchResultsPage.searchInResults.sendKeys(Keys.ENTER);

        final String value = googleSearchResultsPage.searchInput.getAttribute("value");
        Assert.assertEquals("no such value exists", "surface site:microsoft.com", value );

        final String link = googleSearchResultsPage.urlField.getText();
        Assert.assertEquals("url is different", "https://www.microsoft.com/pl-pl/surface", link );

    }
}
