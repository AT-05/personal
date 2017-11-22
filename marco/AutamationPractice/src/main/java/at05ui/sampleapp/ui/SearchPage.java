package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasedPageObject {

  @FindBy(name = "Submit")
  WebElement Submit;
  @FindBy(xpath = "//div[2]/a/span")
  WebElement btnAdd;

  @FindBy(xpath = "//div[@id='layer_cart']/div/div[2]/div[4]/a/span")
  WebElement btnProcced;

  public void clickBtnAdd() {
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Submit.click();

  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }

  public void clickBtnProcced() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    btnProcced.click();
  }
}
