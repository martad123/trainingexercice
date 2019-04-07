package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Comarch on 2017-04-24.
 */
public class DriverThread {

    public WebDriver driver;

    // będziemy ustawiać w POMie, czy będziemy odpalać na grid'zie, czy lokalnie
    public boolean remote = Boolean.getBoolean("remote");


    public void initialiseDriver() {

        BrowserTypes type = determineDriverType();
        if (!remote) {
            startDriveLoocally(type);
        } else {
            startDriverRemotely(type);
        }
        determineDriverType();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void goToUrl(String url) {
        driver.get(url);
    }


    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    public void closeDriver() {
        driver.close();
    }

    private BrowserTypes determineDriverType() {

        BrowserTypes type = BrowserTypes.CHROME;
        try {
            type = BrowserTypes.valueOf(System.getProperty("browser.type").toUpperCase());
        } catch (Exception e) {
            System.out.println("Not recognize browser: please use chrome or firefox");
        }
        return type;
    }

    private void startDriveLoocally(BrowserTypes type) {
        switch (type){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:/Sources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Comarch\\Desktop\\IntelliJ\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.print("Browser type not supported");
                System.setProperty("webdriver.chrome.driver", "C:/Sources/chromedriver.exe");
                //driver = new ChromeDriver();
        }
    }

    private void startDriverRemotely(BrowserTypes type){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        switch (type){
            case CHROME:
                capabilities = DesiredCapabilities.chrome();
                break;
            case FIREFOX:
                capabilities = DesiredCapabilities.firefox();
                break;
            default:
                capabilities = DesiredCapabilities.chrome();
        }

        // do obsłużenia wyjątku, gdy nie ma podanego adresu serwera
        try {
            driver = new RemoteWebDriver(new URL(System.getProperty("grid.url")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
