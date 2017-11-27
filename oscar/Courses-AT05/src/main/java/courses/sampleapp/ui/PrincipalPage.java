package courses.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 11/17/2017.
 */
public class PrincipalPage extends BasePageObject {

  @FindBy(css = "a.my-account")
  WebElement btnSignIn;

  @FindBy(xpath = "//a[contains(text(),'All Courses')]")
  WebElement btnAllCourses;

  /**
   * Constructor
   */
  public PrincipalPage() {
    super();
  }

  /**
   * This method made a click in SignIn button.
   *
   * @return LoginPage.
   */
  public LoginPage goToLoginPage() {
    return clickSingInButton();
  }

  /**
   * Made a click over the button sing in.
   *
   * @return LoginPage.
   */
  private LoginPage clickSingInButton() {
    btnSignIn.click();
    return new LoginPage();
  }

  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }

  /**
   * This method go to All Courses page.
   *
   * @return AllCoursesPage.
   */
  public AllCoursesPage goToAllCoursesPage() {
    return clickAllCoursesBtn();
  }

  /**
   * Made a click over the button all courses.
   *
   * @return AllCouresPAge.
   */
  private AllCoursesPage clickAllCoursesBtn() {
    btnAllCourses.click();
    return new AllCoursesPage();
  }
}
