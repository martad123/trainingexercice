package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static core.DriverFactory.getDriver;

public class AndyBrandtPage {
    public AndyBrandtPage(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "Scrum.org_Logos")
    public WebElement scrumLogo;

    @FindBy(xpath = "//h2[text()='Upcoming Courses Taught by Andy Brandt']")
    public WebElement coursesList;

    @FindBy(linkText = "Professional Scrum with Kanban" )
    public WebElement scrumWithKanbanTraining;

}
