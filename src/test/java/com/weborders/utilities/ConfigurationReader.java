package com.weborders.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            // location + name of the file
            String path = "configuration.properties";

            // FileInputStream --> read files in format that java understands
            FileInputStream input = new FileInputStream(path);

            // properties --> object which will contain the values from the configuration properties file
            properties = new Properties();

            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    // returns the value of property given as keyName
    // returns null if the key does not exist
    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

}