package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;

public class IdentifyPage extends BasedPageObject {

  public boolean IAmInIdentifyPage() {
    return webDriver.getTitle().trim().equalsIgnoreCase("Identity - My Store");
  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }
}
