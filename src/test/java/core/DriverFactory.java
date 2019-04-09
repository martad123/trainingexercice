package core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static ThreadLocal<DriverThread> driverThread;


    @BeforeClass
    public static void initialiseDriver(){
        driverThread = new ThreadLocal<DriverThread>(){
            @Override
            protected DriverThread initialValue(){
                DriverThread driverThread = new DriverThread();
                driverThread.initialiseDriver();
                return driverThread;
            }
        };
    }

    @After
    public void clearCookies(){
        driverThread.get().clearCookies();
    }

    @AfterClass
    public static void closeDriver(){
        driverThread.get().closeDriver();
    }

    public static WebDriver getDriver(){
        return driverThread.get().getDriver();
    }

    public static void openPageWithUrl (String url) {
        driverThread.get().goToUrl(url);
    }

}
