package at05outlook.sampleapp.entities;

/**
 * Entities class to management
 */
public class EmailEntities {
    private String sendTo;
    private String subject;
    private String body;

    /**
     * Constuctor the object.
     * @param sendTo email to send a email.
     * @param subject sunject to send a email.
     * @param body body to send a email.
     */
    public EmailEntities(String sendTo, String subject, String body) {
        this.sendTo = sendTo;
        this.subject = subject;
        this.body = body;
    }

    /**
     * Geter of the email.
     * @return email.
     */
    public String getSendTo() {
        return sendTo;
    }

    /**
     * Geter of the subject.
     * @return subject.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Geter of the boby.
     * @return body.
     */
    public String getBody() {
        return body;
    }
}
