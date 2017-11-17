package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;

/**
 * Created by Administrator on 11/17/2017.
 */
public class InboxPage extends BasedPageObject{
  public boolean isInboxPage() {
    return true;
  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }
}
