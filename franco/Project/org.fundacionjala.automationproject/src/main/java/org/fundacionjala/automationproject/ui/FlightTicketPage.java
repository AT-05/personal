package org.fundacionjala.automationproject.ui;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 11/20/2017.
 */
public class FlightTicketPage extends BasePage {
  @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]"
    + "/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]"
    + "/table/tbody/tr[5]/td/table/tbody/tr[9]/td/p/font[1]/text()[1]")
  private WebElement billedTo;

  @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]"
    + "/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]"
    + "/table/tbody/tr[5]/td/table/tbody/tr[12]/td/table/tbody/tr[2]/td[2]/font/b/font/font/b")
  private WebElement totalPrice;

  /**
   * <p>This method checks for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }

  /**
   * <p>This method checks of purchased flight billing information is correct.</p>
   *
   * @param totalPriceInput is the billing total price.
   * @return whether the total price is equal to the value given or not.
   */
  public boolean verifyBillInfo(String totalPriceInput) {
    final String totalPriceValue = totalPrice.getText();
    return totalPriceValue.equals(totalPriceInput);
    //return billedTo.getText().equals(arg0);
  }
}
