package at05ui.sampleapp.Entities;

/**
 * Created by Administrator on 11/21/2017.
 */
public class Mail
{
  private String to;
  private String subject;
  private String body;

  public String getSubject() {
    return subject;
  }

  public String getBody() {
    return body;
  }

  public String getTo() {
    return to;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }
}
