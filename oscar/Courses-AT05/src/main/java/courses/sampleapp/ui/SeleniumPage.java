package courses.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oz64 on 20/11/2017.
 */
public class SeleniumPage extends BasePageObject {

  @FindBy(linkText = "Enroll for free")
  WebElement btnEnrroll;

  public SeleniumCourse enrrollSeleniumCourse(){
    btnEnrroll.click();
    return new SeleniumCourse();
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
