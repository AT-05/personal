package courses.sampleapp.Classes;

/**
 * Created by Administrator on 11/20/2017.
 */
public class User {

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private final int SIZE = 6;

  /**
   * Constructor for User.
   */
  public User() {
    firstName = GenerateString.generateStringWithNumbersAndLetters(SIZE);
    lastName = GenerateString.generateStringWithNumbersAndLetters(SIZE);
    email = String.format("%s@%s.%s", firstName, lastName,
        GenerateString.generateStringWithNumbersAndLetters(2));
    password = firstName;
  }

  /**
   * Get the first name.
   *
   * @return as a string.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the last name.
   *
   * @return as a string.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the email.
   *
   * @return as a string.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Get the password.
   *
   * @return as a string.
   */
  public String getPassword() {
    return password;
  }
}
