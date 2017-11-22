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
  @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/"
    + "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")
  private WebElement userCompleteName;

  @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/"
    + "table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")
  private WebElement userNickName;

  /**
   * <p>this method shows user info displayed
   * as part of user registration result message.</p>
   *
   * @param userInfo is an entity class that holds user
   *                 registration info.
   * @return the displayed user info message.
   */
  private String userInfoDisplayed(UserInfo userInfo) {
    final String userName = userInfo.getUserInfo().get(USER_NAME);
    final String userLastName = userInfo.getUserInfo().get(USER_LAST_NAME);
    StringBuilder result = new StringBuilder();
    result.append("Dear ")
      .append(userName)
      .append(" ")
      .append(userLastName)
      .append(",");
    return result.toString();
  }

  /**
   * <p>this method shows user nick name displayed
   * as part of user registration result message.</p>
   *
   * @param userInfo is an entity class that holds user
   *                 registration info.
   * @return the displayed user nick name message.
   */
  private String userNickNameDisplayed(UserInfo userInfo) {
    final String nickName = userInfo.getUserInfo().get(USER_NICKNAME);
    StringBuilder result = new StringBuilder();
    result.append("Note: Your user name is ")
      .append(nickName)
      .append(".");
    return result.toString();
  }

  /**
   * <p>This method checks user registration result message compliance.</p>
   *
   * @param userInfo is an entity class that holds user
   *                 registration info.
   * @return whether the given user registration result message
   * is correct or not.
   */
  public boolean confirmationMessageIsDisplayed(UserInfo userInfo) {
    boolean result = false;
    final String userNameResult = userInfoDisplayed(userInfo);
    final String userNickNameResult = userNickNameDisplayed(userInfo);

    if (userCompleteName.getText().equals(userNameResult)
      && userNickName.getText().equals(userNickNameResult)) {
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
