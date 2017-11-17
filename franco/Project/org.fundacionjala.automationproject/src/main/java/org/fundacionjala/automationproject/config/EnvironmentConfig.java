package org.fundacionjala.automationproject.config;

import org.fundacionjala.automationproject.utils.JsonReader;

public class EnvironmentConfig {
  private static final String ENV_ID = "Test";
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

  public static EnvironmentConfig getInstance() {
    if (instance == null) {
      instance = new EnvironmentConfig();
    }
    return instance;
  }

  public void initEnvironmentConfiguration(String sampleAppEnvsConfigFileName) {
    environmentReader = new JsonReader(sampleAppEnvsConfigFileName);
    url = environmentReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, URL);
    userName = environmentReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_NAME);
    userPassword = environmentReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_PASSWORD);
  }

  public String getBaseUrl() {
    return url;
  }

  public String getUserName() {
    return userName;
  }

  public String getUserPassword() {
    return userPassword;
  }
}
