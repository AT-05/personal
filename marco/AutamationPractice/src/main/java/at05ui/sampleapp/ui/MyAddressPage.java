package at05ui.sampleapp.ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAddressPage extends BasedPageObject {

  @FindBy(xpath = "//div[@id='center_column']/div/a/span")
  private WebElement btnAddNewAddress;

  @FindBy(xpath = "//div[@id='center_column']/div/div/div/ul/li[9]/a[2]/span")
  private WebElement delete;

  @FindBy(className = "logout")
  private WebElement logOut;

  private boolean deleteAddress = false;

  public AddNewAddressPage goToAddNewAddress() {
    btnAddNewAddress.click();
    return new AddNewAddressPage();
  }

  @Override
  public void waitPageIsLoaded() throws WebDriverException {

  }

  public boolean IAmMyAccount() {
    return webDriver.getTitle().trim().equalsIgnoreCase("Addresses - My Store");
  }

  public void deleteAnAddress() {
    delete.click();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    checkAlert();

  }

  public void checkAlert() {
    try {
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = webDriver.switchTo().alert();
      alert.accept();
      deleteAddress = true;
    } catch (Exception e) {
      deleteAddress = false;
    }
  }

  public boolean deleteAddress() {
    return deleteAddress;
  }


  public void clickLogOut() {
    logOut.click();
  }
}
