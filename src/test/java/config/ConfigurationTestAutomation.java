package config;

import lombok.Getter;
import lombok.extern.java.Log;
import utils.logincroupier.LoginCroupier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Log
public class ConfigurationTestAutomation {

    @Getter
    private String chromeDriverPath;
    @Getter
    private String url;
    @Getter
    private List<LoginCroupier> listOfCredentials = new ArrayList<>();
    @Getter
    private List<String> chromeDriverArguments;

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static Properties readPropertiesFile() throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("../config.properties"));
        } catch (FileNotFoundException e)
        {
            properties.load(new FileInputStream("config.properties"));
        }
        return properties;
    }

    public ConfigurationTestAutomation() {
        final Properties properties;
        try {
            properties = readPropertiesFile();
            readWebDriverProperties(properties);
            readCredentialsProperties(properties);
        } catch (IOException e) {
            log.throwing(ConfigurationTestAutomation.class.getName(), ConfigurationTestAutomation.class.getName(), e);
            e.printStackTrace();
        }
    }

    private void readWebDriverProperties(Properties properties) {
        chromeDriverPath = properties.getProperty("webdriver.chrome.driver");
        url = properties.getProperty("webdriver.base.url");
        readChromeDriverArguments(properties);
    }

    private void readCredentialsProperties(Properties properties) {
        final List<String> stringPropertyNames = properties.stringPropertyNames().stream()
                .filter(property -> property.startsWith("users"))
                .collect(Collectors.toList());
        for (int i = 1; i <= stringPropertyNames.size()/2; i++) {
            String loginPropertyName =  "users.login." + i;
            String passwordPropertyName =  "users.pass." + i;
            listOfCredentials.add(new LoginCroupier(properties.getProperty(loginPropertyName), properties.getProperty(passwordPropertyName)));
        }
    }

    private void readChromeDriverArguments(Properties properties) {
        final String property = properties.getProperty("chromedriver.arguments");
        final String[] split = property.split(";");
        chromeDriverArguments = Arrays.asList(split);
    }
}
