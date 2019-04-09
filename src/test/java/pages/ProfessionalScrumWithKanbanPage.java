package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static core.DriverFactory.getDriver;

public class ProfessionalScrumWithKanbanPage {

    public ProfessionalScrumWithKanbanPage(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='PSK']")
    public WebElement pskLogo;

    @FindBy(xpath = "//span[text()='Warszawa, Nov 14-15, 2019']")
    public WebElement trainingTitleBar;

    @FindBy(xpath = "//span[text()='Warszawa, Poland']")
    public WebElement courseDetailsCity;

    @FindBy(xpath = "//div[text()='Nov 14, 2019']")
    public WebElement courseDetailsDate;


}
