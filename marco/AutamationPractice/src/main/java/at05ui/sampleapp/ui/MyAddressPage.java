package at05ui.sampleapp.ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Marco Mendez November 2017.
 */
public class MyAddressPage extends BasedPageObject {

  @FindBy(xpath = "//div[@id='center_column']/div/a/span")
  private WebElement btnAddNewAddress;

  @FindBy(xpath = "//div[@id='center_column']/div/div/div/ul/li[9]/a[2]/span")
  private WebElement delete;

  @FindBy(className = "logout")
  private WebElement logOut;

  private boolean deleteAddress;

  /**
   * This method return AddNewAddress.
   *
   * @return new AddNewAddress.
   */
  public AddNewAddressPage goToAddNewAddress() {
    btnAddNewAddress.click();
    return new AddNewAddressPage();
  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }

  /**
   * Check if you are in MyAccountPage
   *
   * @return boolean.
   */
  public boolean IAmMyAccountPage() {
    return webDriver.getTitle().trim().equalsIgnoreCase("Addresses - My Store");
  }

  /**
   * EventClick delete an address.
   */
  public void deleteAnAddress() {
    delete.click();
    checkAlert();

  }

  /**
   * Check if is present the Alert.
   */
  private void checkAlert() {
    try {
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = webDriver.switchTo().alert();
      alert.accept();
      deleteAddress = true;
    } catch (Exception e) {
      deleteAddress = false;
    }
  }

  /**
   * Check if an deleted.
   */
  public boolean deleteAddress() {
    return deleteAddress;
  }

  /**
   * Event click for logOut.
   */
  public void clickLogOut() {
    logOut.click();
  }
}
