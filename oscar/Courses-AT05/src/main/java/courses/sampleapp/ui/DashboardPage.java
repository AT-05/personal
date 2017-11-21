package courses.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oz64 on 20/11/2017.
 */
public class DashboardPage extends BasePageObject {

  @FindBy(css = "h4.course-card__title")
  WebElement nameCourse;

  public String getNameCourse(){
    return nameCourse.getText();
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
