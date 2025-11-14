package br.com.agi.pages;

import org.openqa.selenium.*;
import java.util.List;

public class SearchResultsPage extends BasePage {

    private final By articles = By.cssSelector("article");

    public SearchResultsPage(WebDriver d){
        super(d);
    }

    public boolean hasAnyResult(){
        List<WebElement> list = driver.findElements(articles);
        return list.size() > 0;
    }

    public boolean isSearchPageLoaded() {
        String url = driver.getCurrentUrl().toLowerCase();
        return url.contains("?s=") || url.contains("/search/");
    }
}

