package at05ui.steps;

import at05outlook.sampleapp.SampleAppAutomation;
import at05outlook.sampleapp.config.SampleAppEnvsConfig;
import at05outlook.sampleapp.ui.HomePage;
import at05outlook.sampleapp.ui.LoginPage;
import at05outlook.sampleapp.ui.Transporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    private Transporter transporter;
    private LoginPage loginPage;
    private HomePage homePage;



    public LoginSteps() throws Exception {
        transporter=Transporter.getInstance();
    }


    @Given("^I navigate to Login page$")
    public void navigateToLoginPage() {
        loginPage = transporter.navigateToLoginPage();
    }

    @When("^I enter correct credentials, as user \"(.*?)\" and password \"(.*?)\"$")
    public void navigateToHomePage(String name, String password) throws InterruptedException {
        homePage=loginPage.login(name, password);
    }

    @Then("^The inbox mail is open$")
    public void inboxMailIsOpen(){
        assertTrue(homePage.isLoadPage(), "User displayed in Web");
    }


    @When("^I register whit my account$")
    public void registerWhitMyAccount() throws InterruptedException {
        homePage=loginPage.login(SampleAppEnvsConfig.getInstance().getUserName(), SampleAppEnvsConfig.getInstance().getUserPassword());
        //homePage=loginPage.login("https://outlook.office.com/", "Cream.com");
    }

    @When("^I go to send the new email$")
    public void preparToSendEmail() throws InterruptedException {
        homePage.goToSedEmail();
        //homePage=loginPage.login("https://outlook.office.com/", "Cream.com");
    }


    @When("^I send an email to \"(.*?)\" whit the subject of \"(.*?)\" and body \"(.*?)\"$")
    public void sendTheEmailTo(String email, String subject, String body) throws InterruptedException {
        homePage.sendEmailTo(email, subject, body);
    }


}
