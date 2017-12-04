package org.fundacionjala.gui.mailapp.Entities;

/**
 * Created by German on 11/21/2017.
 */
public class Mail {
  private String to;
  private String subject;
  private String body;

  /**
   * <p>This method gets the subject.</p>
   *
   * @return subject of the mail.
   */
  public String getSubject() {
    return subject;
  }

  /**
   * <p>This method set the subject.</p>
   *
   * @param subject of the mail.
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * <p>This method gets the boby of mail.</p>
   *
   * @return the body of mail.
   */
  public String getBody() {
    return body;
  }


  /**
   * <p>This method set the body.</p>
   *
   * @param body of the mail
   */
  public void setBody(String body) {
    this.body = body;
  }

  /**
   * <p>This method gets the To send mail.</p>
   *
   * @return To address  mail.
   */
  public String getTo() {
    return to;
  }

  /**
   * <p>This method set the To send mail.</p>
   *
   * @param to of the mail
   */
  public void setTo(String to) {
    this.to = to;
  }
}
