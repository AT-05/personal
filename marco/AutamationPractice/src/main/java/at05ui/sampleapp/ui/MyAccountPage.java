package at05ui.sampleapp.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Marco Mendez November 2017.
 */
public class MyAccountPage extends BasedPageObject {

  public static final String TITLE_PAGE = "My account - My Store";
  @FindBy(className = "logout")
  private WebElement logOut;

  @FindBy(linkText = "My personal info")
  private WebElement editPersonalInfo;

  @FindBy(linkText = "My addresses")
  private WebElement myAddress;

  /**
   * Event click LogOut.
   */
  public void clickLogOut() {
    logOut.click();
  }

  /**
   * Check if I am in MyAccountPage.
   *
   * @return boolean.
   */
  public boolean IAmMyAccount() {
    //this a small trap
    return webDriver.getTitle().equalsIgnoreCase(TITLE_PAGE);


  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }

  /**
   * Event click EditPersonalInfo.
   *
   * @return new EditPersonalInfoPage.
   */
  public EditPersonalInfoPage clickEditPersonalInfo() {
    editPersonalInfo.click();
    return new EditPersonalInfoPage();
  }

  /**
   * This method goes to My address page.
   *
   * @return New MAddressPage.
   */
  public MyAddressPage goToMyAddress() {
    myAddress.click();
    return new MyAddressPage();
  }


}
