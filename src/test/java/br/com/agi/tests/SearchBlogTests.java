
package br.com.agi.tests;

import br.com.agi.pages.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchBlogTests extends BaseTest {

    @Test
public void testSearchLoan() {
    HomePage home = new HomePage(driver);
    home.open();
    SearchResultsPage results = home.searchFor("empréstimo");
    assertTrue(results.hasAnyResult());
}

@Test
public void testSearchRandom() {
    HomePage home = new HomePage(driver);
    home.open();
    SearchResultsPage results = home.searchFor("renda");
    assertTrue(results.hasAnyResult());
}



}
