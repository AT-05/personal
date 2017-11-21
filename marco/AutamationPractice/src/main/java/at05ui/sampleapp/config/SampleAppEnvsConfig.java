package at05ui.sampleapp.config;


import at05ui.core.utils.JsonReader;
import org.apache.log4j.Logger;

public class SampleAppEnvsConfig {
    private Logger log = Logger.getLogger(getClass());

    private static final String ENV_ID = "featureExample";

    private static final String ENVIRONMENTS = "Environments";
    private static final String ID = "id";
    private static final String URL = "url";
    private static final String USER_NAME = "user name";
    private static final String USER_PASSWORD = "user password";

    private JsonReader envReader;

    private String url;
    private String userName;
    private String userPassword;

    private static SampleAppEnvsConfig instance;

    protected SampleAppEnvsConfig() {

    }

    public static SampleAppEnvsConfig getInstance() {
        if (instance == null) {
            instance = new SampleAppEnvsConfig();
        }
        return instance;
    }

    public void initialize(String sampleAppEnvsConfigFileName) {
        log.info("-----Read the credentials-----");

        envReader = new JsonReader(sampleAppEnvsConfigFileName);
        url = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, URL);
        userName = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_NAME);
        System.out.println(userName+"*******************************************************************");
        userPassword = envReader.getKeyValue(ENVIRONMENTS, ID, ENV_ID, USER_PASSWORD);
    }

    public String getUrl() {
        return  url;
    }

    public String getUserName() {
        return  userName;
    }

    public String getUserPassword() {
        return  userPassword;
    }
}
