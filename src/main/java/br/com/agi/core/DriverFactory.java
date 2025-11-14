
package br.com.agi.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if(DRIVER.get()==null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);
            DRIVER.set(new ChromeDriver(options));
        }
        return DRIVER.get();
    }

    public static void quitDriver(){
        if(DRIVER.get()!=null){
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
