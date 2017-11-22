package at05outlook.sampleapp.entities;

public class EmailEntities {
    //| User Name                       | Subject       | Body    |
    private String sendTo;
    private String subject;
    private String  body;

    public EmailEntities(String sendTo, String subject, String body) {
        this.sendTo = sendTo;
        this.subject = subject;
        this.body = body;
    }


    public String getSendTo() {
        return sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
