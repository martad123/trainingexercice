import core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AndyBrandtPage;
import pages.ProfessionalScrumWithKanbanPage;


public class SecondExercice extends DriverFactory {

    @Test
    public void firstTest() {

        String url = "https://www.scrum.org/andy-brandt";
        openPageWithUrl(url);

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        AndyBrandtPage andyBrandtPage = new AndyBrandtPage();
        wait.until(ExpectedConditions.visibilityOf(andyBrandtPage.scrumLogo));

        final String coursesList = andyBrandtPage.coursesList.getText();
        Assert.assertEquals("no such courses list exists", "Upcoming Courses Taught by Andy Brandt", coursesList );

        final WebElement scrumWithKanbanTraining = andyBrandtPage.scrumWithKanbanTraining;
        Assert.assertEquals("no such training exists", "Professional Scrum with Kanban", scrumWithKanbanTraining.getText());

        String trainingUrl = scrumWithKanbanTraining.getAttribute("href");
        Assert.assertTrue("different date", trainingUrl.contains("2019-11-14"));
        Assert.assertTrue("different city", trainingUrl.contains("warszawa"));

        scrumWithKanbanTraining.sendKeys(Keys.ENTER);

        ProfessionalScrumWithKanbanPage professionalScrumWithKanbanPage = new ProfessionalScrumWithKanbanPage();
        wait.until(ExpectedConditions.visibilityOf(professionalScrumWithKanbanPage.pskLogo));

        final String trainingTitleBar = professionalScrumWithKanbanPage.trainingTitleBar.getText();
        final String courseDetailsDate = professionalScrumWithKanbanPage.courseDetailsDate.getText();
        final String courseDetailsCity = professionalScrumWithKanbanPage.courseDetailsCity.getText();

        Assert.assertTrue("different date in training bar", trainingTitleBar.toUpperCase().contains("NOV 14-15") );
        Assert.assertTrue("different city in training bar", trainingTitleBar.toUpperCase().contains("WARSZAWA")  );
        Assert.assertTrue("different date in course details", courseDetailsDate.toUpperCase().contains("NOV 14") );
        Assert.assertTrue("different city in course details", courseDetailsCity.toUpperCase().contains("WARSZAWA") );

    }
}
