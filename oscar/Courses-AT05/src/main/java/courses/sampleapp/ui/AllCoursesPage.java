package courses.sampleapp.ui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 11/21/2017.
 */
public class AllCoursesPage extends BasePageObject {

  @FindBy(name = "q")
  WebElement searchTextBox;

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {
  }

  public SearchPage searchCourse(String nameCourse) {
    searchTextBox.sendKeys(nameCourse);
    searchTextBox.sendKeys(Keys.ENTER);
    return new SearchPage();
  }
}
