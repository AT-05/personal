package org.fundacionjala.automationproject.ui;

import static org.fundacionjala.automationproject.entities.UserInfo.USER_NAME;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_NICKNAME;
import static org.fundacionjala.automationproject.entities.UserInfo.USER_LAST_NAME;

import org.fundacionjala.automationproject.entities.UserInfo;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Franco Aldunate on 11/22/2017.
 */
public class UserConfirmationPage extends BasePage {
  @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")
  private WebElement userCompleteName;

  @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")
  private WebElement userNickName;

  public String userInfoDisplayed(UserInfo userInfo){
    final String userName = userInfo.getUserInfo().get(USER_NAME);
    final String userLastName = userInfo.getUserInfo().get(USER_LAST_NAME);
    StringBuilder valueToCompare = new StringBuilder();
    valueToCompare.append("Dear ")
      .append(userName)
      .append(" ")
      .append(userLastName)
      .append(",");
    return valueToCompare.toString();
  }
  public boolean confirmationMessageIsDisplayed(UserInfo userInfo) {
    boolean result = false;
    final String userName = userInfo.getUserInfo().get(USER_NAME);
    final String userLastName = userInfo.getUserInfo().get(USER_LAST_NAME);
    StringBuilder valueToCompare = new StringBuilder();
    valueToCompare.append("Dear ")
      .append(userName)
      .append(" ")
      .append(userLastName)
      .append(",");

    final String nickName = userInfo.getUserInfo().get(USER_NICKNAME);
    StringBuilder valueToCompare2 = new StringBuilder();
    valueToCompare2.append("Note: Your user name is ")
      .append(nickName)
      .append(".");

    if (userCompleteName.getText().equals(valueToCompare.toString())
      && userNickName.getText().equals(valueToCompare2.toString())) {
      result = true;
    }
    return result;
  }

  /**
   * <p>This method checks for correct loading of pages.</p>
   *
   * @throws WebDriverException when pages doesn't load correctly.
   */
  @Override
  public void waitUntilPageObjectIsLoaded() throws WebDriverException {

  }
}
