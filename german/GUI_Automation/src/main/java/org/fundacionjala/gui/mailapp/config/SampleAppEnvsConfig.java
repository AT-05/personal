package org.fundacionjala.gui.mailapp.config;


import org.apache.log4j.Logger;
import org.fundacionjala.gui.core.utils.JsonReader;

/**
 * Created by German on 11/14/2017.
 */
public class SampleAppEnvsConfig {
  private static final String ENV_ID = System.getProperty("envId");
  private static final String ENVIRONMENTS = "Environments";
  private static final String ID = "id";
  private static final String URL = "url";
  private static final String USER_NAME = "user name";
  private static final String USER_PASSWORD = "user password";
  private static SampleAppEnvsConfig instance;
  private Logger log = Logger.getLogger(getClass());
  private JsonReader envReader;
  private String url;
  private String userName;
  private String userPassword;

  /**
   * <p>Constructor of the class.</p>
   */
  protected SampleAppEnvsConfig() {

  }

  /**
   * <p>This method returns the instance of the class.</p>
   *
   * @return a unique instance of this class.
   */
  public static SampleAppEnvsConfig getInstance() {
    if (instance == null) {
      instance = new SampleAppEnvsConfig();
    }
    return instance;
  }

  /**
   * <p>This method initializes Environment Configuration.</p>
   *
   * @param sampleAppEnvsConfigFileName is a Configuration File.
   */
  public void initialize(String sampleAppEnvsConfigFileName) {
    log.info("-----Read the credentials-----");

    envReader = new JsonReader(sampleAppEnvsConfigFileName);
    url = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, URL);
    userName = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_NAME);
    userPassword = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_PASSWORD);
  }

  /**
   * <p>This method gets the base url.</p>
   *
   * @return an url direction.
   */
  public String getUrl() {
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
