package courses.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 11/21/2017.
 */
public class SearchPage extends BasePageObject {

  //@FindBy(css = "css=h4.course-card__title")
  @FindBy(xpath = "//div[2]/div/h4")
  WebElement nameCourse;

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {
  }

  /**
   * This method return the name of the course.
   *
   * @return as a string.
   */
  public String getNameCourse() {
    return nameCourse.getText();
  }
}
