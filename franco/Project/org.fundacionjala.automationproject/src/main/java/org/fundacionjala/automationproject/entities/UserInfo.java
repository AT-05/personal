package org.fundacionjala.automationproject.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Franco Aldunate on 11/21/2017.
 */
public class UserInfo {
  public static final String USER_NAME = "FirstName";
  public static final String USER_LAST_NAME = "LastName";
  public static final String USER_PHONE = "Phone";
  public static final String USER_EMAIL = "Email";
  public static final String USER_ADDRESS = "Address";
  public static final String USER_CITY = "City";
  public static final String USER_STATE = "State";
  public static final String USER_ZIP = "Zip";
  public static final String USER_COUNTRY = "Country";
  public static final String USER_NICKNAME = "Username";
  public static final String USER_PASSWORD = "Password";

  private Map<String, String> userInfo;

  /**
   * <p>This constructor initializes the map.</p>
   */
  public UserInfo() {
    userInfo = new HashMap<>();
  }


  /**
   * <p>This method adds elements to the map.</p>
   *
   * @param key   is the value key.
   * @param value is the given value to store in the map.
   */
  public void addField(String key, String value) {
    userInfo.put(key, value);
  }

  /**
   * <p>This method sets the user info map.</p>
   */
  public void setUserInfo(Map<String, String> userInfoMap) {
    userInfo = userInfoMap;
  }

  /**
   * <p>This method returns the user info map.</p>
   *
   * @return a Map object type.
   */
  public Map<String, String> getUserInfo() {
    return userInfo;
  }
}
