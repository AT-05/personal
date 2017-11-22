package courses.sampleapp.entities;

import java.util.Random;

/**
 * Created by Administrator on 11/20/2017.
 */
public class GenerateString {

  private static final String NUMBERS = "0123456789";
  //  private static String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

  /**
   * This method generate a string of numbers and letters.
   *
   * @param length size of the string.
   * @return as a string.
   */
  public static String generateStringWithNumbersAndLetters(int length) {
    return generateStringRandom(NUMBERS + LETTERS, length);
  }

  /**
   * This method generate a string random with any string as a parameter.
   *
   * @param string with the values for generate the string.
   * @param length size of the string.
   * @return the string generated.
   */
  private static String generateStringRandom(String string, int length) {
    Random rand = new Random();
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < length; i++) {
      int randIndex = rand.nextInt(string.length());
      res.append(string.charAt(randIndex));
    }
    return res.toString();
  }
}
