package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static core.DriverFactory.getDriver;

public class GoogleSearchResultsPage {


    public GoogleSearchResultsPage(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "nqsbq")
    public WebElement searchInResults;

    @FindBy(xpath = "//input[@role = 'combobox']")
    public WebElement searchInput;

    @FindBy(xpath = "//cite")
    public WebElement urlField;

}
