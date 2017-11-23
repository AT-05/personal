package courses.sampleapp.ui;

import courses.sampleapp.entities.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 11/15/2017.
 */
public class HomePage extends BasePageObject {

  @FindBy(id = "my_account")
  private WebElement nameProfile;

  @FindBy(linkText = "Sign Out")
  private WebElement signout;

  @FindBy(linkText = "My Dashboard")
  WebElement title;

  private WebElement webElement;

  /**
   * Constructor.
   */
  public HomePage() {
    super();
  }

  /**
   * Verify is in the home page.
   * @param user as a object.
   * @return boolean.
   */
  /*public boolean isInTheHomePage(User user) {
    String name = String.format("%s %s", user.getFirstName(), user.getLastName().substring(0,1));
    if(nameProfile.getText().equalsIgnoreCase(name)){
      return true;
    }
    return false;
  }*/

  public boolean isInTheHomePage() {
    if (title.getText().equalsIgnoreCase("My Dashboard")) {
      return true;
    }
    return false;
  }

  /**
   * Logout of the account.
   */
  public void logout() {
    nameProfile.click();
    signout.click();
  }

  /**
   * Select Selenium course.
   *
   * @return SeleniumPage.
   * @param nameCourse as a string.
   */
  public SeleniumPage clickSeleniumCourse(String nameCourse) {
    String cad = String.format("//h4[text()[contains(.,\"%s\")]]", nameCourse);
    webElement = driver.findElement(By.xpath(cad));
    webElement.click();
    return new SeleniumPage();
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
