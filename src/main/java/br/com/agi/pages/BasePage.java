
package br.com.agi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver d){
        this.driver=d;
        this.wait=new WebDriverWait(d, Duration.ofSeconds(20));
    }
}
