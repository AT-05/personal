package courses.sampleapp.entities;

/**
 * Created by Administrator on 11/20/2017.
 */
public class User {

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private static final int SIZE = 6;

  /**
   * Constructor for User.
   */
  public User() {
  }

  /**
   * Generate content random for the object.
   */
  public void generateUser() {
    firstName = GenerateString.generateStringWithNumbersAndLetters(SIZE);
    lastName = GenerateString.generateStringWithNumbersAndLetters(SIZE);
    email = String.format("%s@%s.%s", firstName, lastName,
        GenerateString.generateStringWithNumbersAndLetters(2));
    password = firstName;
  }

  /**
   * Constructor with parameters.
   * @param firstName as a string.
   * @param lastName as a string.
   * @param email as a string.
   * @param password as a string.
   */
  public User(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
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
