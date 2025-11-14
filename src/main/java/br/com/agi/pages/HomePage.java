package br.com.agi.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver d){
        super(d);
    }

    public HomePage open(){
        driver.get("https://blogdoagi.com.br/");
        return this;
    }

    public SearchResultsPage searchFor(String term){
        String url = "https://blogdoagi.com.br/?s=" + term;
        driver.get(url);
        return new SearchResultsPage(driver);
    }
}


