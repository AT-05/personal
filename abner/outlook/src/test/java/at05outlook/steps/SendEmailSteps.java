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
     *
     * @param homePage is Page element.
     */
    public SendEmailSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @When("^I go to send the new email$")
    public void preparToSendEmail() throws InterruptedException {
        homePage.goToSedEmail();
    }

    @When("^I send an email to \"(.*?)\" whit the subject of \"(.*?)\" and body \"(.*?)\"$")
    public void sendTheEmailTo(String emailToSen, String subject, String body) throws InterruptedException {
        email = new EmailEntities(emailToSen, subject, body);
        homePage.sendEmailTo(email);
    }

    @Then("^verify that the mail has arrived$")
    public void verifyThatTheMailHasArrived() {
        assertTrue(homePage.verifyThatTheMailHasArrived(email.getSubject()), "The mail arrived correctly");
    }

    @And("^I delete an email whit the subject of \"(.*?)\"$")
    public void deleteAnEmailWhitTheSubjectOf(String subject) {
        email=new EmailEntities("", subject, "");
        homePage.deleteAnEmail(email.getSubject());
    }

    @Then("^verify that the mail was deleted$")
    public void verifyThatTheMailHasDelete() throws Throwable {
        assertTrue(homePage.verifyThatTheEmailWasDeleted(email.getSubject()), "The email was deleted");
        throw new PendingException();
    }
}
