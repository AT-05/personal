package at05outlook.steps;

import at05outlook.sampleapp.entities.EmailEntities;
import at05outlook.sampleapp.ui.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.testng.Assert.assertTrue;

/**
 * Steps to management a email
 */
public class SendEmailSteps {
    private HomePage homePage;
    private EmailEntities email;

    /**
     * The constructor of object with dependency injection.
     * @param homePage is Page element.
     */
    public SendEmailSteps(HomePage homePage){
        this.homePage=homePage;
    }

    @When("^I go to send the new email$")
    public void preparToSendEmail() throws InterruptedException {
        homePage.goToSedEmail();
    }

    @When("^I send an email to \"(.*?)\" whit the subject of \"(.*?)\" and body \"(.*?)\"$")
    public void sendTheEmailTo(String emailToSen, String subject, String body) throws InterruptedException {
        email=new EmailEntities(emailToSen, subject, body);
        homePage.sendEmailTo(email);
    }

    @Then("^verify that the mail has arrived$")
    public void verifyThatTheMailHasArrived()  {
        assertTrue(homePage.verifyThatTheMailHasArrived(email.getSubject()), "The mail arrived correctly");
    }

    @And("^I delete an email whit the subject of \"(.*?)\"$")
    public void deleteAnEmailWhitTheSubjectOf(String subject)  {
        homePage.searchAnEmail(subject);
    }

    @Then("^verify that the mail has delete$")
    public void verifyThatTheMailHasDelete() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
