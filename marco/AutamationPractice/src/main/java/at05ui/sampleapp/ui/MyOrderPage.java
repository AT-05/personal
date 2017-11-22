package at05ui.sampleapp.ui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyOrderPage extends BasedPageObject {

  @FindBy(id = "search_query_top")
  WebElement txtSearch;

  public SearchPage searchProduct(String product) {
    txtSearch.clear();
    txtSearch.sendKeys(product);
    txtSearch.sendKeys(Keys.ENTER);
    return new SearchPage();
  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }
}
