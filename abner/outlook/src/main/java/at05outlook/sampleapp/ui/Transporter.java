package at05outlook.sampleapp.ui;


import at05outlook.core.selenium.WebDriverManager;
import at05outlook.sampleapp.config.SampleAppEnvsConfig;
import org.openqa.selenium.WebDriver;

public class Transporter {
    static Transporter instance=null;
    private String baseURL = SampleAppEnvsConfig.getInstance().getUrl();
    private WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();


    private Transporter() {

    }

    public static Transporter getInstance(){
        if(instance==null){
            return instance=new Transporter();
        }
        return instance;
    }

    public LoginPage navigateToLoginPage() {
        goToURL();
        return new LoginPage();
    }

    public HomePage login(LoginPage lo) throws InterruptedException {
        lo.login("abner.mamani@fundacion-jala.org", "Cream.com");
        return new HomePage();
    }

    public boolean isOpenInbox(HomePage homePage){
        return homePage.isLoadPage();
    }

    private void goToURL() {
        webDriver.navigate().to(baseURL);
        //webDriver..navigate().to(url);
    }

}
