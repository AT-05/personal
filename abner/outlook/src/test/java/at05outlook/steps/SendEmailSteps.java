package at05outlook.steps;

import at05outlook.sampleapp.ui.HomePage;
import cucumber.api.java.en.When;

public class SendEmailSteps {
    private HomePage homePage;

    public SendEmailSteps(HomePage homePage){
        this.homePage=homePage;
    }

    @When("^I go to send the new email$")
    public void preparToSendEmail() throws InterruptedException {
        homePage.goToSedEmail();
    }


    @When("^I send an email to \"(.*?)\" whit the subject of \"(.*?)\" and body \"(.*?)\"$")
    public void sendTheEmailTo(String email, String subject, String body) throws InterruptedException {
        homePage.sendEmailTo(email, subject, body);
    }
}
