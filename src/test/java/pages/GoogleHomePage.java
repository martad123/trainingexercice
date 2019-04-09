package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static core.DriverFactory.getDriver;

public class GoogleHomePage {

    public GoogleHomePage(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@role = 'combobox']")
    public WebElement searchInput;

}
