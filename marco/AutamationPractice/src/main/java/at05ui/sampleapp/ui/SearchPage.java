package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marco Mendez November 2017.
 */
public class SearchPage extends BasedPageObject {

  @FindBy(name = "Submit")
  WebElement Submit;
  @FindBy(xpath = "//div[2]/a/span")
  WebElement btnAdd;

  @FindBy(xpath = "//div[@id='layer_cart']/div/div[2]/div[4]/a/span")
  WebElement btnProcced;

  public void clickBtnAdd() {

    Submit.click();

  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }

  public void clickBtnProcced() {

    btnProcced.click();
  }
}
