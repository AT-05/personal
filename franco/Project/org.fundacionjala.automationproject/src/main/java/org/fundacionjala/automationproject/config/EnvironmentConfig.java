package org.fundacionjala.automationproject.config;

import org.fundacionjala.automationproject.utils.JsonReader;

/**
 * Created by Franco Aldunate on 11/14/2017.
 */
public class EnvironmentConfig {
  private static final String ENV_ID = "Env1";
  private static final String ENVIRONMENTS = "Environments";
  private static final String ID = "id";
  private static final String URL = "url";
  private static final String USER_NAME = "username";
  private static final String USER_PASSWORD = "userpassword";

  private JsonReader environmentReader;

  private String url;
  private String userName;
  private String userPassword;

  private static EnvironmentConfig instance;

  /**
   * <p>This method returns the instance of the class.</p>
   *
   * @return a unique instance of this class.
   */
  public static EnvironmentConfig getInstance() {
    if (instance == null) {
      instance = new EnvironmentConfig();
    }
    return instance;
  }

  /**
   * <p>This method initializes Environment Configuration.</p>
   *
   * @param sampleAppEnvsConfigFileName is a Configuration File.
   */
  public void initEnvironmentConfiguration(String sampleAppEnvsConfigFileName) {
    environmentReader = new JsonReader(sampleAppEnvsConfigFileName);
    url = environmentReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, URL);
    userName = environmentReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_NAME);
    userPassword = environmentReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_PASSWORD);
  }

  /**
   * <p>This method gets the base url.</p>
   *
   * @return an url direction.
   */
  public String getBaseUrl() {
    return url;
  }

  /**
   * <p>This method returns the user name of the current environment.</p>
   *
   * @return user name.
   */
  public String getUserName() {
    return userName;
  }

  /**
   * <p>This method returns the user password of the current environment.</p>
   *
   * @return user password.
   */
  public String getUserPassword() {
    return userPassword;
  }
}
