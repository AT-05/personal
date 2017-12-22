package at05outlook.sampleapp.ui;


import at05outlook.core.selenium.WebDriverManager;
import at05outlook.sampleapp.config.SampleAppEnvsConfig;
import org.openqa.selenium.WebDriver;

/**
 * It is the link between the pages and the steps
 */
public class Transporter {
    static Transporter instance=null;
    private String baseURL = SampleAppEnvsConfig.getInstance().getUrl();
    private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();

    /**
     * Constuct of the object.
     */
    private Transporter() {

    }

    /**
     * Is return the object singleton.
     * @return singleton object.
     */
    public static Transporter getInstance(){
        if(instance==null){
            return instance=new Transporter();
        }
        return instance;
    }

    /**
     * It is to navigate of URL.
     * @return object of the login page
     */
    public LoginPage navigateToLoginPage() {
        goToURL();
        return new LoginPage();
    }


    /**
     * this verify if the inbox is open.
     * @param homePage is a BasedPage.
     * @return (true/false)of the check.
     */
    public boolean isOpenInbox(HomePage homePage){
        return homePage.isLoadPage();
    }

    /**
     *It is to navigate of URL.
     */
    private void goToURL() {
        webDriver.navigate().to(baseURL);
        //webDriver..navigate().to(url);
    }
}
