package courses.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oz64 on 20/11/2017.
 */
public class DashboardPage extends BasePageObject {

  @FindBy(css = "h4.course-card__title")
  private WebElement nameCourse;

  /**
   * This method get the name of the course.
   *
   * @return as a string.
   */
  public String getNameCourse() {
    return nameCourse.getText();
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
