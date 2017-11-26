package org.fundacionjala.automationproject.ui;

import java.util.List;
import org.fundacionjala.automationproject.entities.User;
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
   * @param userList is a list of User entity object type that holds user
   *                 registration info.
   * @return the displayed user info message.
   */
  private String userInfoDisplayed(List<User> userList) {
    String firstName;
    String lastName;
    final StringBuilder result = new StringBuilder();

    for (User userItem : userList) {
      firstName = userItem.getFirstName();
      lastName = userItem.getLastName();
      result.append("Dear ")
        .append(firstName)
        .append(" ")
        .append(lastName)
        .append(",");
    }
    return result.toString();
  }

  /**
   * <p>this method shows user nick name displayed
   * as part of user registration result message.</p>
   *
   * @param userList is a list of User entity object type that holds user
   *                 registration info.
   * @return the displayed user nick name message.
   */
  private String userNickNameDisplayed(List<User> userList) {
    String userName;
    final StringBuilder result = new StringBuilder();

    for (User userItem : userList) {
      userName = userItem.getUserName();
      result.append("Note: Your user name is ")
        .append(userName)
        .append(".");
    }
    return result.toString();
  }

  /**
   * <p>This method checks user registration result message compliance.</p>
   *
   * @param userList is a list of User entity object type that holds user
   *                 registration info.
   * @return whether the given user registration result message
   * is correct or not.
   */
  public boolean confirmationMessageIsDisplayed(List<User> userList) {
    boolean result = false;
    final String userNameResult = userInfoDisplayed(userList);
    final String userNickNameResult = userNickNameDisplayed(userList);

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
